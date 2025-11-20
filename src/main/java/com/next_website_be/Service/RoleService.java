package com.next_website_be.Service;

import com.next_website_be.DTO.RoleDTO;
import com.next_website_be.Entities.Role;
import com.next_website_be.Exception.BadRequestException;
import com.next_website_be.Exception.ResourceNotFoundException;
import com.next_website_be.Mapper.RoleMapper;
import com.next_website_be.Repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    // 🟢 Lấy tất cả role
    public List<RoleDTO> getAllRoles() {
        return roleRepository.findAll()
                .stream()
                .map(roleMapper::toDTO)
                .toList();
    }

    // 🟢 Lấy role theo ID
    public RoleDTO getRoleById(String id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found with id: " + id));
        return roleMapper.toDTO(role);
    }

    // 🟢 Tạo role mới
    public RoleDTO createRole(RoleDTO dto) {
        if (roleRepository.existsByName((dto.getName()))) {
            throw new BadRequestException("Role name already exists: " + dto.getName());
        }

        Role role = roleMapper.toEntity(dto);
        Role saved = roleRepository.save(role);
        return roleMapper.toDTO(saved);
    }

    // 🟢 Cập nhật role
    public RoleDTO updateRole(String id, RoleDTO dto) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found with id: " + id));

        // Nếu tên role mới bị trùng với role khác
        if (roleRepository.existsByName(dto.getName()) && !role.getName().equals(dto.getName())) {
            throw new BadRequestException("Role name already in use: " + dto.getName());
        }

        role.setName(dto.getName());
        role.setDescription(dto.getDescription());

        Role updated = roleRepository.save(role);
        return roleMapper.toDTO(updated);
    }

    public void deleteRole(String roleId) {
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found"));
        roleRepository.save(role);
    }

}
