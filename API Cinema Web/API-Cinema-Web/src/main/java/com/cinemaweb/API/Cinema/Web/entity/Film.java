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
public class Film {
    @Id
    int filmId;

    String filmName;
    String filmPoster;
    String filmGenre;
    int filmLength;  //this time watch film
    String filmDescription;
    int filmReview;  //its star 1* 2* 3* ...

}
