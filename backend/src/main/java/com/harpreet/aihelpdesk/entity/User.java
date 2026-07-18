package com.harpreet.aihelpdesk.entity;

import com.harpreet.aihelpdesk.enums.Role;
import com.harpreet.aihelpdesk.enums.UserStatus;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(
        name = "users",
        uniqueConstraints = {

                @UniqueConstraint(
                        name = "uk_user_email",
                        columnNames = "email"
                ),

                @UniqueConstraint(
                        name = "uk_employee_id",
                        columnNames = "employee_id"
                )

        }
)
public class User extends BaseEntity {

    @Column(
            name = "employee_id",
            nullable = false,
            length = 20
    )
    private String employeeId;

    @Column(
            name = "first_name",
            nullable = false,
            length = 50
    )
    private String firstName;

    @Column(
            name = "last_name",
            nullable = false,
            length = 50
    )
    private String lastName;

    @Column(
            nullable = false,
            length = 100
    )
    private String email;

    @Column(
            nullable = false,
            length = 255
    )
    private String password;

    @Column(
            name = "phone_number",
            length = 15
    )
    private String phoneNumber;

    @Column(
            nullable = false,
            length = 100
    )
    private String designation;

    @Enumerated(EnumType.STRING)
    @Column(
            nullable = false,
            length = 50
    )
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(
            nullable = false,
            length = 20
    )
    private UserStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "department_id",
            foreignKey = @ForeignKey(name = "fk_user_department")
    )
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "manager_id",
            foreignKey = @ForeignKey(name = "fk_user_manager")
    )
    private User manager;

    @OneToMany(mappedBy = "manager")
    private List<User> subordinates = new ArrayList<>();

    @Column(name = "profile_image")
    private String profileImage;

    @Column(name = "last_login")
    private LocalDateTime lastLogin;

    @Column(
            name = "account_locked",
            nullable = false
    )
    private Boolean accountLocked = false;

}