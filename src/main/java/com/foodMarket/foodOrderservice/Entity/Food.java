package com.foodMarket.foodOrderservice.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ORDER_TBL")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Food {
    @Id
    @GeneratedValue
    private int orderId;
    private int foodItemId;
    private String name;
    private String type;
    private double quantity;
    private double price;
}
