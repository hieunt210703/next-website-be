package com.next_website_be.DTO;

import lombok.*;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String id;
    private String username;
    private String fullName;
    private String email;
    private String phone;
    private Boolean gender;
    private String address;
    private boolean isDeleted = false;
    private String roleId;
    private String roleName;
}
