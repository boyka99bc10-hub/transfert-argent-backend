package com.transfert.transfert_argent.DTO;

import java.math.BigDecimal;

public class CreateCompteRequest {
    private Long ownerId;
    private BigDecimal initialBalance; // optionnel

    public Long getOwnerId() { return ownerId; }
    public void setOwnerId(Long ownerId) { this.ownerId = ownerId; }

    public BigDecimal getInitialBalance() { return initialBalance; }
    public void setInitialBalance(BigDecimal initialBalance) { this.initialBalance = initialBalance; }
}
