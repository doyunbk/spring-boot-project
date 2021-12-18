package com.example.project.Model;

import com.example.project.Model.Entity.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDate;


@SpringBootTest
@DisplayName("Testing For Order Entity")
public class OrderTest {

    @Test
    @DisplayName("Should Create Order Entity")
    void should_create_order_entity(){
        LocalDate localDate = LocalDate.now();

        Order order = new Order();

        order.setUserId(1);
        order.setProductId(1);
        order.setTitle("bond");
        order.setTotalInvestmentAmt(1000);
        order.setInvestAmt(100);
        order.setCreatedAt(localDate);

        assertThat(order).isNotNull();
        assertThat(order.getUserId()).isEqualTo(1);
        assertThat(order.getProductId()).isEqualTo(1);
        assertThat(order.getTitle()).isEqualTo("bond");
        assertThat(order.getTotalInvestmentAmt()).isEqualTo(1000);
        assertThat(order.getInvestAmt()).isEqualTo(100);

    }

}
