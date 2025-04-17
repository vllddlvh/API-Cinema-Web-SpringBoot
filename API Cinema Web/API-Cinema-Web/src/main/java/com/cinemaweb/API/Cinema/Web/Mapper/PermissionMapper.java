package com.cinemaweb.API.Cinema.Web.Mapper;

import com.cinemaweb.API.Cinema.Web.DTO.Request.PermissionRequest;
import com.cinemaweb.API.Cinema.Web.DTO.Response.PermissionResponse;
import com.cinemaweb.API.Cinema.Web.entity.Permission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper {

    Permission toPermission(PermissionRequest request);

    PermissionResponse toPermissionResponse(Permission permission);
}
