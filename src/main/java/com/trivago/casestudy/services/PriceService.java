package com.trivago.casestudy.services;

import com.trivago.casestudy.models.EnrichedPrice;
import com.trivago.casestudy.repos.EnrichedPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceService {
    private final EnrichedPriceRepository enrichedPriceRepository;

    @Autowired
    public PriceService(EnrichedPriceRepository enrichedPriceRepository) {
        this.enrichedPriceRepository = enrichedPriceRepository;
    }

    @Cacheable(value = "accommodations")
    public List<EnrichedPrice> getPricesForAccommodation(int accommodationId) {
        return enrichedPriceRepository.findAllByAccommodationId(accommodationId);
    }
}
