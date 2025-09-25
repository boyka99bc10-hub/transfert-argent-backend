package com.transfert.transfert_argent.repository;

import com.transfert.transfert_argent.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByExpediteurIdOrDestinataireId(Long expediteurId, Long destinataireId);
}
