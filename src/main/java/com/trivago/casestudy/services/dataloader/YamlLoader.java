package com.trivago.casestudy.services.dataloader;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trivago.casestudy.models.AdvertiserInfo;
import com.trivago.casestudy.util.ObjectMapperFactory;

import java.io.IOException;
import java.net.URL;

public class YamlLoader implements FileDataLoader {

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
