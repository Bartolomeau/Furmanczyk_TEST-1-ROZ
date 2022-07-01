package pl.kurs.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.kurs.models.*;

import java.io.File;
import java.io.IOException;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class GeometricFigureService {
    ObjectMapper mapper = ObjectMapperHolder.INSTANCE.getObjectMapper();

    public Shape findFigureWithTheLargestArea(List<Shape> shapeList) {
            return shapeList
                    .stream()
                    .max(Comparator.comparingDouble(Shape::getArea))
                    .orElseThrow(NoSuchElementException::new);
    }

    public Shape findFigureWithTheLargestPerimeter(List<Shape> shapeList, Class shapeType) {
        return shapeList
                .stream()
                .filter(e -> e.getClass().getSimpleName().equals(shapeType.getSimpleName()))
                .max(Comparator.comparingDouble(Shape::getPerimeter))
                .orElseThrow(NoSuchElementException::new);
    }

    public void exportToJson(List<Shape> shapeList, String src) throws IOException {
        if (shapeList.isEmpty() || src.isEmpty()) {
            throw new IllegalStateException("Argument is empty");
        }
            mapper.writeValue(new File(src), shapeList);
    }

    // TODO: POPRAW TO PAJACU BO NIEW DZIAŁA!
    public List<Shape> importFromJson(String src) throws IOException {
        List<Shape> shapeList = mapper.readValue(new File(src), new TypeReference<List<Shape>>() {});
        return shapeList;
    }

}

