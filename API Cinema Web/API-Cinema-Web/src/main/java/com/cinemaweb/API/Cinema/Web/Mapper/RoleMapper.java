package com.cinemaweb.API.Cinema.Web.Mapper;

import com.cinemaweb.API.Cinema.Web.DTO.Request.RoleRequest;
import com.cinemaweb.API.Cinema.Web.DTO.Response.RoleResponse;
import com.cinemaweb.API.Cinema.Web.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface RoleMapper {

    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);
    RoleResponse toRoleResponse(Role role);
}
