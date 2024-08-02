package com.trivago.casestudy.services;

import com.trivago.casestudy.models.AdvertiserInfo;
import com.trivago.casestudy.services.dataloader.FileDataLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.net.URL;

@Service
public class FileDataLoaderService {
    @Qualifier("json")
    private final FileDataLoader jsonLoader;
    private final FileDataLoader yamlLoader;
    private final AccommodationProcessorService accommodationProcessor;

    @Autowired
    public FileDataLoaderService(@Qualifier("jsonDataLoader") FileDataLoader jsonLoader,
                                 @Qualifier("yamlDataLoader") FileDataLoader yamlLoader,
                                 AccommodationProcessorService accommodationProcessor) {
        this.jsonLoader = jsonLoader;
        this.yamlLoader = yamlLoader;
        this.accommodationProcessor = accommodationProcessor;
    }

    public void loadResource(String resource) {
        URL url = getClass().getResource(resource);
        AdvertiserInfo advertiserInfo;
        if (resource.endsWith(".json")) {
            advertiserInfo = jsonLoader.loadFrom(url);
        } else if (resource.endsWith("yaml")) {
            advertiserInfo = yamlLoader.loadFrom(url);
        } else {
            throw new IllegalArgumentException("File format not supported.");
        }
        accommodationProcessor.convertToEnrichedPrice(advertiserInfo.id(), advertiserInfo.accommodations());
    }
}
