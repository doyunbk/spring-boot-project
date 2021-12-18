package com.example.project.Model.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name="Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "order_id", nullable = false)
    private long order_id;

    @Column(name = "user_id", nullable = false)
    private long userId;

    @Column(name = "product_id", nullable = false)
    private long productId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "total_investment_amt", nullable = false)
    private long totalInvestmentAmt;

    @Column(name = "investAmt", nullable = false)
    private long investAmt;

    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt;
}
