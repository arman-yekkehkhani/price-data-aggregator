package com.trivago.casestudy;

import com.trivago.casestudy.model.EnrichedPriceItem;
import com.trivago.casestudy.repo.EnrichedPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceService {
    private final EnrichedPriceRepository enrichedPriceRepository;

    @Autowired
    public PriceService(EnrichedPriceRepository enrichedPriceRepository) {
        this.enrichedPriceRepository = enrichedPriceRepository;
    }

    public List<EnrichedPriceItem> getPricesForAccommodation(int accommodationId) {
        return enrichedPriceRepository.findAllByAccommodationId(accommodationId);
    }
}
