package com.harpreet.aihelpdesk.dto.user;

import com.harpreet.aihelpdesk.enums.Designation;
import com.harpreet.aihelpdesk.enums.Role;
import com.harpreet.aihelpdesk.enums.UserStatus;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserRequest {

    @NotBlank
    @Size(max = 100)
    private String firstName;

    @NotBlank
    @Size(max = 100)
    private String lastName;

    @Email
    private String email;

    @Pattern(
            regexp = "^[6-9][0-9]{9}$",
            message = "Invalid phone number"
    )
    private String phoneNumber;

    private Role role;

    private Designation designation;

    private UserStatus status;

    private Long departmentId;

    private Boolean enabled;

    private Boolean locked;

}
