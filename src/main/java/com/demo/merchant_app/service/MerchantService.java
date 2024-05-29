package com.demo.merchant_app.service;

import com.demo.merchant_app.dto.MerchantRequestDTO;
import com.demo.merchant_app.dto.MerchantResponseDTO;
import com.demo.merchant_app.exception.ApiException;
import com.demo.merchant_app.models.Merchant;

import java.util.List;

public interface MerchantService {
    MerchantResponseDTO addMerchant(MerchantRequestDTO merchantRequestDTO) throws ApiException;

    MerchantResponseDTO getMerchantById(Long merchantId) throws ApiException;

    List<Merchant> getAllMerchant();

    Object deleteMerchant(Long merchantId) throws ApiException;
}
