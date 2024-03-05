package com.foodMarket.foodOrderservice.Common;

import com.foodMarket.foodOrderservice.Entity.Food;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TransactionResponse {

    private Food foodOrder;
    private String transactionId;
    private double amount;
    private String message;

}
