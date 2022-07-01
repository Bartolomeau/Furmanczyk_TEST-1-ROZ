package pl.kurs.serializers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import pl.kurs.models.ObjectMapperHolder;
import pl.kurs.models.Rectangle;

import static org.junit.Assert.*;

public class RectangleSerializerTest {

    @Test
    public void shouldProperlySerializeRectangleClassObject() throws JsonProcessingException {
        ObjectMapper mapper = ObjectMapperHolder.INSTANCE.getObjectMapper();
        Rectangle rectangle = new Rectangle(21,37);
        String serializedRectangle = mapper.writeValueAsString(rectangle);
        assertEquals("{\"type\":\"rectangle\",\"length\":21.0,\"width\":37.0}", serializedRectangle);
    }
}