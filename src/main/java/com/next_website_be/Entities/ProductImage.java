package com.next_website_be.Entities;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "product_images")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductImage extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String imageUrl;

    private Boolean isMain; // đánh dấu ảnh chính

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}

