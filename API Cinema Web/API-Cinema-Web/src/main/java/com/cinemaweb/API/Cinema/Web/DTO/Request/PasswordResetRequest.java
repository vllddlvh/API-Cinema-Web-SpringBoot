package com.cinemaweb.API.Cinema.Web.DTO.Request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PasswordResetRequest {
    @NotNull(message = "PASSWORD_OTP_NULL")
    String OTP;

    @Size(min = 8, message = "INVALID_PASSWORD")
    @NotNull(message = "PASSWORD_IS_NULL")
    String newPassword;

    @Size(min = 8, message = "INVALID_PASSWORD")
    @NotNull(message = "PASSWORD_IS_NULL")
    String confirmPassword;
}
