package com.foodMarket.foodOrderservice.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.foodMarket.foodOrderservice.Common.Payment;
import com.foodMarket.foodOrderservice.Common.TransactionRequest;
import com.foodMarket.foodOrderservice.Common.TransactionResponse;
import com.foodMarket.foodOrderservice.Entity.Food;
import com.foodMarket.foodOrderservice.Repository.FoodOrderRepository;
//import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@RefreshScope

public class FoodOrderService {
    @Autowired
    private FoodOrderRepository foodOrderRepository;

    @Autowired
    @Lazy
    private RestTemplate restTemplate;

    @Value("${microservice.food-payment-service.endpoints.endpoint.uri}")
    private String ENDPOINT_URL;

    private Logger log= LoggerFactory.getLogger(FoodOrderService.class);

   // @CircuitBreaker(name = "paymentService", fallbackMethod = "paymentServiceFallback")
    public TransactionResponse saveFoodOrder(TransactionRequest request) throws JsonProcessingException {
        String response = "";

        Food foodOrder = request.getFoodOrder();
        Payment foodPayment = new Payment();

        foodPayment.setFoodOrderId(foodOrder.getFoodItemId());
        foodPayment.setAmount(foodOrder.getPrice());

        // sending data using post request / RESt Call
        log.info("OrderService request : {}", new ObjectMapper().writeValueAsString(request));

        Payment paymentResponse = restTemplate.postForObject(ENDPOINT_URL, foodPayment, Payment.class);

        log.info("PaymentService response from OrderService REST call : {}", new ObjectMapper().writeValueAsString(paymentResponse));
        response = paymentResponse.getStatus().equals("success") ? "Payment Successful, food ordered" : "Payment failed, item added to the cart";

        foodOrderRepository.save(foodOrder);

        return new TransactionResponse(foodOrder, paymentResponse.getTransactionId(), paymentResponse.getAmount(), response);

    }

//    public TransactionResponse paymentServiceFallback(TransactionRequest request, Throwable t) {
//        System.err.println("Payment service fallback invoked due to: " + t.getMessage());
//        // Return a fallback response, potentially with error details
//        return (new TransactionResponse(null, null, 0, "Payment service unavailable. Please try again later."));
//    }
}
