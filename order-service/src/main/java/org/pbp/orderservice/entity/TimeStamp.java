package org.pbp.orderservice.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@MappedSuperclass
public class TimeStamp {

    @Column(updatable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate createdAt;

    private LocalDate updatedAt;

    @PrePersist
    protected void onCreated() {
        createdAt = LocalDate.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDate.now();
    }
}
