package com.joaoguilherme.analytics.data.repository;

import com.joaoguilherme.analytics.data.entity.BrandAnalyticEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrandAnalyticsRepository  extends JpaRepository<BrandAnalyticEntity, Long> {

    Optional<BrandAnalyticEntity> findByBrand(String brand);

}
