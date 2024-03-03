package org.pbp.tableservice.entity;

import lombok.Getter;

@Getter
public enum TableStatus {
    AVAILABLE("AVAILABLE"),
    RESERVED("RESERVED"),
    OCCUPIED("OCCUPIED");

    private final String status;

    TableStatus(String status) {
        this.status = status;
    }
}
