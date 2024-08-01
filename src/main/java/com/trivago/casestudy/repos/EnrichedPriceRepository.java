package com.trivago.casestudy.repos;

import com.trivago.casestudy.models.EnrichedPrice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrichedPriceRepository extends MongoRepository<EnrichedPrice, String> {
    List<EnrichedPrice> findAllByAccommodationId(Integer accommodationId);
}
