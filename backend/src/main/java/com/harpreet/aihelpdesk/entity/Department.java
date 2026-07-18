package com.harpreet.aihelpdesk.entity;

import com.harpreet.aihelpdesk.enums.DepartmentStatus;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(
        name = "departments",
        uniqueConstraints = {

                @UniqueConstraint(
                        name = "uk_department_name",
                        columnNames = "department_name"
                ),

                @UniqueConstraint(
                        name = "uk_department_code",
                        columnNames = "department_code"
                )

        }
)
public class Department extends BaseEntity {

    /**
     * Department Name
     */
    @Column(
            name = "department_name",
            nullable = false,
            length = 100
    )
    private String departmentName;

    /**
     * Department Code
     * Example:
     * IT
     * HR
     * FIN
     */
    @Column(
            name = "department_code",
            nullable = false,
            length = 20
    )
    private String departmentCode;

    /**
     * Description
     */
    @Column(
            length = 500
    )
    private String description;

    /**
     * Department Status
     */
    @Enumerated(EnumType.STRING)
    @Column(
            nullable = false,
            length = 20
    )
    private DepartmentStatus status;

    /**
     * Department Manager
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "manager_id",
            foreignKey = @ForeignKey(name = "fk_department_manager")
    )
    private User manager;

    /**
     * Department Employees
     */
    @OneToMany(
            mappedBy = "department"
    )
    private List<User> users = new ArrayList<>();

    /**
     * Department Tickets
     */
    @OneToMany(
            mappedBy = "department"
    )
    private List<Ticket> tickets = new ArrayList<>();

    /**
     * Knowledge Documents
     */
    @OneToMany(
            mappedBy = "department"
    )
    private List<KnowledgeDocument> knowledgeDocuments = new ArrayList<>();

}
