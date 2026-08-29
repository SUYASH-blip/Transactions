package org.example.transactions.repository;

import org.example.transactions.entity.TransferRecords;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<TransferRecords,Long> {
}
