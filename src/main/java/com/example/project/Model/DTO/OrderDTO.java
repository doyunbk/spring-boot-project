package com.example.project.Model.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.Date;

@Data
@Component
public class OrderDTO {

    private long userId;
    private long productId;
    private long investAmt;
    private String title;
    private long totalInvestmentAmt;
    private LocalDate createdAt;
    private String message;

}
