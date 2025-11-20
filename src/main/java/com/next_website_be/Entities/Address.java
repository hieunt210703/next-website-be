package com.next_website_be.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "addresses")
@Getter
@Setter
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
