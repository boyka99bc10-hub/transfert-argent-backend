package com.transfert.transfert_argent.service;

import com.transfert.transfert_argent.model.Utilisateur;

import java.util.List;
import java.util.Optional;

public interface UtilisateurService {
    Utilisateur creerUtilisateur(Utilisateur utilisateur);
    List<Utilisateur> getAllUtilisateurs();
    Utilisateur getUtilisateurById(Long id);
    void supprimerUtilisateur(Long id);

    Utilisateur getUtilisateurByEmail(String email);

    Optional<Utilisateur> seConnecter(String email, String motDePasse);
}
