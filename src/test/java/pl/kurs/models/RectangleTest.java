package pl.kurs.models;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class RectangleTest {

    private Rectangle rectangle = Mockito.mock(Rectangle.class);

    @Before
    public void setUp(){
        rectangle = new Rectangle(8,16);
    }

    @Test
    public void shouldReturn128AreaWhenLengthIs8AndWidth16() {
        double area = rectangle.getArea();
        assertEquals(128, area, 0);
    }

    @Test
    public void shouldReturn48PerimeterWhenLengthIs8AndWidth16() {
        double perimeter = rectangle.getPerimeter();
        assertEquals(48, perimeter, 0);
    }

    @Test
    public void shouldReturn15OnGetLength() {
        Rectangle r = Mockito.mock(Rectangle.class);

        Mockito.when(r.getLength()).thenReturn(15d);
        assertEquals(r.getLength(), 15, 0);
    }

    @Test(expected = NoSuchFieldError.class)
    public void shouldThrowNoSuchElementExceptionOnGetRadius() {
        Rectangle r = Mockito.mock(Rectangle.class);

        Mockito.when(r.getWidth()).thenThrow(new NoSuchFieldError());

        r.getWidth();
    }
}