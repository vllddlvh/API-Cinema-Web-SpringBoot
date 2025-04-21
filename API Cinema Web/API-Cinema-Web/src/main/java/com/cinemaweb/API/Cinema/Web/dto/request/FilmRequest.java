package com.cinemaweb.API.Cinema.Web.dto.request;

import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
/**
 * This dto is creation dto and update dto
 */
public class FilmRequest {
    @Size(max = 30, message = "Min length film name is  30 character")
    String filmName;

    String filmPoster;
    String filmGenre;
    int filmLength;  //this time watch film
    String filmDescription;
    int filmReview;
}
