package pl.kurs.models;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class CircleTest {

     @Mock private Circle circleMock;

    @Before
    public void setUp(){
        circleMock = new Circle(3);
    }

    @Test
    public void shouldReturn9OnGetRadius(){
        Circle c = Mockito.mock(Circle.class);
        Mockito.when(c.getRadius()).thenReturn(9d);
        assertEquals(c.getRadius(), 9, 0);
    }

    @Test(expected = NoSuchFieldError.class)
    public void shouldThrowNoSuchElementExceptionOnGetRadius() {
        Circle c = Mockito.mock(Circle.class);
        Mockito.when(c.getRadius()).thenThrow(new NoSuchFieldError());
        c.getRadius();
    }

    @Test
    public void shouldReturn28AreaWhenRadiusIs3() {
        double area = circleMock.getArea();
        assertEquals(28, area, 0.28);
    }

    @Test
    public void shouldReturn18PerimeterWhenRadiusIs3() {
        double perimeter = circleMock.getPerimeter();
        assertEquals(18.5, perimeter, 0.35);
    }
}