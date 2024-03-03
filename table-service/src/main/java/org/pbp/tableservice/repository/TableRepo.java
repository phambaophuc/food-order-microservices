package org.pbp.tableservice.repository;

import org.pbp.tableservice.entity.DiningTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableRepo extends JpaRepository<DiningTable, Long> {
}
