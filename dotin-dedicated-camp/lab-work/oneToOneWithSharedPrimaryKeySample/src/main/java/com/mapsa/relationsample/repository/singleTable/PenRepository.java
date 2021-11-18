package com.mapsa.relationsample.repository.singleTable;

import com.mapsa.relationsample.model.singleTable.Pen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PenRepository extends JpaRepository<Pen, Integer> {
}
