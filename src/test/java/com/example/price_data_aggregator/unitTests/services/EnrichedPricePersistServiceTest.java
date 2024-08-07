package com.example.price_data_aggregator.unitTests.services;

import com.example.price_data_aggregator.models.EnrichedPrice;
import com.example.price_data_aggregator.repos.EnrichedPriceRepository;
import com.example.price_data_aggregator.services.EnrichedPricePersistService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class EnrichedPricePersistServiceTest {
    @Mock
    EnrichedPriceRepository enrichedPriceRepository;

    @InjectMocks
    EnrichedPricePersistService enrichedPricePersistService;

    @Test
    void whenCallReceiveEnrichedPrice_shouldPersist() {
        EnrichedPrice enrichedPrice = new EnrichedPrice("uuid", 1, 2, "EUR", 100f);

        enrichedPricePersistService.receiveMessage(enrichedPrice);

        verify(enrichedPriceRepository, times(1)).save(enrichedPrice);
    }
}