package com.trivago.casestudy.integrationTests;

import com.trivago.casestudy.models.EnrichedPrice;
import com.trivago.casestudy.repos.EnrichedPriceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
public class EnrichedPriceRepositoryIT {

    @Autowired
    EnrichedPriceRepository enrichedPriceRepository;

    @Test
    void givenEnrichedPriceItems_whenFindAllByAccommodationId_shouldReturnListOfEnrichedPriceItems() {
        List<EnrichedPrice> priceItemList = List.of(
                new EnrichedPrice("uuid1", 1, 1, "EUR", 10f),
                new EnrichedPrice("uuid2", 2, 1, "EUR", 20f),
                new EnrichedPrice("uuid3", 1, 2, "EUR", 50f)
        );

        enrichedPriceRepository.saveAll(priceItemList);

        List<EnrichedPrice> priceItems = enrichedPriceRepository.findAllByAccommodationId(1);

        assertThat(priceItems)
                .hasSize(2)
                .containsExactly(
                        new EnrichedPrice("uuid1", 1, 1, "EUR", 10f),
                        new EnrichedPrice("uuid2", 2, 1, "EUR", 20f)
                );
    }

}
