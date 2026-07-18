//package com.harpreet.aihelpdesk.mapper;
//
//import com.harpreet.aihelpdesk.config.MapperConfiguration;
//import com.harpreet.aihelpdesk.entity.Ticket;
//import org.mapstruct.Mapper;
//import org.mapstruct.MappingTarget;
//
//@Mapper(
//        config = MapperConfiguration.class
//)
//public interface TicketMapper {
//
//    Ticket toEntity(
//
//            CreateTicketRequest request
//
//    );
//
//    TicketResponse toResponse(
//
//            Ticket ticket
//
//    );
//
//    void updateEntity(
//
//            UpdateTicketRequest request,
//
//            @MappingTarget
//            Ticket ticket
//
//    );
//
//}
