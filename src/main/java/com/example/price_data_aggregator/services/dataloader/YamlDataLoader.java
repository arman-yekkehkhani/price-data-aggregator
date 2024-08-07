package com.example.price_data_aggregator.services.dataloader;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.price_data_aggregator.models.AdvertiserInfo;
import com.example.price_data_aggregator.util.ObjectMapperFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;

@Component("yamlDataLoader")
public class YamlDataLoader implements DataLoader {

    @Override
    public AdvertiserInfo loadFrom(URL resource) {
        try {
            ObjectMapper objectMapper = ObjectMapperFactory.getInstance().getOrCreate("yaml");
            return objectMapper.readValue(resource, AdvertiserInfo.class);
        } catch (IOException e) {
            return null;
        }
    }
}
