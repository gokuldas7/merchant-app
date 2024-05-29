package com.demo.merchant_app.service.impl;

import com.demo.merchant_app.dto.MerchantRequestDTO;
import com.demo.merchant_app.dto.MerchantResponseDTO;
import com.demo.merchant_app.dto.Message;
import com.demo.merchant_app.exception.ApiException;
import com.demo.merchant_app.models.Category;
import com.demo.merchant_app.models.Merchant;
import com.demo.merchant_app.repository.CategoryRepository;
import com.demo.merchant_app.repository.MerchantRepository;
import com.demo.merchant_app.service.MerchantService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    private MerchantRepository merchantRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public MerchantResponseDTO addMerchant(MerchantRequestDTO merchantRequestDTO) throws ApiException {
        if (merchantRepository.existsByMerchantRegistrationNumber(merchantRequestDTO.getMerchantRegistrationNumber())) {
            throw new ApiException("Registration Number Already Exists");
        }
        Set<Category> categories = new HashSet<>();
        for (Long categoryId : merchantRequestDTO.getCategoryIds()) {
            Category category = categoryRepository.findById(categoryId)
                    .orElseThrow(() -> new ApiException("Category not found with ID: " + categoryId));
            categories.add(category);
        }
        Merchant merchant = modelMapper.map(merchantRequestDTO, Merchant.class);
        merchant.setCategories(categories);
        Merchant savedMerchant = merchantRepository.save(merchant);

        MerchantResponseDTO merchantResponseDTO = modelMapper.map(savedMerchant, MerchantResponseDTO.class);
        return merchantResponseDTO;
    }

    @Override
    public MerchantResponseDTO getMerchantById(Long merchantId) throws ApiException {
        Optional<Merchant> optionalMerchant = merchantRepository.findById(merchantId);

        if (optionalMerchant.isPresent()) {
            Merchant merchant = optionalMerchant.get();
            Set<Category> categories = merchantRepository.findCategoriesByMerchantId(merchantId);
            MerchantResponseDTO merchantResponseDTO = modelMapper.map(merchant, MerchantResponseDTO.class);
            return merchantResponseDTO;

        } else {
            throw new ApiException("Merchant not found with ID: " + merchantId);
        }
    }

    @Override
    public List<Merchant> getAllMerchant() {
        return merchantRepository.findAll();
    }

    @Override
    public Object deleteMerchant(Long merchantId) throws ApiException {
        Optional<Merchant> optionalMerchant = merchantRepository.findById(merchantId);
        if (optionalMerchant.isPresent()) {
            Merchant merchant = optionalMerchant.get();

            merchant.getCategories().clear();
            merchantRepository.save(merchant);
            merchantRepository.delete(merchant);
            Message message = new Message();
            message.setMessage("Merchant deleted successfully.");
            return message;
        } else throw new ApiException("Merchant not found with ID: " + merchantId);
    }
}
