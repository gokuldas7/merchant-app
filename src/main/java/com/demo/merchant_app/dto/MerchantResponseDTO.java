package com.demo.merchant_app.dto;

import com.demo.merchant_app.models.Category;
import lombok.Data;

import java.util.List;

@Data
public class MerchantResponseDTO {

    private Long merchantId;
    private String shopName;
    private String ownerName;
    private String merchantRegistrationNumber;
    private List<Category> categories;
}
