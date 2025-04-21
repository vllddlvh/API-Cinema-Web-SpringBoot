package com.cinemaweb.API.Cinema.Web.Exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum ErrorCode {
    UNKNOWN_EXCEPTION(9999, "Unknown Error!", HttpStatus.INTERNAL_SERVER_ERROR),
    RUNTIME_EXCEPTION(8888, "Runtime Error!", HttpStatus.INTERNAL_SERVER_ERROR),
    USER_EXISTED(1001, "User existed!!", HttpStatus.BAD_REQUEST),
    USER_NOT_EXISTS(1002, "User not exists!", HttpStatus.BAD_REQUEST),
    UNAUTHENTICATED(1006, "UNAUTHENTICATED", HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED(1007, "You have not permission!", HttpStatus.FORBIDDEN),
    ROLE_EXISTED(2001, "Role existed!", HttpStatus.BAD_REQUEST),
    ROLE_NOT_EXISTS(2001, "Role not exists!", HttpStatus.BAD_REQUEST),
    REQUEST_MISSING_BODY(5555, "Request must have body!", HttpStatus.BAD_REQUEST),
    INVALID_USERNAME(3001, "User name must be at lest 6 characters!", HttpStatus.BAD_REQUEST),
    INVALID_PASSWORD(3002, "Password must be at lest 8 characters", HttpStatus.BAD_REQUEST),
    USERNAME_IS_NULL(3002, "Username must not be null", HttpStatus.BAD_REQUEST),
    PASSWORD_IS_NULL(3002, "Password must not be null", HttpStatus.BAD_REQUEST),
    DOB_IS_NULL(3002, "User's DOB must not be bull", HttpStatus.BAD_REQUEST)
    ;
    int code;
    String message;
    HttpStatusCode httpStatusCode;
}
