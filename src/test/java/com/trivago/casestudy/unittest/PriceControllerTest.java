package com.trivago.casestudy.unittest;

import com.trivago.casestudy.PriceController;
import com.trivago.casestudy.PriceService;
import com.trivago.casestudy.model.EnrichedPriceItem;
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

        List<EnrichedPriceItem> priceItemList = List.of(
                new EnrichedPriceItem(1, "EUR", 120.4f),
                new EnrichedPriceItem(2, "EUr", 11f)
        );


        when(priceService.getPricesForAccommodation(accommodationId)).thenReturn(priceItemList);

        List<EnrichedPriceItem> prices = priceController.getPrices(1);
        assertThat(prices)
                .hasSize(2)
                .containsExactly(
                        new EnrichedPriceItem(1, "EUR", 120.4f),
                        new EnrichedPriceItem(2, "EUr", 11f)
                );
    }
}
