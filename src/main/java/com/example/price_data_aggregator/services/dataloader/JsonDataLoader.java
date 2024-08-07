package com.example.price_data_aggregator.services.dataloader;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.price_data_aggregator.models.AdvertiserInfo;
import com.example.price_data_aggregator.util.ObjectMapperFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;

@Component("jsonDataLoader")
public class JsonDataLoader implements DataLoader {

    @Override
    public AdvertiserInfo loadFrom(URL resource) {
        ObjectMapper objectMapper = ObjectMapperFactory.getInstance().getOrCreate("json");
        try {
            return objectMapper.readValue(resource, AdvertiserInfo.class);
        } catch (IOException e) {
            return null;
        }
    }
}
