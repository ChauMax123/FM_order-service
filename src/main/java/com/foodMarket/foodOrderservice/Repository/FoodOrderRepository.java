package com.foodMarket.foodOrderservice.Repository;

import com.foodMarket.foodOrderservice.Entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodOrderRepository extends JpaRepository<Food, Integer> {
}
