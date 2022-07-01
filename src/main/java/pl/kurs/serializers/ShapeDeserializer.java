package pl.kurs.serializers;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import pl.kurs.models.Circle;
import pl.kurs.models.Rectangle;
import pl.kurs.models.Shape;
import pl.kurs.models.Square;
import java.io.IOException;
public class ShapeDeserializer extends StdDeserializer<Shape> {

    public ShapeDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Shape deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JacksonException {
        JsonNode jsonNode = jp.getCodec().readTree(jp);
        ObjectMapper objectMapper = (ObjectMapper)jp.getCodec();
        if (jsonNode.has("radius")){
            return objectMapper.treeToValue(jsonNode, Circle.class);
        } else if (jsonNode.has("side")){
            return objectMapper.treeToValue(jsonNode, Square.class);
        } else {
            return objectMapper.treeToValue(jsonNode, Rectangle.class);
        }
    }
}
