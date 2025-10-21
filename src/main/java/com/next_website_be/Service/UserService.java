package com.next_website_be.Service;

import com.next_website_be.DTO.UserDTO;
import com.next_website_be.Entities.Role;
import com.next_website_be.Entities.User;
import com.next_website_be.Exception.BadRequestException;
import com.next_website_be.Exception.ResourceNotFoundException;
import com.next_website_be.Mapper.UserMapper;
import com.next_website_be.Repository.RoleRepository;
import com.next_website_be.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;
//    private final PasswordEncoder passwordEncoder;

    /**
     * Lấy toàn bộ user (ở dạng DTO)
     */
    public List<UserDTO> getAllUsers() {
        try {
            return userRepository.findAll()
                    .stream()
                    .map(userMapper::toDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new BadRequestException("Failed to retrieve users: " + e.getMessage());
        }
    }

    /**
     * Lấy user theo id
     */
    public UserDTO getUserById(String id) {
        try {
            User user = userRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
            return userMapper.toDTO(user);
        } catch (ResourceNotFoundException e) {
            throw e; // ném tiếp cho GlobalExceptionHandler xử lý
        } catch (Exception e) {
            throw new BadRequestException("Failed to get user: " + e.getMessage());
        }
    }

    /**
     * Tạo user mới
     */
    public UserDTO createUser(UserDTO dto) {
        try {
            if (userRepository.findByUsername(dto.getUsername()).isPresent()) {
                throw new BadRequestException("Username already exists: " + dto.getUsername());
            }

            User user = userMapper.toEntity(dto);

            // Mã hóa mật khẩu nếu có
//            if (user.getPassword() != null) {
//                user.setPassword(passwordEncoder.encode(user.getPassword()));
//            }

            // Gán role nếu có roleId
            if (dto.getRoleId() != null) {
                Role role = roleRepository.findById(dto.getRoleId())
                        .orElseThrow(() -> new ResourceNotFoundException("Role not found with id: " + dto.getRoleId()));
                user.setRoles(Set.of(role));
            }

            User savedUser = userRepository.save(user);
            return userMapper.toDTO(savedUser);

        } catch (ResourceNotFoundException | BadRequestException e) {
            throw e; // ném lại để GlobalExceptionHandler xử lý đúng loại lỗi
        } catch (Exception e) {
            throw new BadRequestException("Failed to create user: " + e.getMessage());
        }
    }

    /**
     * Cập nhật thông tin user
     */
    public UserDTO updateUser(String id, UserDTO dto) {
        try {
            User user = userRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));

            user.setUsername(dto.getUsername());
            user.setFullName(dto.getFullName());
            user.setEmail(dto.getEmail());
            user.setPhone(dto.getPhone());

            if (dto.getRoleId() != null) {
                Role role = roleRepository.findById(dto.getRoleId())
                        .orElseThrow(() -> new ResourceNotFoundException("Role not found with id: " + dto.getRoleId()));
                user.setRoles(Set.of(role));
            }

            User updatedUser = userRepository.save(user);
            return userMapper.toDTO(updatedUser);

        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new BadRequestException("Failed to update user: " + e.getMessage());
        }
    }

    /**
     * Xóa user theo id
     */
    public void deleteUser(String id) {
        try {
            if (!userRepository.existsById(id)) {
                throw new ResourceNotFoundException("User not found with id: " + id);
            }
            userRepository.deleteById(id);
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new BadRequestException("Failed to delete user: " + e.getMessage());
        }
    }

    /**
     * Tìm user theo username (dùng cho đăng nhập)
     */
    public Optional<Object> findByUsername(String username) {
        try {
            return userRepository.findByUsername(username);
        } catch (Exception e) {
            throw new BadRequestException("Failed to find user by username: " + e.getMessage());
        }
    }
}
