package com.cinemaweb.API.Cinema.Web.Controller;

import com.cinemaweb.API.Cinema.Web.DTO.Request.AuthenticationRequest;
import com.cinemaweb.API.Cinema.Web.DTO.Request.IntrospectRequest;
import com.cinemaweb.API.Cinema.Web.DTO.Response.ApiResponse;
import com.cinemaweb.API.Cinema.Web.DTO.Response.AuthenticationResponse;
import com.cinemaweb.API.Cinema.Web.DTO.Response.IntrospectResponse;
import com.cinemaweb.API.Cinema.Web.Service.AuthenticationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("auth")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    AuthenticationService authenticationService;

    @PostMapping("/login")
    public ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ApiResponse.<AuthenticationResponse>builder()
                .body(authenticationService.authenticate(request))
                .build();
    }

    @PostMapping("/introspect")
    public ApiResponse<IntrospectResponse> introspect(@RequestBody IntrospectRequest request) throws Exception {
        return ApiResponse.<IntrospectResponse>builder()
                .body(authenticationService.introspect(request))
                .build();
    }

}
