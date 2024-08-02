package com.trivago.casestudy.unitTests.controllers;

import com.trivago.casestudy.controllers.LoaderController;
import com.trivago.casestudy.services.FileDataLoaderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class LoaderControllerTest {
    @Mock
    FileDataLoaderService fileDataLoaderService;

    @InjectMocks
    LoaderController loaderController;

    @Test
    void givenResourcePath_whenInvoked_shouldLoadThroughFileDataLoader() {
        String resource = "prices/advertiser_300.json";

        loaderController.loadResource(resource);

        verify(fileDataLoaderService, times(1)).loadResource(resource);
    }
}
