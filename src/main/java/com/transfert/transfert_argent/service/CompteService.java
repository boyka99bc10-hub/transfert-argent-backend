package com.transfert.transfert_argent.service;

import com.transfert.transfert_argent.model.Compte;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

public interface CompteService {
    @Transactional
    Compte createCompte(Long ownerId, BigDecimal initialBalance);

    Compte getById(Long id);

    Compte getByNumero(String numeroCompte);

    List<Compte> getByOwnerId(Long ownerId);

    @Transactional
    Compte deposit(String numeroCompte, BigDecimal amount);

    @Transactional
    Compte withdraw(String numeroCompte, BigDecimal amount);

    Compte createAccount(Compte compte);
    List<Compte> getAllAccounts();
    Compte getAccountById(Long id);

    // ✅ nouvelles méthodes
    Compte depot(Long id, BigDecimal montant);
    Compte retrait(Long id, BigDecimal montant);
    void transfert(Long sourceId, Long destId, BigDecimal montant);
}
