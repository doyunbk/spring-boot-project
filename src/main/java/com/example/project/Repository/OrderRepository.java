package com.example.project.Repository;

import com.example.project.Model.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(value = "SELECT order_id as orderId, user_id as userId, product_id as productId, title as title, " +
            "total_investment_amt as totalInvestmentAmt, invest_amt as investAmt, " +
            "created_at as createdAt FROM Orders WHERE user_id = :userId", nativeQuery = true )
    List<Order> getOrderByUserId(@Param("userId") long userId);

}
