package pl.kurs.models;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class SquareTest {

    @Mock
    private Square squareMock;

    @Before
    public void setUp() {
        squareMock = new Square(7);
    }

    @Test
    public void shouldReturn28OnGetSide() {
        Square s = Mockito.mock(Square.class);
        Mockito.when(s.getSide()).thenReturn(28d);
        assertEquals(s.getSide(), 28, 0);
    }

    @Test(expected = NoSuchFieldError.class)
    public void shouldThrowNoSuchElementExceptionOnGetRadius() {
        Square s = Mockito.mock(Square.class);

        Mockito.when(s.getSide()).thenThrow(new NoSuchFieldError());

        s.getSide();
    }

    @Test
    public void shouldReturn49AreaWhenSideIs7() {
        double area = squareMock.getArea();
        assertEquals(49, area, 0);
    }

    @Test
    public void shouldReturn28PerimeterWhenSideIs7() {
        double perimeter = squareMock.getPerimeter();
        assertEquals(28, perimeter, 0);
    }
}