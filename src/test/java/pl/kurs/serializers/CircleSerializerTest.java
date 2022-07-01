package pl.kurs.serializers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import pl.kurs.models.Circle;
import pl.kurs.models.ObjectMapperHolder;

import static org.junit.Assert.*;

public class CircleSerializerTest {

    @Test
    public void shouldProperlySerializeCircleClassObject() throws JsonProcessingException {
        ObjectMapper mapper = ObjectMapperHolder.INSTANCE.getObjectMapper();
        Circle circle = new Circle(2);
        String serializedCircle = mapper.writeValueAsString(circle);
        assertEquals("{\"type\":\"circle\",\"radius\":2.0}", serializedCircle);
    }
}