package academy.tochkavhoda.figures.v1;

import java.util.Objects;

public class ColoredRectangle extends Rectangle {
    private int color;

    // 1. Конструктор по точкам и цвету
    public ColoredRectangle(Point leftTop, Point rightBottom, int color) {
        super(leftTop, rightBottom);
        this.color = color;
    }

    // 2. Конструктор по координатам и цвету
    public ColoredRectangle(int xLeft, int yTop, int xRight, int yBottom, int color) {
        super(xLeft, yTop, xRight, yBottom);
        this.color = color;
    }

    // 3. Конструктор по длине, ширине и цвету (левый нижний угол в начале координат)
    public ColoredRectangle(int length, int width, int color) {
        super(length, width);
        this.color = color;
    }

    // 4. Конструктор с цветом (размер 1x1)
    public ColoredRectangle(int color) {
        super(1, 1);
        this.color = color;
    }

    // 5. Конструктор по умолчанию
    public ColoredRectangle() {
        super(1, 1);
        this.color = 1;
    }

    // 8. getColor
    public int getColor() {
        return color;
    }

    // 11. setColor
    public void setColor(int color) {
        this.color = color;
    }

    // 19. isInside(int x, int y) - уже есть в Rectangle, не нужно переопределять
    // 20. isInside(Point point) - уже есть в Rectangle
    // 21. isIntersects(ColoredRectangle rectangle)
    public boolean isIntersects(ColoredRectangle rectangle) {
        return super.isIntersects(rectangle);
    }

    // 22. isInside(ColoredRectangle rectangle)
    public boolean isInside(ColoredRectangle rectangle) {
        return super.isInside(rectangle);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ColoredRectangle that = (ColoredRectangle) o;
        return color == that.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color);
    }
}