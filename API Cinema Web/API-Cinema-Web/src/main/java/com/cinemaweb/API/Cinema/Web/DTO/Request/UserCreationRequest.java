package com.cinemaweb.API.Cinema.Web.DTO.Request;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {

    @Size(min = 6, max = 20, message = "INVALID_USERNAME")
            @NotNull(message = "USERNAME_IS_NULL")
    String username;

    @Size(min = 8, message = "INVALID_PASSWORD")
            @NotNull(message = "PASSWORD_IS_NULL")
    String password;

    String firstName;
    String lastName = "Unknown user";

    @NotNull(message = "DOB_IS_NULL")
    LocalDate dateOfBirth;
    String email;
    String phoneNumber;
    Integer gender;
    String avatar = "default avatar";

}
