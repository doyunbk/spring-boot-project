package com.example.project.Repository;

import com.example.project.Model.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT product_id as productId, title as title, " +
            "total_investment_amt as totalInvestmentAmt, current_investment_amt as currentInvestmentAmt, " +
            "no_of_investors as noOfInvestors, status as status, start_at as startAt, finish_at as finishAt " +
            "FROM Product", nativeQuery = true )
    List<Product> getAllProducts();

    @Query(value = "SELECT product_id as productId, title as title, " +
            "total_investment_amt as totalInvestmentAmt, current_investment_amt as currentInvestmentAmt, " +
            "no_of_investors as noOfInvestors, status as status, start_at as startAt, finish_at as finishAt " +
            "FROM Product WHERE start_at <= :currentDate AND finish_at >= :currentDate AND status = true ", nativeQuery = true )
    List<Product> getProductsByTimePeriod(LocalDate currentDate);

    @Query(value = "SELECT product_id as productId, title as title, " +
            "total_investment_amt as totalInvestmentAmt, current_investment_amt as currentInvestmentAmt, " +
            "no_of_investors as noOfInvestors, status as status, start_at as startAt, finish_at as finishAt " +
            "FROM Product WHERE product_id = :productId", nativeQuery = true )
    Product getProductByProductId(@Param("productId") long productId);

}
