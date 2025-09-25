package com.transfert.transfert_argent.service.impl;

import com.transfert.transfert_argent.model.Compte;
import com.transfert.transfert_argent.repository.CompteRepository;
import com.transfert.transfert_argent.service.CompteService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CompteServiceImpl implements CompteService {

    private final CompteRepository compteRepository;

    public CompteServiceImpl(CompteRepository compteRepository) {
        this.compteRepository = compteRepository;
    }

    @Override
    public Compte createCompte(Long ownerId, BigDecimal initialBalance) {
        return null;
    }

    @Override
    public Compte getById(Long id) {
        return null;
    }

    @Override
    public Compte getByNumero(String numeroCompte) {
        return null;
    }

    @Override
    public List<Compte> getByOwnerId(Long ownerId) {
        return List.of();
    }

    @Override
    public Compte deposit(String numeroCompte, BigDecimal amount) {
        return null;
    }

    @Override
    public Compte withdraw(String numeroCompte, BigDecimal amount) {
        return null;
    }

    @Override
    public Compte createAccount(Compte compte) {
        return compteRepository.save(compte);
    }

    @Override
    public List<Compte> getAllAccounts() {
        return compteRepository.findAll();
    }

    @Override
    public Compte getAccountById(Long id) {
        return compteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compte non trouvé"));
    }

    // ✅ Dépôt
    @Override
    public Compte depot(Long id, BigDecimal montant) {
        Compte compte = getAccountById(id);
        compte.setSolde(compte.getSolde().add(montant));
        return compteRepository.save(compte);
    }

    // ✅ Retrait
    @Override
    public Compte retrait(Long id, BigDecimal montant) {
        Compte compte = getAccountById(id);
        if (compte.getSolde().compareTo(montant) < 0) {
            throw new RuntimeException("Solde insuffisant !");
        }
        compte.setSolde(compte.getSolde().subtract(montant));
        return compteRepository.save(compte);
    }

    // ✅ Transfert
    @Override
    public void transfert(Long sourceId, Long destId, BigDecimal montant) {
        Compte source = getAccountById(sourceId);
        Compte dest = getAccountById(destId);

        if (source.getSolde().compareTo(montant) < 0) {
            throw new RuntimeException("Solde insuffisant !");
        }

        source.setSolde(source.getSolde().subtract(montant));
        dest.setSolde(dest.getSolde().add(montant));

        compteRepository.save(source);
        compteRepository.save(dest);
    }
}
