package com.satta.priya.dao;

import com.satta.priya.model.records;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface recordDao extends JpaRepository<records,Integer> {
    Optional<Record> findBySid(Integer sid);

    default void saveIfNotExists(records record) {
        findBySid(record.getSid())
                .ifPresentOrElse(
                        existingRecord -> {
                            // Record with the same sid already exists, do nothing or handle it as needed
                            // For example, you can throw an exception, log a message, etc.
                        },
                        () -> save(record)
                );
    }

}
