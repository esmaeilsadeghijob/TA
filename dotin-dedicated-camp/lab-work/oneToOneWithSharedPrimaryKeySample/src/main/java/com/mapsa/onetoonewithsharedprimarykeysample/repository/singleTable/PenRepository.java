package com.mapsa.onetoonewithsharedprimarykeysample.repository.singleTable;

import com.mapsa.onetoonewithsharedprimarykeysample.model.singleTable.Pen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PenRepository extends JpaRepository<Pen, Integer> {
}
