package com.harpreet.aihelpdesk.entity;

import com.harpreet.aihelpdesk.enums.FileStorageType;
import com.harpreet.aihelpdesk.enums.VirusScanStatus;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(
        name = "ticket_attachments",
        indexes = {

                @Index(
                        name = "idx_attachment_ticket",
                        columnList = "ticket_id"
                ),

                @Index(
                        name = "idx_attachment_hash",
                        columnList = "file_hash"
                )

        }
)
public class TicketAttachment extends BaseEntity {

    /**
     * Ticket
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "ticket_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_attachment_ticket")
    )
    private Ticket ticket;

    /**
     * Uploaded By
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "uploaded_by",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_attachment_user")
    )
    private User uploadedBy;

    /**
     * Original File Name
     */
    @Column(
            name = "original_file_name",
            nullable = false,
            length = 255
    )
    private String originalFileName;

    /**
     * UUID File Name
     */
    @Column(
            name = "stored_file_name",
            nullable = false,
            length = 255
    )
    private String storedFileName;

    /**
     * Extension
     */
    @Column(
            name = "file_extension",
            nullable = false,
            length = 20
    )
    private String fileExtension;

    /**
     * MIME Type
     */
    @Column(
            name = "mime_type",
            nullable = false,
            length = 100
    )
    private String mimeType;

    /**
     * File Size (Bytes)
     */
    @Column(
            name = "file_size",
            nullable = false
    )
    private Long fileSize;

    /**
     * SHA-256 Hash
     */
    @Column(
            name = "file_hash",
            nullable = false,
            length = 128
    )
    private String fileHash;

    /**
     * Physical Storage Path
     */
    @Column(
            name = "storage_location",
            nullable = false,
            length = 500
    )
    private String storageLocation;

    /**
     * Storage Provider
     */
    @Enumerated(EnumType.STRING)
    @Column(
            name = "storage_type",
            nullable = false,
            length = 20
    )
    private FileStorageType storageType;

    /**
     * Download Counter
     */
    @Column(
            name = "download_count",
            nullable = false
    )
    private Integer downloadCount = 0;

    /**
     * Virus Scan Result
     */
    @Enumerated(EnumType.STRING)
    @Column(
            name = "virus_scan_status",
            nullable = false,
            length = 20
    )
    private VirusScanStatus virusScanStatus =
            VirusScanStatus.PENDING;

    /**
     * AI Processing Status
     */
    @Column(
            name = "ai_processed",
            nullable = false
    )
    private Boolean aiProcessed = false;

    /**
     * Soft Delete
     */
    @Column(
            name = "deleted",
            nullable = false
    )
    private Boolean deleted = false;

}