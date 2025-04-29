package com.cinemaweb.API.Cinema.Web.repository;

import com.cinemaweb.API.Cinema.Web.entity.PasswordOTP;
import com.cinemaweb.API.Cinema.Web.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordOtpRepository extends JpaRepository<PasswordOTP, String> {
    public void deleteByUser(User user);
}
