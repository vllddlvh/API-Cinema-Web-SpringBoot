package com.cinemaweb.API.Cinema.Web.Service;

import com.cinemaweb.API.Cinema.Web.DTO.Request.RoleRequest;
import com.cinemaweb.API.Cinema.Web.DTO.Response.RoleResponse;
import com.cinemaweb.API.Cinema.Web.Exception.AppException;
import com.cinemaweb.API.Cinema.Web.Exception.ErrorCode;
import com.cinemaweb.API.Cinema.Web.Mapper.RoleMapper;
import com.cinemaweb.API.Cinema.Web.Repository.PermissionRepository;
import com.cinemaweb.API.Cinema.Web.Repository.RoleRepository;
import com.cinemaweb.API.Cinema.Web.entity.Role;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class RoleService {
    RoleRepository roleRepository;
    RoleMapper roleMapper;
    PermissionRepository permissionRepository;

    public RoleResponse create(RoleRequest request) {
        if (roleRepository.existsByName(request.getName()))
            throw new AppException(ErrorCode.ROLE_EXISTED);
        Role role = roleMapper.toRole(request);
        var permissions = permissionRepository.findAllById(request.getPermissions());
        role.setPermissions(new HashSet<>(permissions));
        role = roleRepository.save(role);
        return roleMapper.toRoleResponse(role);

    }

    public RoleResponse get(String name) {
        return roleMapper.toRoleResponse(roleRepository.findById(name)
                .orElseThrow(() -> new AppException(ErrorCode.ROLE_NOT_EXISTS)));
    }

    public List<RoleResponse> getAll() {
        List<Role> roles = roleRepository.findAll();
        return roles.stream().map(roleMapper::toRoleResponse).toList();
    }

    public void delete(String name) {
        roleRepository.deleteById(name);
    }

    public void deleteAll() {
        roleRepository.deleteAll();
    }
}
