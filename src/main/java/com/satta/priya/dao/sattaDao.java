package com.satta.priya.dao;

import com.satta.priya.model.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface sattaDao extends JpaRepository<Items,Integer> {
}
