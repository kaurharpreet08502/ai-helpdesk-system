package com.harpreet.aihelpdesk.entity;

import com.harpreet.aihelpdesk.enums.*;

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
        name = "tickets",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_ticket_number",
                        columnNames = "ticket_number"
                )
        }
)
public class Ticket extends BaseEntity {

    @Column(
            name = "ticket_number",
            nullable = false,
            unique = true,
            length = 30
    )
    private String ticketNumber;

    @Column(
            nullable = false,
            length = 200
    )
    private String title;

    @Lob
    @Column(nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TicketStatus status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TicketPriority priority;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TicketCategory category;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TicketSource source;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "created_by_user_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_ticket_created_by")
    )
    private User createdByUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "assigned_to_id",
            foreignKey = @ForeignKey(name = "fk_ticket_assigned_to")
    )
    private User assignedTo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "department_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_ticket_department")
    )
    private Department department;

    @Column(name = "due_date")
    private LocalDateTime dueDate;

    @Column(name = "resolved_at")
    private LocalDateTime resolvedAt;

    @Column(name = "closed_at")
    private LocalDateTime closedAt;

    @Lob
    @Column(name = "resolution")
    private String resolution;

    @Column(
            name = "reopen_count",
            nullable = false
    )
    private Integer reopenCount = 0;

    @Lob
    @Column(name = "ai_summary")
    private String aiSummary;

    @Enumerated(EnumType.STRING)
    @Column(name = "ai_suggested_category")
    private TicketCategory aiSuggestedCategory;

    @Enumerated(EnumType.STRING)
    @Column(name = "ai_suggested_priority")
    private TicketPriority aiSuggestedPriority;

    @Column(
            name = "is_deleted",
            nullable = false
    )
    private Boolean deleted = false;

    @OneToMany(
            mappedBy = "ticket",
            orphanRemoval = true
    )
    private List<TicketComment> comments = new ArrayList<>();

    @OneToMany(
            mappedBy = "ticket",
            orphanRemoval = true
    )
    private List<TicketAttachment> attachments = new ArrayList<>();

}