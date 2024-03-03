package org.pbp.tableservice.service;

import org.pbp.tableservice.dto.TableDto;

import java.util.List;

public interface TableService {

    List<TableDto> findAll();

    TableDto findById(Long tableId);
}
