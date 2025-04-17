package com.cinemaweb.API.Cinema.Web.Service;

import com.cinemaweb.API.Cinema.Web.DTO.Request.PermissionRequest;
import com.cinemaweb.API.Cinema.Web.DTO.Response.PermissionResponse;
import com.cinemaweb.API.Cinema.Web.Exception.AppException;
import com.cinemaweb.API.Cinema.Web.Exception.ErrorCode;
import com.cinemaweb.API.Cinema.Web.Mapper.PermissionMapper;
import com.cinemaweb.API.Cinema.Web.Repository.PermissionRepository;
import com.cinemaweb.API.Cinema.Web.entity.Permission;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PermissionService {
    PermissionRepository permissionRepository;
    PermissionMapper permissionMapper;

    public PermissionResponse create(PermissionRequest request) {
        Permission permission = permissionMapper.toPermission(request);
        permission = permissionRepository.save(permission);
        return permissionMapper.toPermissionResponse(permission);
    }

    public PermissionResponse get(String permissionName) {
        return permissionMapper.toPermissionResponse(permissionRepository.findById(permissionName)
                .orElseThrow(() -> new RuntimeException("Permission do not exists")));
    }

    public List<PermissionResponse> getAll() {
        List<Permission> permissions = permissionRepository.findAll();
        return permissions.stream().map(permissionMapper::toPermissionResponse).toList();
    }

    public void delete(String permissionName) {
        permissionRepository.deleteById(permissionName);
    }

    public void deleteAll() {
        permissionRepository.deleteAll();
    }

}