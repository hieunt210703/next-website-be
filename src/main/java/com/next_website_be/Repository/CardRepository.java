package com.next_website_be.Repository;

import com.next_website_be.Entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Cart,Integer> {
}
