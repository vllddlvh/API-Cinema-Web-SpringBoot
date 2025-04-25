package com.cinemaweb.API.Cinema.Web.DTO.Request;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PasswordOtpRequest {
    @NotNull
    String email;
}
