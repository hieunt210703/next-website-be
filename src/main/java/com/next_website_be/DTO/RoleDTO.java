package com.next_website_be.DTO;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO {
    private String id;
    private String name;
    private String description;
}
