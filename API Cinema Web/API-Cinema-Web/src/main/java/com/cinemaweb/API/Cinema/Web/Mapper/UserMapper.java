package com.cinemaweb.API.Cinema.Web.Mapper;

import com.cinemaweb.API.Cinema.Web.DTO.Request.UserCreationRequest;
import com.cinemaweb.API.Cinema.Web.DTO.Request.UserUpdateRequest;
import com.cinemaweb.API.Cinema.Web.DTO.Response.UserResponse;
import com.cinemaweb.API.Cinema.Web.entity.User;
import org.mapstruct.*;


@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);
    UserResponse toUserResponse(User user);

    @Mapping(target = "roles", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void UpdateUser(UserUpdateRequest request, @MappingTarget User user);

}
