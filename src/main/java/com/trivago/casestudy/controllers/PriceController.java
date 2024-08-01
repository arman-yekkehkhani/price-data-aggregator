package com.trivago.casestudy.controllers;

import java.util.List;

import com.trivago.casestudy.services.PriceService;
import com.trivago.casestudy.models.EnrichedPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PriceController {

  private final PriceService priceService;

  @Autowired
  public PriceController(PriceService priceService) {
    this.priceService = priceService;
  }

  @GetMapping("/prices/{accommodationId}")
  public List<EnrichedPrice> getPrices(@PathVariable int accommodationId) {
    return priceService.getPricesForAccommodation(accommodationId);
  }
}
