package com.trivago.casestudy.unitTests.controllers;

import com.trivago.casestudy.controllers.PriceController;
import com.trivago.casestudy.services.PriceService;
import com.trivago.casestudy.models.EnrichedPrice;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PriceControllerTest {

    @Mock
    PriceService priceService;

    @InjectMocks
    PriceController priceController;

    @Test
    void givenAccommodationId_whenGetPrices_shouldReturnListOfPrices() {
        int accommodationId = 1;

        List<EnrichedPrice> priceItemList = List.of(
                new EnrichedPrice("uuid1", 3, 2, "EUR",120.4f),
                new EnrichedPrice("uuid2", 4, 1, "EUR" ,11f)
        );


        when(priceService.getPricesForAccommodation(accommodationId)).thenReturn(priceItemList);

        List<EnrichedPrice> prices = priceController.getPrices(1);
        assertThat(prices)
                .hasSize(2)
                .containsExactly(
                        new EnrichedPrice("uuid1", 3, 2, "EUR",120.4f),
                        new EnrichedPrice("uuid2", 4, 1, "EUR" ,11f)
                );
    }
}
