package no.foodelicious.core.model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class CourseTypeSerializer extends JsonSerializer<CourseType> {

    @Override
    public void serialize(CourseType courseType, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("name", courseType.getName());
        jsonGenerator.writeStringField("code", courseType.name());
        jsonGenerator.writeEndObject();
    }
}
