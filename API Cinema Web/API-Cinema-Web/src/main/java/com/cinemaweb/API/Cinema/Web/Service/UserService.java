package com.cinemaweb.API.Cinema.Web.Service;

import com.cinemaweb.API.Cinema.Web.DTO.Request.UserCreationRequest;
import com.cinemaweb.API.Cinema.Web.DTO.Request.UserUpdateRequest;
import com.cinemaweb.API.Cinema.Web.DTO.Response.UserResponse;
import com.cinemaweb.API.Cinema.Web.Enum.Role;
import com.cinemaweb.API.Cinema.Web.Exception.AppException;
import com.cinemaweb.API.Cinema.Web.Exception.ErrorCode;
import com.cinemaweb.API.Cinema.Web.Mapper.UserMapper;
import com.cinemaweb.API.Cinema.Web.Repository.RoleRepository;
import com.cinemaweb.API.Cinema.Web.Repository.UserRepository;
import com.cinemaweb.API.Cinema.Web.entity.User;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserService {
    UserRepository userRepository;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder;
    RoleRepository roleRepository;

    public UserResponse get(String id) {
        return userMapper.toUserResponse(userRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTS)));
    }

    public List<UserResponse> getAll() {
        List<User> users = userRepository.findAll();
        return users.stream().map(userMapper::toUserResponse).toList();
    }

    public UserResponse create(UserCreationRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }
        User user = userMapper.toUser(request);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        var roles = roleRepository.findAllById(List.of(Role.USER.name()));
        user.setRoles(new HashSet<>(roles));
        return userMapper.toUserResponse(userRepository.save(user));
    }

    public UserResponse update(UserUpdateRequest request, String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTS));
        if (request.getPassword() != null)
            request.setPassword(passwordEncoder.encode(request.getPassword()));
        userMapper.UpdateUser(request, user);
        if (request.getRoles() != null && !request.getRoles().isEmpty()) {
            var roles = roleRepository.findAllById(request.getRoles());
            if (roles.isEmpty())
                throw new RuntimeException("Invalid role");
            user.setRoles(new HashSet<>(roles));
        }
        return userMapper.toUserResponse(userRepository.save(user));
    }

    public void delete(String id) {
        if (!userRepository.existsById(id))
            throw new AppException(ErrorCode.USER_NOT_EXISTS);
        userRepository.deleteById(id);
    }

    public void deleteAll() {
        userRepository.deleteAll();
    }
}
