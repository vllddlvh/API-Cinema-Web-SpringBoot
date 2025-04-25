package com.cinemaweb.API.Cinema.Web.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PasswordOTP {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String OTP;

    @OneToOne
    @JoinColumn(name = "user_id")
    User user;

    Date expiryTime;
}
