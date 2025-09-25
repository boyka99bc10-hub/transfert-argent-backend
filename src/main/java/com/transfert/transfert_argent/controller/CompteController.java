package com.transfert.transfert_argent.controller;

import com.transfert.transfert_argent.model.Compte;
import com.transfert.transfert_argent.model.Utilisateur;
import com.transfert.transfert_argent.repository.CompteRepository;
import com.transfert.transfert_argent.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comptes")
@CrossOrigin(origins = "http://localhost:3000")
public class CompteController {

    @Autowired
    private CompteRepository compteRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    // Créer un compte
    @PostMapping
    public Compte createCompte(@RequestBody Compte compte) {
        if (compte.getOwner() != null && compte.getOwner().getId() != null) {
            Utilisateur owner = utilisateurRepository
                    .findById(compte.getOwner().getId())
                    .orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));
            compte.setOwner(owner);
        }
        return compteRepository.save(compte);
    }

    // Liste des comptes
    @GetMapping
    public List<Compte> getAllComptes() {
        return compteRepository.findAll();
    }
}
