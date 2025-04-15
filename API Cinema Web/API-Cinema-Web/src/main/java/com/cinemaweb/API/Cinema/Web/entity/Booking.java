package com.cinemaweb.API.Cinema.Web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Booking {
    @Id
    int bookingId;

    int userId;
    int scheduleId;
    int seatId;
    double price;
    Date bookingDay;
    int foodAndDrinkId;
}
