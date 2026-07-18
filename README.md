# Enterprise AI HelpDesk & IT Service Management Platform

Version: 1.0

Status: FROZEN

Document Type: Master Project Scope

Project Owner: Harpreet Kaur

Architecture: Enterprise Layered Monolith

Last Updated: July 2026

---

# PROJECT STATUS

This document defines the complete functional scope of the Enterprise AI HelpDesk & IT Service Management Platform.

The project requirements described in this document are frozen.

No new features, modules, workflows, technologies, architectural changes, or database modifications shall be introduced without creating a new project version.

This document acts as the official project scope and shall be treated as the single source of truth throughout development.

---

# PROJECT OVERVIEW

Enterprise AI HelpDesk is a production-ready Enterprise IT Service Management (ITSM) platform built using Java Spring Boot, Angular, PostgreSQL and Spring AI.

The application enables organizations to efficiently manage employees, managers, support engineers, departments, authentication, authorization, ticket lifecycle, audit logging, reporting and AI-assisted issue resolution through a centralized web application.

Unlike traditional CRUD applications, this project integrates Retrieval-Augmented Generation (RAG) and an AI Support Assistant using Spring AI.

The project demonstrates modern enterprise software architecture and AI integration while remaining a single deployable application.

---

# PRIMARY OBJECTIVES

The application shall provide:

• Secure Authentication

• Role Based Authorization

• Department Management

• User Management

• Ticket Lifecycle Management

• Comment Management

• Attachment Management

• Notification Management

• Dashboard Analytics

• Reporting

• Audit Logging

• AI Knowledge Assistant

• AI Support Chatbot

• Retrieval Augmented Generation (RAG)

• Knowledge Base Management

• Semantic Document Search

• Dockerized Deployment

---

# PROJECT TYPE

Enterprise Full Stack Web Application

Architecture Style

Layered Monolithic Architecture

Deployment

Docker Containers

Frontend

Single Page Application

Backend

REST API

Database

Relational Database

AI

Retrieval-Augmented Generation (RAG)

---

# TARGET USERS

Administrator

Manager

Support Engineer

Employee

Artificial Intelligence Assistant

---

# TECHNOLOGY STACK

## Backend

Java 21

Spring Boot 3

Spring MVC

Spring Security

Spring Data JPA

Hibernate ORM

Jakarta Validation

Spring AI

MapStruct

Lombok

Maven

JWT Authentication

BCrypt Password Encoder

Swagger OpenAPI

SLF4J Logging

Docker

Docker Compose

---

## Frontend

Angular

Angular Material

TypeScript

HTML5

CSS3

RxJS

Angular Router

Reactive Forms

HTTP Client

---

## Database

PostgreSQL

pgAdmin

pgvector Extension

---

## AI Stack

Spring AI

OpenAI Chat Model

OpenAI Embedding Model

Retrieval Augmented Generation

Vector Search

Prompt Templates

Document Processing

Conversation Memory

---

## Development Tools

IntelliJ IDEA

Visual Studio Code

Git

GitHub

Postman

Docker Desktop

PgAdmin

Maven

---

# SOFTWARE ARCHITECTURE

The application follows Layered Architecture.

Presentation Layer

↓

Controller Layer

↓

Service Layer

↓

Repository Layer

↓

Database

Controllers only accept requests and return responses.

Business logic exists only inside Services.

Repositories only communicate with the database.

Entities are never exposed directly.

DTOs are always exchanged with clients.

---

# APPLICATION MODULES

Authentication

Authorization

User Management

Department Management

Role Management

Permission Management

Ticket Management

Comment Management

Attachment Management

Notification Management

Dashboard

Reporting

Audit Logging

Knowledge Base

Artificial Intelligence

Search

Profile Management

Administration

---

# USER ROLES

## Administrator

Complete system administration.

Manage users.

Manage departments.

Manage roles.

Manage permissions.

View reports.

Manage knowledge base.

Configure AI.

View audit logs.

View dashboards.

Monitor system.

---

## Manager

Manage team members.

Assign engineers.

Assign tickets.

Escalate tickets.

View reports.

Monitor performance.

Review ticket progress.

View department dashboard.

---

## Support Engineer

Accept assigned tickets.

Reject assigned tickets.

Resolve tickets.

Close tickets.

Reopen tickets.

Add comments.

Upload attachments.

Search tickets.

View AI recommendations.

Use AI assistant.

---

## Employee

Create ticket.

Track own tickets.

Upload attachments.

Add comments.

Search knowledge base.

Use AI chatbot.

Update profile.

Receive notifications.

---

# AUTHENTICATION FEATURES

Secure Login

Logout

JWT Authentication

Refresh Token

Password Encryption

Forgot Password

Reset Password

Role Based Authorization

Permission Based Authorization

Session Validation

Protected REST APIs

---

# USER MANAGEMENT FEATURES

Create User

Update User

Deactivate User

Activate User

View User

Search Users

Assign Role

Assign Department

Assign Manager

Profile Management

---

# DEPARTMENT FEATURES

Create Department

Update Department

Delete Department

Department Statistics

Department Members

Department Assignment

---

# ROLE MANAGEMENT

Create Role

Update Role

Delete Role

Assign Permissions

View Roles

Permission Mapping

---

# PERMISSION MANAGEMENT

Create Permission

Assign Permission

Remove Permission

Permission Mapping

Permission Validation

---

# TICKET MANAGEMENT

Create Ticket

Update Ticket

Delete Ticket

View Ticket

Assign Ticket

Reassign Ticket

Accept Ticket

Reject Ticket

Resolve Ticket

Close Ticket

Reopen Ticket

Escalate Ticket

Ticket Timeline

Ticket History

Assignment History

Search Tickets

Filter Tickets

Sort Tickets

Pagination

Priority Management

Category Management

Status Management

---

# COMMENT MANAGEMENT

Add Comment

Update Comment

Delete Comment

View Comments

Comment History

---

# ATTACHMENT MANAGEMENT

Upload Attachment

Download Attachment

Delete Attachment

View Attachments

Attachment Validation

File Metadata

---

# NOTIFICATION MANAGEMENT

Ticket Assignment Notification

Ticket Update Notification

Ticket Closure Notification

Comment Notification

System Notification

Unread Notification Count

Notification History

---

# DASHBOARD

Administrator Dashboard

Manager Dashboard

Engineer Dashboard

Employee Dashboard

Open Ticket Count

Closed Ticket Count

Department Statistics

Engineer Performance

Recent Activities

Monthly Statistics

---

# REPORTING

Ticket Reports

Department Reports

Engineer Reports

Resolution Reports

Monthly Reports

User Activity Reports

---

# AUDIT LOGGING

User Login History

Ticket Activity

User Activity

Role Changes

Department Changes

Configuration Changes

Complete Audit Trail

---

# SEARCH

Global Search

Ticket Search

User Search

Department Search

Comment Search

Knowledge Base Search

Semantic AI Search

---

# AI MODULE

The Artificial Intelligence module is divided into two independent systems.

## AI KNOWLEDGE ASSISTANT (RAG)

Purpose

Answer questions using only the organization's internal documentation.

Capabilities

Document Upload

Document Parsing

Document Chunking

Embedding Generation

Vector Storage

Semantic Search

Context Retrieval

Prompt Construction

Grounded AI Response

Knowledge Base Search

Ticket Resolution Suggestion

Duplicate Ticket Detection

Ticket Category Prediction

Priority Recommendation

Ticket Summarization

---

## AI SUPPORT CHATBOT

Purpose

Provide conversational assistance to users.

Capabilities

Conversation History

Streaming Responses

Technical Question Answering

Application Guidance

Error Explanation

Code Explanation

Suggested Prompts

Conversation Management

---

# KNOWLEDGE BASE

Supported Document Types

PDF

DOCX

TXT

Markdown

Administrator can

Upload Documents

Delete Documents

View Documents

Re-index Documents

AI indexes documents automatically.

---

# RAG PIPELINE

Document Upload

↓

Document Parsing

↓

Chunk Generation

↓

Embedding Generation

↓

Vector Storage

↓

Similarity Search

↓

Relevant Context

↓

Prompt Construction

↓

OpenAI Response

↓

User Response

---

# SECURITY

Spring Security

JWT Authentication

Refresh Tokens

BCrypt Password Encoding

Role Based Access Control

Permission Based Access Control

Method Level Security

Global Exception Handling

Request Validation

Audit Logging

---

# DATABASE

Database Engine

PostgreSQL

Vector Storage

pgvector

ORM

Hibernate

Repository Pattern

Spring Data JPA

Database relationships use foreign keys.

Normalization follows Third Normal Form.

---

# APPLICATION ARCHITECTURE

Backend

Java Spring Boot

Frontend

Angular

Communication

REST APIs

Authentication

JWT

Database

PostgreSQL

Artificial Intelligence

Spring AI

Vector Search

pgvector

Deployment

Docker

---

# PROJECT DELIVERABLES

Backend Source Code

Angular Frontend

REST APIs

PostgreSQL Database

Database Schema

Swagger Documentation

Docker Configuration

GitHub Repository

Technical Documentation

Postman Collection

README Documentation

AI Integration

Knowledge Base

RAG Pipeline

Chatbot

---

# PROJECT COMPLETION DEFINITION

The project is considered complete only when:

All backend modules are implemented.

All frontend pages are implemented.

All REST APIs are completed.

Authentication is functional.

Authorization is functional.

Database schema is complete.

Entity relationships are implemented.

Swagger documentation is complete.

Docker deployment is successful.

Angular application is integrated.

Spring AI integration is functional.

Knowledge Base indexing is functional.

RAG pipeline retrieves relevant documents.

AI Chatbot is operational.

Audit logging is operational.

Reporting is operational.

Notifications are operational.

Application builds successfully.

Application runs successfully.

All project documentation matches the implementation.

---

# FROZEN PROJECT DECLARATION

This document freezes the scope of the Enterprise AI HelpDesk & IT Service Management Platform.

The implementation shall strictly follow this specification.

No additional modules, technologies, architectural changes, workflows, or functional requirements are part of Version 1.0.

Any modification requires the creation of Version 2.0 documentation before implementation.