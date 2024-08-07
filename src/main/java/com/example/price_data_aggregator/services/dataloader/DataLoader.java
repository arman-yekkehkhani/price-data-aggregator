package com.example.price_data_aggregator.services.dataloader;

import com.example.price_data_aggregator.models.AdvertiserInfo;

import java.net.URL;

public interface DataLoader {
    AdvertiserInfo loadFrom(URL resource);
}
