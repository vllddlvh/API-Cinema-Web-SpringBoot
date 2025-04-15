package com.cinemaweb.API.Cinema.Web.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Seat {
    @Id
    int seatId;

    String seatType;
    int roomId;
    String row;
    int number;
    double seatPrice;
}
