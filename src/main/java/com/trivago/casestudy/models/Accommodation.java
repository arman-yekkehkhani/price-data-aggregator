package com.trivago.casestudy.models;

import java.util.List;

public record Accommodation(
        Integer id,
        List<Price> prices
) {
}
