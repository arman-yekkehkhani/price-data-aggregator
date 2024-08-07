package com.example.price_data_aggregator.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.util.Locale;

public class ObjectMapperFactory {
    private static ObjectMapperFactory instance;
    private ObjectMapper jsonInstance;
    private ObjectMapper yamlInstance;

    public static ObjectMapperFactory getInstance() {
        if (instance == null) {
            instance = new ObjectMapperFactory();
        }
        return instance;
    }

    public ObjectMapper getOrCreate(String type) {
        type = type.toLowerCase(Locale.ROOT);
        return switch (type) {
            case "json" -> getJsonInstance();
            case "yaml" -> getYamlInstance();
            default -> throw new IllegalArgumentException("Unknown object mapper type: " + type);
        };
    }

    private ObjectMapper getYamlInstance() {
        if (yamlInstance == null) {
            yamlInstance = new ObjectMapper(new YAMLFactory());
        }
        return yamlInstance;
    }

    private ObjectMapper getJsonInstance() {
        if (jsonInstance == null) {
            jsonInstance = new ObjectMapper();
        }
        return jsonInstance;
    }
}
