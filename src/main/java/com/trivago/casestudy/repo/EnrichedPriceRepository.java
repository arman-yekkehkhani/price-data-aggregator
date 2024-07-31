package com.trivago.casestudy.repo;

import com.trivago.casestudy.model.EnrichedPriceItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrichedPriceRepository extends MongoRepository<EnrichedPriceItem, String> {
    List<EnrichedPriceItem> findAllByAccommodationId(Integer accommodationId);
}
