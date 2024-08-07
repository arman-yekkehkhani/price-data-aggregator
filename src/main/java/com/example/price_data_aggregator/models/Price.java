package com.example.price_data_aggregator.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public record Price(
        String currency,
        @JsonDeserialize(using = PriceDeserializer.class)
        Float price
) {

}
