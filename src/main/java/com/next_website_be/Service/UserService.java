package com.next_website_be.Service;

import com.next_website_be.DTO.UserDTO;
import com.next_website_be.Entities.Role;
import com.next_website_be.Entities.User;
import com.next_website_be.Mapper.UserMapper;
import com.next_website_be.Repository.RoleRepository;
import com.next_website_be.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;


    // 🟢 Lấy tất cả user
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDTO)
                .toList();
    }

    // 🟢 Lấy user theo ID
    public UserDTO getUserById(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        return userMapper.toDTO(user);
    }

    // 🟢 Tạo user mới
    public UserDTO createUser(UserDTO dto) {
        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("Email already exists: " + dto.getEmail());
        }

        User user = userMapper.toEntity(dto);
        String randomPassword = UUID.randomUUID().toString().substring(0, 8);
        user.setPassword(randomPassword);
        // có thể mã hoá sau này

        // Gán role nếu có
        if (dto.getRoleId() != null) {
            Role role = roleRepository.findById(dto.getRoleId())
                    .orElseThrow(() -> new RuntimeException("Role not found with id: " + dto.getRoleId()));
            user.setRole(role);
        }

        return userMapper.toDTO(userRepository.save(user));
    }

    // 🟢 Cập nhật thông tin user
    public UserDTO updateUser(String id, UserDTO dto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        user.setUsername(dto.getUsername());
        user.setFullName(dto.getFullName());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());
        user.setGender(dto.getGender());
        user.setAddress(dto.getAddress());

        // Gán lại role (nếu có)
        if (dto.getRoleId() != null) {
            Role role = roleRepository.findById(dto.getRoleId())
                    .orElseThrow(() -> new RuntimeException("Role not found with id: " + dto.getRoleId()));
            user.setRole(role);
        }

        return userMapper.toDTO(userRepository.save(user));
    }

    // 🟢 Xoá user
    public void deleteUser(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        userRepository.delete(user);
    }

    // 🟢 Cập nhật role cho user (thay vì add/remove)
    public UserDTO updateUserRole(String userId, String roleId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found: " + userId));

        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Role not found: " + roleId));

        user.setRole(role);

        return userMapper.toDTO(userRepository.save(user));
    }
}
