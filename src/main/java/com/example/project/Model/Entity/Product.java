package com.example.project.Model.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "product_id")
    private long productId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "total_investment_amt", nullable = false)
    private long totalInvestmentAmt;

    @Column(name = "current_investment_amt", nullable = false)
    private long currentInvestmentAmt;

    @Column(name = "no_of_investors", nullable = false)
    private long noOfInvestors;

    @Column(name = "status", nullable = false)
    private Boolean status;

    @Column(name = "start_at", nullable = false)
    private LocalDate startAt;

    @Column(name = "finish_at", nullable = false)
    private LocalDate finishAt;

}
