package pl.kurs.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.Objects;

public class Circle implements Shape {
    private static final double PI_NUMBER = Math.PI;

    private double radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public Circle() {
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double getArea() {
        return PI_NUMBER * Math.pow(radius, 2);
    }

    @Override
    public double getPerimeter() {
        return 2 * PI_NUMBER * radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }

}
