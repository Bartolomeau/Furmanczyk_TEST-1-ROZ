package pl.kurs.serializers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import pl.kurs.models.ObjectMapperHolder;
import pl.kurs.models.Square;

import static org.junit.Assert.*;

public class SquareSerializerTest {

    @Test
    public void shouldProperlySerializeSquareClassObject() throws JsonProcessingException {
        ObjectMapper mapper = ObjectMapperHolder.INSTANCE.getObjectMapper();
        Square square = new Square(47);
        String serializedSquare = mapper.writeValueAsString(square);
        assertEquals("{\"type\":\"square\",\"side\":47.0}", serializedSquare);
    }
}