package org.pbp.tableservice.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.pbp.tableservice.dto.TableDto;
import org.pbp.tableservice.entity.TableStatus;
import org.pbp.tableservice.mapper.TableMapper;
import org.pbp.tableservice.repository.TableRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class TableServiceImpl implements TableService {

    private final TableRepo tableRepo;

    @Override
    public List<TableDto> findAll() {
        log.info("** Table service: find all tables *");
        return tableRepo.findAll()
                .stream()
                .map(TableMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public TableDto findById(Long tableId) {
        log.info("** Table service: find table by id *");
        return tableRepo.findById(tableId)
                .map(TableMapper::mapToDto)
                .orElseThrow();
    }

    @Override
    @Transactional
    public TableDto updateTableStatus(Long tableId, TableStatus status) {
        log.info("** Table service: update table status *");
        TableDto updateTable = this.findById(tableId);
        updateTable.setStatus(status);
        return TableMapper.mapToDto(tableRepo.save(TableMapper.mapToTable(updateTable)));
    }
}
