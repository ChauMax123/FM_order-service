package com.foodMarket.foodOrderservice.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.foodMarket.foodOrderservice.Common.TransactionRequest;
import com.foodMarket.foodOrderservice.Common.TransactionResponse;
import com.foodMarket.foodOrderservice.Service.FoodOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/order")

public class FoodController {
    @Autowired
    private  FoodOrderService foodOrderService;
    @PostMapping("/foodOrder")
    public TransactionResponse bookFood(@RequestBody TransactionRequest request) throws JsonProcessingException {

        return foodOrderService.saveFoodOrder(request);
    }

}
