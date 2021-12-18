package com.example.project.Repository;

import com.example.project.Model.Entity.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@DisplayName("Testing For Order Repository")
public class OrderRepositoryTest {

    @Autowired
    OrderRepository orderRepository;

    @Test
    @DisplayName("Should Get Products By Product Id")
    void should_get_products_by_product_id(){
        List<Order> order = orderRepository.getOrderByUserId(1);
        assertThat(order).hasSize(1);

        assertThat(order.get(0).getProductId()).isEqualTo(7);
        assertThat(order.get(0).getInvestAmt()).isEqualTo(100);
        assertThat(order.get(0).getTotalInvestmentAmt()).isEqualTo(2500);
        assertThat(order.get(0).getTitle()).isEqualTo("security");
    }

}
