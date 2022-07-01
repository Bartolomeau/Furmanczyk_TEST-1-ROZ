package pl.kurs.serializers;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import pl.kurs.models.Circle;

import java.io.IOException;

public class CircleDeserializer extends StdDeserializer<Circle> {

    public CircleDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Circle deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JacksonException {
        JsonNode jn = jp.getCodec().readTree(jp);
        int radius = jn.get("radius").asInt();
        return new Circle(radius);
    }
}
