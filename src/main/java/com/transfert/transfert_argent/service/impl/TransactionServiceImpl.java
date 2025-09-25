package com.transfert.transfert_argent.service.impl;

import com.transfert.transfert_argent.model.Transaction;
import com.transfert.transfert_argent.model.Utilisateur;
import com.transfert.transfert_argent.repository.TransactionRepository;
import com.transfert.transfert_argent.repository.UtilisateurRepository;
import com.transfert.transfert_argent.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction enregistrerTransaction(Transaction transaction) {
        transaction.setDateTransaction(LocalDateTime.now());
        return transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction getTransactionById(Long id) {
        Optional<Transaction> transaction = transactionRepository.findById(id);
        return transaction.orElse(null);
    }

    @Override
    public void supprimerTransaction(Long id) {
        transactionRepository.deleteById(id);
    }

    @Override
    public Optional<Utilisateur> seConnecter(String email, String motDePasse) {
        UtilisateurRepository utilisateurRepository = null;
        Optional<Utilisateur> utilisateur = utilisateurRepository.findByEmail(email);
        if (utilisateur.isPresent() && utilisateur.get().getMotDePasse().equals(motDePasse)) {
            return utilisateur;
        }
        return Optional.empty();
    }

}
