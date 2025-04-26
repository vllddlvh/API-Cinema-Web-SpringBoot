package com.cinemaweb.API.Cinema.Web.repository;

import com.cinemaweb.API.Cinema.Web.entity.PasswordOTP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PasswordOtpRepository extends JpaRepository<PasswordOTP, String> {
    public Optional<PasswordOTP> findByOTP(String OTP);
}
