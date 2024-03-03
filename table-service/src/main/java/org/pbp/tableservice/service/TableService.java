package org.pbp.tableservice.service;

import org.pbp.tableservice.dto.TableDto;
import org.pbp.tableservice.entity.TableStatus;

import java.util.List;

public interface TableService {

    List<TableDto> findAll();

    TableDto findById(Long tableId);

    TableDto updateTableStatus(Long tableId, TableStatus status);
}
