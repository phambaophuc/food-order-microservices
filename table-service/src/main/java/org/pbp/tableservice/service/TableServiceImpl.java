package org.pbp.tableservice.service;

import lombok.AllArgsConstructor;
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
public class TableServiceImpl implements TableService {

    private final TableRepo tableRepo;

    @Override
    public List<TableDto> findAll() {
        return tableRepo.findAll()
                .stream()
                .map(TableMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public TableDto findById(Long tableId) {
        return tableRepo.findById(tableId)
                .map(TableMapper::mapToDto)
                .orElseThrow();
    }

    @Override
    @Transactional
    public TableDto updateTableStatus(Long tableId, TableStatus status) {
        TableDto updateTable = this.findById(tableId);
        updateTable.setStatus(status);
        return TableMapper.mapToDto(tableRepo.save(TableMapper.mapToTable(updateTable)));
    }
}
