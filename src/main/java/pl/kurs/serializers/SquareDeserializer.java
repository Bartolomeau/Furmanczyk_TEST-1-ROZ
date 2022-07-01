package pl.kurs.serializers;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import pl.kurs.models.Square;
import java.io.IOException;

public class SquareDeserializer extends StdDeserializer<Square> {

    public SquareDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Square deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JacksonException {
        JsonNode jn = jp.getCodec().readTree(jp);
        int side = jn.get("side").asInt();
        return new Square(side);
    }
}
