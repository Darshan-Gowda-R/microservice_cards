package com.kaveri_bank.card.entity;

import java.time.LocalDateTime;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {
    
    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAT;

    private String updatedBy;
    
}
