package com.harpreet.aihelpdesk.repository;

import com.harpreet.aihelpdesk.entity.Department;
import com.harpreet.aihelpdesk.entity.User;
import com.harpreet.aihelpdesk.enums.Role;
import com.harpreet.aihelpdesk.enums.UserStatus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Authentication
     */
    Optional<User> findByEmail(String email);

    /**
     * User Management
     */
    Optional<User> findByEmployeeId(String employeeId);

    /**
     * Duplicate Validation
     */
    boolean existsByEmail(String email);

    boolean existsByEmployeeId(String employeeId);

    /**
     * Department-wise Users
     */
    List<User> findByDepartment(Department department);

    List<User> findByDepartmentId(Long departmentId);

    /**
     * Role-wise Users
     */
    List<User> findByRole(Role role);

    /**
     * Status-wise Users
     */
    List<User> findByStatus(UserStatus status);

    /**
     * Enabled Users
     */
    List<User> findByEnabledTrue();

    /**
     * Locked Users
     */
    List<User> findByLockedFalse();

    /**
     * Active Users
     */
    List<User> findByStatusAndEnabledTrueAndLockedFalse(UserStatus status);

    /**
     * Search
     */
    List<User> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(
            String firstName,
            String lastName
    );

    List<User> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailContainingIgnoreCase(
            String firstName,
            String lastName,
            String email
    );

}
