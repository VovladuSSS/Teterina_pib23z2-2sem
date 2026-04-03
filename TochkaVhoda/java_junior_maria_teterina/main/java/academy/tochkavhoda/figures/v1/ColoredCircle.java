package academy.tochkavhoda.figures.v1;

import java.util.Objects;

public class ColoredCircle extends Circle {
    private int color;

    // 1. Конструктор по центру, радиусу и цвету
    public ColoredCircle(Point center, int radius, int color) {
        super(center, radius);
        this.color = color;
    }

    // 2. Конструктор по координатам центра, радиусу и цвету
    public ColoredCircle(int xCenter, int yCenter, int radius, int color) {
        super(xCenter, yCenter, radius);
        this.color = color;
    }

    // 3. Конструктор с радиусом и цветом (центр в 0,0)
    public ColoredCircle(int radius, int color) {
        super(radius);
        this.color = color;
    }

    // 4. Конструктор с цветом (радиус 1)
    public ColoredCircle(int color) {
        super(1);
        this.color = color;
    }

    // 5. Конструктор по умолчанию
    public ColoredCircle() {
        super(1);
        this.color = 1;
    }

    // 10. getColor
    public int getColor() {
        return color;
    }

    // 11. setColor
    public void setColor(int color) {
        this.color = color;
    }

    // 14. getArea() - уже есть в Circle, не нужно переопределять
    // 15. getPerimeter() - уже есть в Circle
    // 16. isInside(int x, int y) - уже есть в Circle
    // 17. isInside(Point point) - уже есть в Circle

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ColoredCircle that = (ColoredCircle) o;
        return color == that.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color);
    }
}