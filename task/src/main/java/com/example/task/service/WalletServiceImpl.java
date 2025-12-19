package com.example.task.service;


import com.example.task.dto.OperationType;
import com.example.task.dto.WalletRequest;
import com.example.task.entity.Wallet;
import com.example.task.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {

    private final WalletRepository walletRepository;


    @Override
    @Transactional
    public void updateWallet(WalletRequest request) {

        Wallet wallet = walletRepository.lockById(request.getWalletId())
                .orElseThrow(() -> new RuntimeException("Wallet not found"));

        if (request.getOperationType() == OperationType.WITHDRAW) {

            if (wallet.getBalance() < request.getAmount()) {
                throw new RuntimeException("Insufficient funds");
            }

            wallet.setBalance(wallet.getBalance() - request.getAmount());

        } else if (request.getOperationType() == OperationType.DEPOSIT) {

            wallet.setBalance(wallet.getBalance() + request.getAmount());
        }
    }


    @Override
    public Long getBalance(UUID walletId) {

        return walletRepository.findById(walletId)
                .orElseThrow(() -> new RuntimeException("Wallet not found"))
                .getBalance();
    }
}
