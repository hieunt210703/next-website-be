package com.next_website_be.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "addresses")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address extends Base {

    private String street;
    private String city;
    private String province;
    private String postalCode;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
