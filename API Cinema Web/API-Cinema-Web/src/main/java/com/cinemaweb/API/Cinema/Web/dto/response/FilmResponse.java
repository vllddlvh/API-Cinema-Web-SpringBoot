package com.cinemaweb.API.Cinema.Web.dto.response;

import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FilmResponse {
    @Size(min = 30, message = "Min length film name is  30 character")
    String filmName;

    String filmPoster;
    String filmGenre;
    int filmLength;  //this time watch film
    String filmDescription;
    int filmReview;
}
