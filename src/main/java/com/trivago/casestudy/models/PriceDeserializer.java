package com.trivago.casestudy.models;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class PriceDeserializer extends JsonDeserializer<Float> {

    @Override
    public Float deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String text = jsonParser.getText();
        if ("n/a".equals(text)) {
            return null;
        }
        return Float.parseFloat(text);
    }
}
