package com.cinemaweb.API.Cinema.Web.repository;

import com.cinemaweb.API.Cinema.Web.entity.InvalidatedToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvalidatedTokenRepository extends JpaRepository<InvalidatedToken, String> {
//    @Modifying
//    @Query("DELETE FROM invalidated_token t WHERE t.expiry_time <= :now")
//    public void deleteAllByExpiryTime(@Param("now") Date now);
}
