package com.harpreet.aihelpdesk.dto.user;
import com.harpreet.aihelpdesk.enums.Designation;
import com.harpreet.aihelpdesk.enums.Role;
import com.harpreet.aihelpdesk.enums.UserStatus;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class CreateUserRequest {

    @NotBlank(message = "Employee ID is required")
    private String employeeId;

    @NotBlank(message = "First name is required")
    @Size(max = 100)
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(max = 100)
    private String lastName;

    @NotBlank(message = "Email is required")
    @Email
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 8)
    private String password;

    @Pattern(
            regexp = "^[6-9][0-9]{9}$",
            message = "Invalid phone number"
    )
    private String phoneNumber;

    @NotNull(message = "Role is required")
    private Role role;

    @NotNull(message = "Designation is required")
    private Designation designation;

    @NotNull(message = "Department is required")
    private Long departmentId;

    @Builder.Default
    private UserStatus status = UserStatus.ACTIVE;

}