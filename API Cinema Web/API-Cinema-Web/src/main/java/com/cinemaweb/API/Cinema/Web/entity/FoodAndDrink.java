package com.cinemaweb.API.Cinema.Web.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "foodanddrink")
public class FoodAndDrink {
    @Column(name = "fd_id")
    @Id
    int foodAndDrinkId;

    @Column(name = "fd_name")
    String foodAndDrinkName;

    @Column(name = "room_id")
    int roomId;

    @Column(name = "fd_price")
    double foodAndDrinkPrice;
}
