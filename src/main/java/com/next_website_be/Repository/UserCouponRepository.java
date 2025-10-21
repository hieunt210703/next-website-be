package com.next_website_be.Repository;

import com.next_website_be.Entities.UserCoupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCouponRepository extends JpaRepository<UserCoupon,Integer> {
}
