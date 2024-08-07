package com.example.price_data_aggregator.repos;

import com.example.price_data_aggregator.models.EnrichedPrice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrichedPriceRepository extends MongoRepository<EnrichedPrice, String> {
    List<EnrichedPrice> findAllByAccommodationId(Integer accommodationId);
}
