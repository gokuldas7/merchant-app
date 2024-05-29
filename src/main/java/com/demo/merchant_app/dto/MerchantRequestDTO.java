package com.demo.merchant_app.dto;

import lombok.Data;

import java.util.List;

@Data
public class MerchantRequestDTO {

    private String shopName;
    private String ownerName;
    private String merchantRegistrationNumber;
    private List<Long> categoryIds;
}
