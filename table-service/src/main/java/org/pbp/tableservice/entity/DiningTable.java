package org.pbp.tableservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "dining_tables")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DiningTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "table_id")
    private Long tableId;

    @Column(name = "table_number")
    private Integer tableNumber;

    @Column(name = "status")
    private TableStatus status;

    @Column(name = "number_of_seats")
    private Integer numberOfSeats;
}
