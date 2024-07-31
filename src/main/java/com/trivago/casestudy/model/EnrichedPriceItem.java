package com.trivago.casestudy.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "priceItems")
public record EnrichedPriceItem(
        @Id
        String uuid,
        Integer advertiserId,
        Integer accommodationId,
        String currency,
        Float price
) {
}
