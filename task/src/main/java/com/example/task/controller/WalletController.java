package com.example.task.controller;

import com.example.task.dto.ApiResponse;
import com.example.task.dto.WalletRequest;
import com.example.task.service.WalletService;
import lombok.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class WalletController {

    private final WalletService walletService;

    @PostMapping("/wallet")
    public ResponseEntity<ApiResponse<Void>> updateWallet(
            @RequestBody WalletRequest request) {

        walletService.updateWallet(request);

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Wallet updated successfully", null)
        );
    }

    @GetMapping("/wallets/{walletId}")
    public ResponseEntity<ApiResponse<Long>> getBalance(
            @PathVariable UUID walletId) {

        Long balance = walletService.getBalance(walletId);

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Wallet balance fetched successfully", balance)
        );
    }
}
