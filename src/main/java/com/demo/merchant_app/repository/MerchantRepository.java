package com.demo.merchant_app.repository;

import com.demo.merchant_app.models.Category;
import com.demo.merchant_app.models.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface MerchantRepository extends JpaRepository<Merchant, Long> {
    boolean existsByMerchantRegistrationNumber(String merchantRegistrationNumber);

    @Query("SELECT m.categories FROM Merchant m WHERE m.merchantId = :merchantId")
    Set<Category> findCategoriesByMerchantId(@Param("merchantId") Long merchantId);
}
