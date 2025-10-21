package com.next_website_be.DTO;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Integer id;
    private String username;
    private String email;
    private String phone;
    private String fullName;
    private String avatarUrl;
    private Integer roleId;
}
