package com.example.task.service;

import com.example.task.dto.WalletRequest;

import java.util.UUID;

public interface WalletService {


    void updateWallet(WalletRequest request);

    Long getBalance(UUID walletId);
}