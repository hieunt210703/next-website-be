package com.next_website_be.Entities;
import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Entity
@Table(name = "brands")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Brand extends Base {

    @Column(nullable = false)
    private String name;

    private String description;

    private String logoUrl;

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "brand_categories",
            joinColumns = @JoinColumn(name = "brand_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();
}

