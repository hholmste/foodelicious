package no.foodelicious.core.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.*;

import java.io.IOException;

public class CourseTypeSerializer extends JsonDeserializer<CourseType>
{
    @Override
    public CourseType deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException
    {
        ObjectCodec oc = jsonParser.getCodec();
        JsonNode node = oc.readTree(jsonParser);

        System.out.printf("\nAAAAAAAAAAA\nThe node:\n%s\nAAAAAAAA\nthe node code\n%s\n", node.toString(), node.get("code"));

        //return CourseType.valueOf(node.get("code").asText());
        return  CourseType.MAIN_COURSE;
    }

}
