package com.transfert.transfert_argent.DTO;

import java.math.BigDecimal;

public class CompteResponse {
    private Long id;
    private String numeroCompte;
    private BigDecimal solde;
    private Long ownerId;
    private String ownerEmail; // facultatif

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNumeroCompte() { return numeroCompte; }
    public void setNumeroCompte(String numeroCompte) { this.numeroCompte = numeroCompte; }

    public BigDecimal getSolde() { return solde; }
    public void setSolde(java.math.BigDecimal solde) { this.solde = solde; }

    public Long getOwnerId() { return ownerId; }
    public void setOwnerId(Long ownerId) { this.ownerId = ownerId; }

    public String getOwnerEmail() { return ownerEmail; }
    public void setOwnerEmail(String ownerEmail) { this.ownerEmail = ownerEmail; }
}
