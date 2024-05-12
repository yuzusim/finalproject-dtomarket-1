package com.example.finalprojectdtomarket.order;

import com.example.finalprojectdtomarket.cart.Cart;
import com.example.finalprojectdtomarket.cart.CartResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface OrderJPARepository extends JpaRepository<Order, Integer> {

    // @Query 사용하여 복잡한 쿼리 정의
    @Query("SELECT c FROM Cart c JOIN FETCH c.product p JOIN FETCH c.user u WHERE u.id = :userId AND c.isChecked = :isChecked")
    List<Cart> findByUserIdAndIsCheckedWithJoinFetch(int userId);
}
