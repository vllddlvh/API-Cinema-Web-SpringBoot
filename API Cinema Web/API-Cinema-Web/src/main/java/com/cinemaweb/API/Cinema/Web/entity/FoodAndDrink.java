package com.cinemaweb.API.Cinema.Web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FoodAndDrink {
    @Id
    int foodAndDrinkId;

    String foodAndDrinkName;
    int roomId;
    double foodAndDrinkPrice;
}
