package com.example.project.Service;


import com.example.project.Model.DTO.OrderDTO;
import com.example.project.Model.Entity.Order;
import com.example.project.Model.Entity.Product;
import com.example.project.Repository.OrderRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@DisplayName("Testing For Order Service")
public class OrderServiceTest {

    @Autowired
    OrderService orderService;

    @Test
    @DisplayName("Should Get Products By Product Id")
    void should_get_products_by_product_id(){
        List<Order> order = orderService.getOrders(1);
        assertThat(order).hasSize(1);

        assertThat(order.get(0).getProductId()).isEqualTo(7);
        assertThat(order.get(0).getInvestAmt()).isEqualTo(100);
        assertThat(order.get(0).getTotalInvestmentAmt()).isEqualTo(2500);
        assertThat(order.get(0).getTitle()).isEqualTo("security");
    }

    @Test
    @DisplayName("Should Create Order")
    void should_create_order(){
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setUserId(1);
        orderDTO.setProductId(1);
        orderDTO.setInvestAmt(100);

        Product product = orderService.validateProduct(orderDTO);

        assertThat(product).isNotNull();
    }

    @Test
    @DisplayName("Should Validate Order")
    void should_validate_order(){
        LocalDate localDate = LocalDate.now();

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setUserId(1);
        orderDTO.setProductId(1);
        orderDTO.setTitle("bond");
        orderDTO.setTotalInvestmentAmt(1000);
        orderDTO.setInvestAmt(100);
        orderDTO.setCreatedAt(localDate);

        Product product = orderService.validateProduct(orderDTO);

        assertThat(product).isNotNull();
    }

    @Test
    @DisplayName("Should Not Validate Order When Total Amount Exceeds Limit")
    void should_not_validate_order_when_total_investment_amt_exceeds_limit(){
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setUserId(1);
        orderDTO.setProductId(1);
        orderDTO.setInvestAmt(1000);

        assertThatExceptionOfType(Exception.class).isThrownBy(()->orderService.validateProduct(orderDTO));

    }

}
