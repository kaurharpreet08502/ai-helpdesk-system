package com.harpreet.aihelpdesk.entity;

import com.harpreet.aihelpdesk.enums.*;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(
        name = "knowledge_documents",
        indexes = {

                @Index(
                        name = "idx_document_department",
                        columnList = "department_id"
                ),

                @Index(
                        name = "idx_document_status",
                        columnList = "status"
                ),

                @Index(
                        name = "idx_document_category",
                        columnList = "category"
                )

        }
)
public class KnowledgeDocument extends BaseEntity {

    @Column(nullable = false, length = 200)
    private String title;

    @Column(length = 1000)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DocumentCategory category;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DocumentStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name = "processing_status", nullable = false)
    private ProcessingStatus processingStatus =
            ProcessingStatus.PENDING;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "department_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_document_department")
    )
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "uploaded_by",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_document_uploaded_by")
    )
    private User uploadedBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "approved_by",
            foreignKey = @ForeignKey(name = "fk_document_approved_by")
    )
    private User approvedBy;

    @Column(name = "original_file_name", nullable = false)
    private String originalFileName;

    @Column(name = "stored_file_name", nullable = false)
    private String storedFileName;

    @Column(name = "file_extension", nullable = false, length = 20)
    private String fileExtension;

    @Column(name = "mime_type", nullable = false, length = 100)
    private String mimeType;

    @Column(name = "file_size", nullable = false)
    private Long fileSize;

    @Column(name = "file_hash", nullable = false, length = 128)
    private String fileHash;

    @Column(name = "storage_path", nullable = false, length = 500)
    private String storagePath;

    @Enumerated(EnumType.STRING)
    @Column(name = "storage_type", nullable = false)
    private FileStorageType storageType;

    @Column(nullable = false)
    private Integer version = 1;

    @Column(name = "embedding_id")
    private String embeddingId;

    @Column(nullable = false)
    private Boolean indexed = false;

    @Lob
    @Column(name = "ai_summary")
    private String aiSummary;

    @Column(length = 1000)
    private String keywords;

    @Column(nullable = false)
    private Boolean deleted = false;

}