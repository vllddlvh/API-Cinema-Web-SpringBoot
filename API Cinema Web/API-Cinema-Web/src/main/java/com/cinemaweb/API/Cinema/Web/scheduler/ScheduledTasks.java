package com.cinemaweb.API.Cinema.Web.scheduler;


import com.cinemaweb.API.Cinema.Web.repository.InvalidatedTokenRepository;
import com.cinemaweb.API.Cinema.Web.repository.PasswordOtpRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ScheduledTasks {

    InvalidatedTokenRepository invalidatedTokenRepository;
    PasswordOtpRepository passwordOtpRepository;

    @Scheduled(fixedDelay = 5, timeUnit = TimeUnit.MINUTES)
    public void invalidatedTokenCleaning() {
        invalidatedTokenRepository.deleteAllByExpiryTime();
        log.info("Scheduled task: CLEANING_INVALIDATED_TOKEN");
    }
}
