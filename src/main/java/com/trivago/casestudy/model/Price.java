package com.trivago.casestudy.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public record Price(
        String currency,
        @JsonDeserialize(using = PriceDeserializer.class)
        Float price
) {

}
