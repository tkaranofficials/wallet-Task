package com.example.task.config;

import com.example.task.entity.Wallet;
import com.example.task.repository.WalletRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.*;

import java.util.UUID;


    @Component
    @RequiredArgsConstructor
    public class DataInitializer {

        private final WalletRepository walletRepository;

        @PostConstruct
        public void init() {
            UUID walletId = UUID.fromString("11111111-1111-1111-1111-111111111111");

            walletRepository.findById(walletId)
                    .orElseGet(() -> walletRepository.save(
                            new Wallet(walletId, 0L)
                    ));
        }
    }

