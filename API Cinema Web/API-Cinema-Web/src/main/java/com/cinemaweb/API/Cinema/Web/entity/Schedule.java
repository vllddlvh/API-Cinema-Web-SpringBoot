package com.cinemaweb.API.Cinema.Web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Date;
import java.sql.Time;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Schedule {
    @Id
    int scheduleId;

    int filmId;
    int roomId;
    Date scheduleDate;  //Date in SQL
    Time scheduleStart; //Time in SQL
    Time scheduleEnd;
}
