package com.trivago.casestudy.model;

import java.util.List;

public record Accommodation(
        Integer id,
        List<Price> prices
) {
}
