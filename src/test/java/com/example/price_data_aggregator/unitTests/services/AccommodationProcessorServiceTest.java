package com.example.price_data_aggregator.unitTests.services;

import com.example.price_data_aggregator.models.Accommodation;
import com.example.price_data_aggregator.models.EnrichedPrice;
import com.example.price_data_aggregator.models.Price;
import com.example.price_data_aggregator.services.AccommodationProcessorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AccommodationProcessorServiceTest {
    @Mock
    KafkaTemplate<String, EnrichedPrice> kafkaTemplate;

    @InjectMocks
    AccommodationProcessorService accommodationProcessorService;

    @Captor
    private ArgumentCaptor<EnrichedPrice> enrichedPriceCaptor;


    @Test
    void givenAdvertiserIdAndAccommodations_whenConvertToEnrichedPrice_shouldSendToKafka() {
        Integer advertiserId = 1;
        List<Accommodation> accommodations = List.of(
                new Accommodation(2, List.of(new Price("EUR", 100.f))),
                new Accommodation(3, List.of(new Price("USD", 20.f)))
        );

        accommodationProcessorService.convertToEnrichedPrice(advertiserId, accommodations);

        verify(kafkaTemplate, times(2)).send(eq("accommodation"), enrichedPriceCaptor.capture());
        List<EnrichedPrice> capturedEnrichedPrices = enrichedPriceCaptor.getAllValues();

        EnrichedPrice firstEnrichedPrice = capturedEnrichedPrices.get(0);
        assertNotNull(firstEnrichedPrice);
        assertEquals(advertiserId, firstEnrichedPrice.advertiserId());
        assertEquals(2, firstEnrichedPrice.accommodationId());
        assertEquals("EUR", firstEnrichedPrice.currency());
        assertEquals(100.f, firstEnrichedPrice.price());

        EnrichedPrice secondEnrichedPrice = capturedEnrichedPrices.get(1);
        assertNotNull(secondEnrichedPrice);
        assertEquals(advertiserId, secondEnrichedPrice.advertiserId());
        assertEquals(3, secondEnrichedPrice.accommodationId());
        assertEquals("USD", secondEnrichedPrice.currency());
        assertEquals(20.f, secondEnrichedPrice.price());
    }
}