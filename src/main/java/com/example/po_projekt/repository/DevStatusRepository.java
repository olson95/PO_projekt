package com.example.po_projekt.repository;

import com.example.po_projekt.entity.DevStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevStatusRepository extends JpaRepository<DevStatus, Long> {
}
