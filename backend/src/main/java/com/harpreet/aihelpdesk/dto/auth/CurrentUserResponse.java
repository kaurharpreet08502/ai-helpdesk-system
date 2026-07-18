package com.harpreet.aihelpdesk.dto.auth;

import com.harpreet.aihelpdesk.enums.Role;
import com.harpreet.aihelpdesk.enums.UserStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CurrentUserResponse {

    private Long id;

    private String employeeId;

    private String firstName;

    private String lastName;

    private String fullName;

    private String email;

    private String phoneNumber;

    private Role role;

    private UserStatus status;

    private Long departmentId;

    private String departmentName;

    private String designation;

    private Boolean enabled;

    private Boolean locked;

}
