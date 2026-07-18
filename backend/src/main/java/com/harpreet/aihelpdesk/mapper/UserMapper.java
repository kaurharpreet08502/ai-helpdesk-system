package com.harpreet.aihelpdesk.mapper;

import com.harpreet.aihelpdesk.config.MapperConfiguration;
import com.harpreet.aihelpdesk.dto.user.UpdateUserRequest;
import com.harpreet.aihelpdesk.dto.user.UserResponse;
import com.harpreet.aihelpdesk.entity.User;
import com.harpreet.aihelpdesk.dto.user.CreateUserRequest;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(

        config = MapperConfiguration.class

)
public interface UserMapper {

    User toEntity(

            CreateUserRequest request

    );

    UserResponse toResponse(

            User user

    );

    void updateEntity(

            UpdateUserRequest request,

            @MappingTarget
            User entity

    );

}