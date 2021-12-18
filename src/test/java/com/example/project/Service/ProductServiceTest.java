package com.example.project.Service;

import com.example.project.Model.Entity.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@DisplayName("Testing For Product Service")
public class ProductServiceTest {

    @Autowired
    ProductService productService;

    @Test
    @DisplayName("Should Get All Products")
    void should_get_all_products(){
        List<Product> products = productService.getAllProductList();
        assertThat(products).hasSize(13);
    }

    @Test
    @DisplayName("Should Get Products By Time Period")
    void should_get_products_by_time_period(){
        LocalDate localDate = LocalDate.now();
        List<Product> products = productService.getProductsByTimePeriod(localDate);
        assertThat(products).hasSize(8);
    }
}
