package pl.kurs.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import pl.kurs.models.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class GeometricFigureServiceTest {

    @Mock
    private GeometricFigureService geometricFigureService;
    @Mock
    private List<Shape> shapesList;

    @Before
    public void setUp() {
        geometricFigureService = new GeometricFigureService();
        shapesList = new ArrayList<>(List.of(new Circle(8), new Rectangle(4,7), new Square(5)));
    }

    @Test
    public void shouldReturnCircle() {
        //when
        Shape shape = geometricFigureService.findFigureWithTheLargestArea(shapesList);
        //then
        assertEquals(shapesList.get(0), shape);
    }

    @Test
    public void shouldReturnRectangleNumber2() {
        //given
        Rectangle rectangle = new Rectangle(8, 16);
        Rectangle rectangle2 = new Rectangle(16, 12);
        shapesList.add(rectangle);
        shapesList.add(rectangle2);
        //when
        Shape shape = geometricFigureService.findFigureWithTheLargestPerimeter(shapesList, Rectangle.class);
        //then
        assertEquals(rectangle2, shape);
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldThrowNoSuchElementExceptionWhenEmptyListFindFigureWithTheLargestAreaMethod() {
        //given
        List<Shape> emptyShapeList = new ArrayList<>();
        //when
        Shape shape = geometricFigureService.findFigureWithTheLargestArea(emptyShapeList);
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldThrowNoSuchElementExceptionWhenEmptyListFindFigureWithTheLargestPerimeterMethod() {
        //given
        List<Shape> emptyShapeList = new ArrayList<>();
        //when
        Shape shape = geometricFigureService.findFigureWithTheLargestPerimeter(emptyShapeList, Rectangle.class);
    }

    @Test
    public void testExportingToJsonMethod() throws IOException {
        //given
        String src = "src/main/resources/shapes.json";
        //then
        geometricFigureService.exportToJson(shapesList, src);
        //when

    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowIllegalArgumentExceptionWhenDestinationIsEmpty() throws IOException {
        //given
        String destination = "";
        List<Shape> emptyShapeList = new ArrayList<>();
        //when
        geometricFigureService.exportToJson(emptyShapeList,destination);
    }

    @Test
    public void testImportFromJsonMethod() throws IOException {
        //given
        String src = "src/main/resources/shapes.json";
        //then
        List<Shape> importFromJsonList = geometricFigureService.importFromJson(src);
        //when
        assertEquals(shapesList, importFromJsonList);
    }

}