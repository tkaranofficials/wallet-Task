package com.example.task.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
public class WalletRequest {
    private UUID walletId;
    private OperationType operationType;
    private Long amount;
}
