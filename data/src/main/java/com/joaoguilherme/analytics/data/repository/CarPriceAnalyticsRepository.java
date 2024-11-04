package com.joaoguilherme.analytics.data.repository;

import com.joaoguilherme.analytics.data.entity.BrandAnalyticEntity;
import com.joaoguilherme.analytics.data.entity.CarModelPriceEntity;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarPriceAnalyticsRepository extends JpaRepository<CarModelPriceEntity, Long> {
}
