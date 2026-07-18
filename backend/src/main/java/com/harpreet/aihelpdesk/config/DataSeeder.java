package com.harpreet.aihelpdesk.config;

import com.harpreet.aihelpdesk.entity.Department;
import com.harpreet.aihelpdesk.entity.User;
import com.harpreet.aihelpdesk.enums.DepartmentStatus;
import com.harpreet.aihelpdesk.enums.Designation;
import com.harpreet.aihelpdesk.enums.Role;
import com.harpreet.aihelpdesk.enums.UserStatus;
import com.harpreet.aihelpdesk.repository.DepartmentRepository;
import com.harpreet.aihelpdesk.repository.UserRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final DepartmentRepository departmentRepository;

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {

        Department itDepartment = departmentRepository

                .findByDepartmentCode("IT")

                .orElseGet(() -> {

                    Department department = new Department();

                    department.setDepartmentCode("IT");
                    department.setDepartmentName("Information Technology");
                    department.setDescription("Default IT Department");
                    department.setStatus(DepartmentStatus.ACTIVE);

                    return departmentRepository.save(department);

                });

        if (userRepository.findByEmail("admin@gmail.com").isEmpty()) {

            User admin = User.builder()

                    .employeeId("EMP001")

                    .firstName("Admin")

                    .lastName("User")

                    .email("admin@gmail.com")

                    .password(passwordEncoder.encode("Admin@123"))

                    .phoneNumber("9999999999")

                    .designation(Designation.SOFTWARE_ENGINEER)

                    .role(Role.ADMIN)

                    .status(UserStatus.ACTIVE)

                    .enabled(true)

                    .locked(false)

                    .department(itDepartment)

                    .build();

            userRepository.save(admin);

            System.out.println("====================================");

            System.out.println("Default Admin Created");

            System.out.println("Email : admin@gmail.com");

            System.out.println("Password : Admin@123");

            System.out.println("====================================");

        }

    }

}
