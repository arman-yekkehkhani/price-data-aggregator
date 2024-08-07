package com.example.price_data_aggregator.services;

import com.example.price_data_aggregator.models.Accommodation;
import com.example.price_data_aggregator.models.EnrichedPrice;
import com.example.price_data_aggregator.models.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AccommodationProcessorService {
    private final KafkaTemplate<String, EnrichedPrice> kafkaTemplate;

    @Autowired
    public AccommodationProcessorService(KafkaTemplate<String, EnrichedPrice> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void convertToEnrichedPrice(Integer advertiserId, List<Accommodation> accommodations) {
        for (Accommodation accommodation : accommodations) {
            for (Price price : accommodation.prices()) {
                EnrichedPrice enrichedPrice = new EnrichedPrice(
                        UUID.randomUUID().toString(),
                        advertiserId,
                        accommodation.id(),
                        price.currency(),
                        price.price()
                );
                kafkaTemplate.send("accommodation", enrichedPrice);
            }
        }
    }
}
