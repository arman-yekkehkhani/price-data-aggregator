package com.example.price_data_aggregator.services;

import com.example.price_data_aggregator.models.EnrichedPrice;
import com.example.price_data_aggregator.repos.EnrichedPriceRepository;
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
