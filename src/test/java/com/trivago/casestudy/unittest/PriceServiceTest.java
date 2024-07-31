package com.trivago.casestudy.unittest;

import com.trivago.casestudy.PriceService;
import com.trivago.casestudy.model.EnrichedPriceItem;
import com.trivago.casestudy.repo.EnrichedPriceRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PriceServiceTest {
    @Mock
    EnrichedPriceRepository enrichedPriceRepository;

    @InjectMocks
    PriceService priceService;

    @Test
    void givenAccommodationId_whenAskForPrices_shouldFetchFromRepoAndReturnList() {
        int accommodationId = 1;
        when(enrichedPriceRepository.findAllByAccommodationId(accommodationId)).thenReturn(
                List.of(new EnrichedPriceItem("uuid", 1, accommodationId, "EUR", 100f))
        );

        List<EnrichedPriceItem> pricesForAccommodation = priceService.getPricesForAccommodation(accommodationId);

        assertThat(pricesForAccommodation)
                .hasSizeGreaterThan(0);
        verify(enrichedPriceRepository, times(1)).findAllByAccommodationId(accommodationId);
    }
}
