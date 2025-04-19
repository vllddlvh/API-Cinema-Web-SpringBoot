package com.cinemaweb.API.Cinema.Web.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FilmCreateRequest {
    String filmName;
    String filmPoster;
    String filmGenre;
    int filmLength;  //this time watch film
    String filmDescription;
    int filmReview;
}
