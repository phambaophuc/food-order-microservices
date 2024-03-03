package org.pbp.tableservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.pbp.tableservice.entity.TableStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TableDto {
    private Long tableId;
    private Integer tableNumber;
    private TableStatus status;
    private Integer numberOfSeats;
}
