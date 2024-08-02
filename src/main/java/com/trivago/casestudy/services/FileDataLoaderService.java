package com.trivago.casestudy.services;

import com.trivago.casestudy.services.dataloader.FileDataLoader;
import com.trivago.casestudy.services.dataloader.JsonLoader;
import com.trivago.casestudy.models.AdvertiserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URL;

@Service
public class FileDataLoaderService {

    FileDataLoader fileDataLoader = new JsonLoader();

    private final AccommodationProcessorService accommodationProcessor;

    @Autowired
    public FileDataLoaderService(AccommodationProcessorService accommodationProcessor) {
        this.accommodationProcessor = accommodationProcessor;
    }

    public void loadResource(String resource) {
        URL url = getClass().getResource(resource);
        AdvertiserInfo advertiserInfo = fileDataLoader.loadFrom(url);
        accommodationProcessor.convertToEnrichedPrice(advertiserInfo.id(), advertiserInfo.accommodations());
    }
}
