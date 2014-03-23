package no.foodelicious.core.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.*;

import java.io.IOException;

public class CourseTypeDeserializer extends JsonDeserializer<CourseType> {

    @Override
    public CourseType deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        ObjectCodec oc = jsonParser.getCodec();
        JsonNode node = oc.readTree(jsonParser);

        if (node.get("code") != null) {
            return CourseType.valueOf(node.get("code").asText());
        }
        return null;
    }

}
