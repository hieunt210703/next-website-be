package com.next_website_be.Service;

import com.next_website_be.DTO.RoleDTO;
import com.next_website_be.Entities.Role;
import com.next_website_be.Mapper.RoleMapper;
import com.next_website_be.Repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    public List<RoleDTO> getAllRoles() {
        return roleRepository.findAll()
                .stream()
                .map(roleMapper::toDTO)
                .toList();
    }

    public RoleDTO getRoleById(String id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found with id: " + id));
        return roleMapper.toDTO(role);
    }

    public RoleDTO createRole(RoleDTO dto) {
        Role role = roleMapper.toEntity(dto);
        Role saved = roleRepository.save(role);
        return roleMapper.toDTO(saved);
    }

    public RoleDTO updateRole(String id, RoleDTO dto) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found with id: " + id));

        role.setName(dto.getName());
        role.setDescription(dto.getDescription());

        Role updated = roleRepository.save(role);
        return roleMapper.toDTO(updated);
    }

    public void deleteRole(String id) {
        if (!roleRepository.existsById(id)) {
            throw new RuntimeException("Role not found with id: " + id);
        }
        roleRepository.deleteById(id);
    }
}
