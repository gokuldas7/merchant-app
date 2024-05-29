package com.demo.merchant_app.controller;

import com.demo.merchant_app.dto.MerchantRequestDTO;
import com.demo.merchant_app.dto.MerchantResponseDTO;
import com.demo.merchant_app.exception.ApiException;
import com.demo.merchant_app.models.Merchant;
import com.demo.merchant_app.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/merchant")
public class MerchantController {

    @Autowired
    private MerchantService merchantService;

    @PostMapping("/addMerchant")
    public ResponseEntity<MerchantResponseDTO> addMerchant(@RequestBody MerchantRequestDTO merchantRequestDTO) throws ApiException {
        return ResponseEntity.ok(merchantService.addMerchant(merchantRequestDTO));
    }

    @GetMapping("/{merchantId}")
    public ResponseEntity<MerchantResponseDTO> getMerchantById(@PathVariable Long merchantId) throws ApiException {
        return ResponseEntity.ok(merchantService.getMerchantById(merchantId));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Merchant>> getAllMerchant() throws ApiException {
        return ResponseEntity.ok(merchantService.getAllMerchant());
    }

    @DeleteMapping("/delete/{merchantId}")
    public ResponseEntity<Object> deleteMerchant(@PathVariable Long merchantId) throws ApiException {
        return ResponseEntity.ok(merchantService.deleteMerchant(merchantId));
    }
}
