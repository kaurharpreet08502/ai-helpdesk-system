package com.harpreet.aihelpdesk.entity;

import com.harpreet.aihelpdesk.enums.CommentType;

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
@Table(name = "ticket_comments")
public class TicketComment extends BaseEntity {

    /**
     * Ticket
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "ticket_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_comment_ticket")
    )
    private Ticket ticket;

    /**
     * Comment Author
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "user_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_comment_user")
    )
    private User user;

    /**
     * Parent Comment (Reply Support)
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "parent_comment_id",
            foreignKey = @ForeignKey(name = "fk_parent_comment")
    )
    private TicketComment parentComment;

    /**
     * Child Replies
     */
    @OneToMany(
            mappedBy = "parentComment",
            orphanRemoval = true
    )
    private List<TicketComment> replies = new ArrayList<>();

    /**
     * Comment
     */
    @Lob
    @Column(nullable = false)
    private String comment;

    /**
     * Comment Type
     */
    @Enumerated(EnumType.STRING)
    @Column(
            name = "comment_type",
            nullable = false,
            length = 20
    )
    private CommentType commentType;

    /**
     * Edited Flag
     */
    @Column(nullable = false)
    private Boolean edited = false;

    /**
     * Edited Time
     */
    @Column(name = "edited_at")
    private LocalDateTime editedAt;

    /**
     * Soft Delete
     */
    @Column(
            name = "deleted",
            nullable = false
    )
    private Boolean deleted = false;

}
