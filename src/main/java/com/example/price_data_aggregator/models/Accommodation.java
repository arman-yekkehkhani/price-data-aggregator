package com.example.price_data_aggregator.models;

import java.util.List;

public record Accommodation(
        Integer id,
        List<Price> prices
) {
}
