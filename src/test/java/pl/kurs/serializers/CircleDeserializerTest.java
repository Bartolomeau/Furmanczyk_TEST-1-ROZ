package pl.kurs.serializers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import pl.kurs.models.Circle;
import pl.kurs.models.ObjectMapperHolder;

import static org.junit.Assert.*;

public class CircleDeserializerTest {

    @Test
    public void shouldProperlyDeserializeCircleClassObject() throws JsonProcessingException {
        ObjectMapper mapper = ObjectMapperHolder.INSTANCE.getObjectMapper();
        Circle circle = new Circle(4);
        Circle deserializedCircle = mapper.readValue("{\"radius\":" + 4.0 +"}", Circle.class);
        assertEquals(circle.getRadius(), deserializedCircle.getRadius(), 0);
        assertEquals(circle.getArea(), deserializedCircle.getArea(), 0);
        assertEquals(circle.getPerimeter(), deserializedCircle.getPerimeter(), 0);
    }
}