package com.trivago.casestudy.unitTests.loader;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trivago.casestudy.services.dataloader.JsonLoader;
import com.trivago.casestudy.models.AdvertiserInfo;
import com.trivago.casestudy.util.ObjectMapperFactory;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.net.URL;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class YamlLoaderTest {
    @Mock
    ObjectMapper objectMapper;

    @Mock
    ObjectMapperFactory objectMapperFactory;

    JsonLoader loader = new JsonLoader();

    @ParameterizedTest
    @CsvSource({"yaml, /prices/advertiser_100.yaml", "json, /prices/advertiser_200.json"})
    void givenYamlFile_whenLoad_shouldReturnParsedEntity(String type, String filePath) throws IOException {
        when(objectMapperFactory.getOrCreate(type)).thenReturn(objectMapper);

        URL resource = getClass().getResource(filePath);
        AdvertiserInfo advertiserInfo = loader.loadFrom(resource);

//        assertThat(advertiserInfo)
//                .hasFieldOrPropertyWithValue("name", "advertiser")
//                .hasFieldOrPropertyWithValue("id", 100)
//                .extracting(AdvertiserInfo::accommodations)
//                .asInstanceOf(InstanceOfAssertFactories.list(AdvertiserInfo.class))
//                .hasSizeGreaterThan(0);

        verify(objectMapperFactory, times(1)).getOrCreate(type);
        verify(objectMapper, times(1)).readValue(resource, AdvertiserInfo.class);
    }
}
