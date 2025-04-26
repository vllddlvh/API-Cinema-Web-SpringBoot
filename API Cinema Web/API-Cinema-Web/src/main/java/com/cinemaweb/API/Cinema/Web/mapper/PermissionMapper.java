package com.cinemaweb.API.Cinema.Web.mapper;

import com.cinemaweb.API.Cinema.Web.dto.Request.PermissionRequest;
import com.cinemaweb.API.Cinema.Web.dto.Response.PermissionResponse;
import com.cinemaweb.API.Cinema.Web.entity.Permission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper {

    Permission toPermission(PermissionRequest request);

    PermissionResponse toPermissionResponse(Permission permission);
}
