package com.next_website_be.ApiResponse.DTO_Response;

import lombok.Data;

@Data
public class ProfileDTO {
    private String username;
    private String fullName;
    private String email;
    private String phone;
    private Boolean gender;
    private String address;
}
