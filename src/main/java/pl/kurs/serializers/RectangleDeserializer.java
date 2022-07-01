package pl.kurs.serializers;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import pl.kurs.models.Rectangle;
import java.io.IOException;

public class RectangleDeserializer extends StdDeserializer<Rectangle> {

    public RectangleDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Rectangle deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JacksonException {
        JsonNode jn = jp.getCodec().readTree(jp);
        int length = jn.get("length").asInt();
        int width = jn.get("width").asInt();
        return new Rectangle(length,width);
    }
}
