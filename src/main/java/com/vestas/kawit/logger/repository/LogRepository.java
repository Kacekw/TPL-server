package com.vestas.kawit.logger.repository;

import com.vestas.kawit.logger.service.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {
}
