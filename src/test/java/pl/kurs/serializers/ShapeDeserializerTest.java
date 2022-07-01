package pl.kurs.serializers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import pl.kurs.models.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ShapeDeserializerTest {

    @Test
    public void shouldReturnCircleClassNameWhenShapeDeserializerUsed() throws JsonProcessingException {
        //given
        ObjectMapper mapper = ObjectMapperHolder.INSTANCE.getObjectMapper();
        List<Shape> shapesList = new ArrayList<>(List.of(new Circle(2), new Rectangle(4,6), new Square(8)));
        //then
        String serializedShapesList = mapper.writeValueAsString(shapesList);
        List<Shape> importFromJsonList = mapper.readValue(serializedShapesList, new TypeReference<List<Shape>>() {});
        //when
        assertEquals(shapesList.get(0).getClass().getSimpleName(), importFromJsonList.get(0).getClass().getSimpleName());
        assertEquals(shapesList.get(1).getClass().getSimpleName(), importFromJsonList.get(1).getClass().getSimpleName());
        assertEquals(shapesList.get(2).getClass().getSimpleName(), importFromJsonList.get(2).getClass().getSimpleName());
    }
}