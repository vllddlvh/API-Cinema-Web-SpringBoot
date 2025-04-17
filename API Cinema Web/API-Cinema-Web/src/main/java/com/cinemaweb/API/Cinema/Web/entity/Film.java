package com.cinemaweb.API.Cinema.Web.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Film {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    int filmId;

    String filmName;
    String filmPoster;
    String filmGenre;
    int filmLength;  //this time watch film
    String filmDescription;
    int filmReview;  //its star 1* 2* 3* ...
}
