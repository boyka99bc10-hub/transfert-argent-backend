package com.transfert.transfert_argent.service;

import com.transfert.transfert_argent.model.Transaction;
import com.transfert.transfert_argent.model.Utilisateur;

import java.util.List;
import java.util.Optional;

public interface TransactionService {
    Transaction enregistrerTransaction(Transaction transaction);
    List<Transaction> getAllTransactions();
    Transaction getTransactionById(Long id);
    void supprimerTransaction(Long id);

    // TransactionService.java ou UtilisateurService.java
    Optional<Utilisateur> seConnecter(String email, String motDePasse);

}
