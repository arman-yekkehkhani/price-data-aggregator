package com.trivago.casestudy.services;

import com.trivago.casestudy.models.EnrichedPrice;
import com.trivago.casestudy.repos.EnrichedPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EnrichedPricePersistService {

    private final EnrichedPriceRepository enrichedPriceRepository;

    @Autowired
    public EnrichedPricePersistService(EnrichedPriceRepository enrichedPriceRepository) {
        this.enrichedPriceRepository = enrichedPriceRepository;
    }

    @KafkaListener(topics = "accommodation", groupId = "1")
    public void receiveMessage(EnrichedPrice enrichedPrice) {
        enrichedPriceRepository.save(enrichedPrice);
    }
}
