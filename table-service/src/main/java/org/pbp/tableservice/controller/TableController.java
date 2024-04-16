package org.pbp.tableservice.controller;

import lombok.AllArgsConstructor;
import org.pbp.tableservice.dto.TableDto;
import org.pbp.tableservice.entity.TableStatus;
import org.pbp.tableservice.service.TableService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tables")
@AllArgsConstructor
public class TableController {

    private final TableService tableService;

    @GetMapping
    public ResponseEntity<List<TableDto>> findAll() {
        return ResponseEntity.ok(tableService.findAll());
    }

    @GetMapping("/{tableId}")
    public ResponseEntity<TableDto> findById(@PathVariable Long tableId) {
        return ResponseEntity.ok(tableService.findById(tableId));
    }

    @PutMapping("/{tableId}/status")
    public ResponseEntity<TableDto> updateTableStatus(@PathVariable Long tableId,
                                                      @RequestBody TableStatus status) {
        TableDto updateTable = tableService.updateTableStatus(tableId, status);
        return ResponseEntity.ok(updateTable);
    }
}
