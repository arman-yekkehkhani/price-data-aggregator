package com.trivago.casestudy;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.trivago.casestudy.model.AdvertiserInfo;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;

public class LoadInputDataTest {

    @Test
    void givenYamlFile_whenLoad_shouldReturnParsedEntity() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        URL resource = getClass().getResource("/prices/advertiser_100.yaml");
        AdvertiserInfo advertiserInfo = objectMapper.readValue(resource, AdvertiserInfo.class);

        assertThat(advertiserInfo)
                .hasFieldOrPropertyWithValue("name", "advertiser")
                .hasFieldOrPropertyWithValue("id", 100)
                .extracting(AdvertiserInfo::accommodations)
                .asInstanceOf(InstanceOfAssertFactories.list(AdvertiserInfo.class))
                .hasSizeGreaterThan(0);
    }

    @Test
    void givenJsonFile_whenLoad_shouldReturnParsedEntity() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        URL resource = getClass().getResource("/prices/advertiser_200.json");
        AdvertiserInfo advertiserInfo = objectMapper.readValue(resource, AdvertiserInfo.class);

        assertThat(advertiserInfo)
                .hasFieldOrPropertyWithValue("name", "advertiser")
                .hasFieldOrPropertyWithValue("id", 200)
                .extracting(AdvertiserInfo::accommodations)
                .asInstanceOf(InstanceOfAssertFactories.list(AdvertiserInfo.class))
                .hasSizeGreaterThan(0);
    }
}
