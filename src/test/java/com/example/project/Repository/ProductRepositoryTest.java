package com.example.project.Repository;


import com.example.project.Model.Entity.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@DisplayName("Testing For Product Repository")
public class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;


    @Test
    @DisplayName("Should Get All Products")
    void should_get_all_products(){
        List<Product> allProducts = productRepository.getAllProducts();
        assertThat(allProducts).hasSize(13);
    }

    @Test
    @DisplayName("Should Get Products By Time Period")
    void should_get_products_by_time_period(){
        LocalDate localDate = LocalDate.now();
        List<Product> products = productRepository.getProductsByTimePeriod(localDate);
        assertThat(products).hasSize(8);
    }

    @Test
    @DisplayName("Should Get Products By Product Id")
    void should_get_products_by_product_id(){
        Product product = productRepository.getProductByProductId(1);
        assertThat(product).isNotNull();
        assertThat(product.getTotalInvestmentAmt()).isEqualTo(1000);
        assertThat(product.getCurrentInvestmentAmt()).isEqualTo(100);
        assertThat(product.getNoOfInvestors()).isEqualTo(10);
        assertThat(product.getStatus()).isEqualTo(true);
        assertThat(product.getTitle()).isEqualTo("annuity");
    }
}
