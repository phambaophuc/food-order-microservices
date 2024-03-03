package org.pbp.tableservice.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.pbp.tableservice.dto.TableDto;
import org.pbp.tableservice.service.TableService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tables")
@AllArgsConstructor
@Slf4j
public class TableController {

    private final TableService tableService;

    @GetMapping
    public ResponseEntity<List<TableDto>> findAll() {
        log.info("** Table controller: find all tables *");
        return ResponseEntity.ok(tableService.findAll());
    }

    @GetMapping("/{tableId}")
    public ResponseEntity<TableDto> findById(@PathVariable Long tableId) {
        log.info("** Table controller: find table by id *");
        return ResponseEntity.ok(tableService.findById(tableId));
    }
}
