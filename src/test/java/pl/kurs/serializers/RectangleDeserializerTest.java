package pl.kurs.serializers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import pl.kurs.models.ObjectMapperHolder;
import pl.kurs.models.Rectangle;

import static org.junit.Assert.*;

public class RectangleDeserializerTest {

    @Test
    public void shouldProperlyDeserializeRectangleClassObject() throws JsonProcessingException {
        ObjectMapper mapper = ObjectMapperHolder.INSTANCE.getObjectMapper();
        Rectangle rectangle = new Rectangle(16,12);
        Rectangle deserializedRectangle = mapper.readValue("{\"length\":" + 16 + "," + "\"width\":" + 12 +"}", Rectangle.class);
        assertEquals(rectangle.getLength(), deserializedRectangle.getLength(), 0);
        assertEquals(rectangle.getWidth(), deserializedRectangle.getWidth(), 0);
        assertEquals(rectangle.getPerimeter(), deserializedRectangle.getPerimeter(), 0);
        assertEquals(rectangle.getArea(), deserializedRectangle.getArea(), 0);
    }
}