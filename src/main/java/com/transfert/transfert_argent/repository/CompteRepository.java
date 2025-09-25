package com.transfert.transfert_argent.repository;

import com.transfert.transfert_argent.model.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<Compte, Long> {
}
