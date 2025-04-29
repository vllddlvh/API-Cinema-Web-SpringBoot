package com.cinemaweb.API.Cinema.Web.scheduler;


import com.cinemaweb.API.Cinema.Web.repository.InvalidatedTokenRepository;
import com.cinemaweb.API.Cinema.Web.repository.PasswordOtpRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ScheduledTasks {

    InvalidatedTokenRepository invalidatedTokenRepository;
    PasswordOtpRepository passwordOtpRepository;

    

}
