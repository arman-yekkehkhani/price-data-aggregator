package com.trivago.casestudy.unitTests.services;

import com.trivago.casestudy.models.EnrichedPrice;
import com.trivago.casestudy.repos.EnrichedPriceRepository;
import com.trivago.casestudy.services.EnrichedPricePersistService;
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