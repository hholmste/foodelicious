package no.foodelicious.core.model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class CourseTypeSerializer extends JsonSerializer<CourseType>
{
    @Override
    public void serialize(CourseType courseType, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException
    {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("name", uncase(courseType.name()));
        jsonGenerator.writeStringField("code", courseType.name());
        jsonGenerator.writeEndObject();
    }

    private String uncase(String allUpper) {
        String allLower = allUpper.replace('_', ' ').toLowerCase();
        return allLower.substring(0, 1).toUpperCase() + allLower.substring(1);
    }
}
