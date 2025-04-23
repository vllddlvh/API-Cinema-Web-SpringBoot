package com.cinemaweb.API.Cinema.Web.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import static jakarta.persistence.GenerationType.IDENTITY;

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
    @GeneratedValue(strategy = IDENTITY)
    int foodAndDrinkId;

    @Column(name = "fd_name")
    String foodAndDrinkName;

    @Column(name = "room_id")
    int roomId;

    @Column(name = "fd_price")
    double foodAndDrinkPrice;
}
