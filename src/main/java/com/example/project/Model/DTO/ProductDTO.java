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
public class ProductDTO {

    private long productId;
    private String title;
    private long totalInvestmentAmt;
    private long currentInvestmentAmt;
    private long noOfInvestors;
    private boolean status;
    private LocalDate startAt;
    private LocalDate finishAt;

}
