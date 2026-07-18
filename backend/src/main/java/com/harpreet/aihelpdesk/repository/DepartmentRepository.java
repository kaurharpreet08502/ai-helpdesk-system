package com.harpreet.aihelpdesk.repository;

import com.harpreet.aihelpdesk.entity.Department;
import com.harpreet.aihelpdesk.enums.DepartmentStatus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    /**
     * Find by department code
     */
    Optional<Department> findByDepartmentCode(String departmentCode);

    /**
     * Find by department name
     */
    Optional<Department> findByDepartmentName(String departmentName);

    /**
     * Duplicate validation
     */
    boolean existsByDepartmentCode(String departmentCode);

    boolean existsByDepartmentName(String departmentName);

    /**
     * Active departments
     */
    List<Department> findByStatus(DepartmentStatus status);

    /**
     * Search departments
     */
    List<Department> findByDepartmentNameContainingIgnoreCase(String keyword);

    List<Department> findByDepartmentCodeContainingIgnoreCase(String keyword);

    List<Department> findByDepartmentNameContainingIgnoreCaseOrDepartmentCodeContainingIgnoreCase(
            String departmentName,
            String departmentCode
    );

}