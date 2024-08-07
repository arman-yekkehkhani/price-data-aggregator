package com.example.price_data_aggregator.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record AdvertiserInfo(
        String name,
        Integer id,
        @JsonProperty("accommodation")
        List<Accommodation> accommodations
) {
}
