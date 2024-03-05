package com.foodMarket.foodOrderservice.Common;

import com.foodMarket.foodOrderservice.Entity.Food;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TransactionRequest {
    private Food foodOrder;
    private Payment foodPayment;

}
