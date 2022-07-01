package pl.kurs.serializers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import pl.kurs.models.ObjectMapperHolder;
import pl.kurs.models.Square;

import static org.junit.Assert.*;

public class SquareDeserializerTest {

    @Test
    public void shouldProperlyDeserializeSquareClassObject() throws JsonProcessingException {
        ObjectMapper mapper = ObjectMapperHolder.INSTANCE.getObjectMapper();
        Square square = new Square(32);
        Square deserializedSquare = mapper.readValue("{\"side\":" + 32.0 +"}", Square.class);
        assertEquals(square.getSide(), deserializedSquare.getSide(), 0);
        assertEquals(square.getArea(), deserializedSquare.getArea(), 0);
        assertEquals(square.getPerimeter(), deserializedSquare.getPerimeter(), 0);
    }
}