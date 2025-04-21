package com.cinemaweb.API.Cinema.Web.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
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
    String seatRow;
    int seatNumber;
    double seatPrice;
}
