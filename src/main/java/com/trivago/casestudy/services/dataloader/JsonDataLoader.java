package com.trivago.casestudy.services.dataloader;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trivago.casestudy.models.AdvertiserInfo;
import com.trivago.casestudy.util.ObjectMapperFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;

@Component("jsonDataLoader")
public class JsonDataLoader implements FileDataLoader {

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
