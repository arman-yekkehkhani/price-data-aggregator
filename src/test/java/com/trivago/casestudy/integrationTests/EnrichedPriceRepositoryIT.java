package com.trivago.casestudy.integrationTests;

import com.trivago.casestudy.model.EnrichedPriceItem;
import com.trivago.casestudy.repo.EnrichedPriceRepository;
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
        List<EnrichedPriceItem> priceItemList = List.of(
                new EnrichedPriceItem("uuid1", 1, 1, "EUR", 10f),
                new EnrichedPriceItem("uuid2", 2, 1, "EUR", 20f),
                new EnrichedPriceItem("uuid3", 1, 2, "EUR", 50f)
        );

        enrichedPriceRepository.saveAll(priceItemList);

        List<EnrichedPriceItem> priceItems = enrichedPriceRepository.findAllByAccommodationId(1);

        assertThat(priceItems)
                .hasSize(2)
                .containsExactly(
                        new EnrichedPriceItem("uuid1", 1, 1, "EUR", 10f),
                        new EnrichedPriceItem("uuid2", 2, 1, "EUR", 20f)
                );
    }

}
