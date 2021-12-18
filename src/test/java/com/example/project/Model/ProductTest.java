package com.example.project.Model;

import com.example.project.Model.Entity.Order;
import com.example.project.Model.Entity.Product;
import lombok.Builder;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@DisplayName("Testing For Product Entity")
@Builder(toBuilder = true)
public class ProductTest {

    @Test
    @DisplayName("Should Create Product Entity")
    void should_create_product_entity(){
        LocalDate startAt = LocalDate.now();
        LocalDate finishAt = startAt.plusDays(30);

        Product product = new Product();

        product.setTitle("stock");
        product.setTotalInvestmentAmt(1000);
        product.setCurrentInvestmentAmt(100);
        product.setNoOfInvestors(10);
        product.setStatus(true);
        product.setStartAt(startAt);
        product.setFinishAt(finishAt);

        assertThat(product).isNotNull();
        assertThat(product.getTitle()).isEqualTo("stock");
        assertThat(product.getTotalInvestmentAmt()).isEqualTo(1000);
        assertThat(product.getCurrentInvestmentAmt()).isEqualTo(100);
        assertThat(product.getNoOfInvestors()).isEqualTo(10);
        assertThat(product.getStatus()).isEqualTo(true);

    }

}
