package com.trivago.casestudy.model;

public record EnrichedPriceItem(
        Integer advertiserId,
        String currency,
        Float price
) {
}
