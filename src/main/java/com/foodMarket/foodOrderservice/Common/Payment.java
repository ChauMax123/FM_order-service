package com.foodMarket.foodOrderservice.Common;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "FOOD_PAYMENT_TBL")
@Data
@AllArgsConstructor
@NoArgsConstructor


public class Payment {
    @Id
    @GeneratedValue
    private int paymentId;
    private String status;
    private String transactionId;
    private int foodOrderId;
    private double amount;

}
