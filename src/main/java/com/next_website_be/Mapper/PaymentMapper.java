package com.next_website_be.Mapper;

import com.next_website_be.DTO.PaymentDTO;
import com.next_website_be.Entities.Payment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    PaymentDTO toDTO(Payment entity);
    Payment toEntity(PaymentDTO dto);
}
