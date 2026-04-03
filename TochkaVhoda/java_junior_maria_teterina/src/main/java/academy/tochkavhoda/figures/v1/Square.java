package academy.tochkavhoda.figures.v1;

import java.util.Objects;

public class Square {
    private Point topLeft;
    private int size;

    public Square(Point leftTop, int size) {
        this.topLeft = leftTop;
        this.size = size;
    }

    public Square(int xLeft, int yTop, int size) {
        this.topLeft = new Point(xLeft, yTop);
        this.size = size;
    }

    public Square(int size) {
        // Левый верхний угол в (0, -size), правый нижний в (size, 0)
        this.topLeft = new Point(0, -size);
        this.size = size;
    }

    public Square() {
        // Левый верхний угол в (0, -1), правый нижний в (1, 0)
        this.topLeft = new Point(0, -1);
        this.size = 1;
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public Point getBottomRight() {
        // Правый нижний угол: X = left + size, Y = top + size (но так как Y вверх, то top + size даст большее значение)
        return new Point(topLeft.getX() + size, topLeft.getY() + size);
    }

    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    public int getLength() {
        return size;
    }

    public void moveTo(int x, int y) {
        topLeft = new Point(x, y);
    }

    public void moveTo(Point point) {
        moveTo(point.getX(), point.getY());
    }

    public void moveRel(int dx, int dy) {
        topLeft = new Point(topLeft.getX() + dx, topLeft.getY() + dy);
    }

    public void resize(double ratio) {
        size = (int) (size * ratio);
    }

    public double getArea() {
        return size * size;
    }

    public double getPerimeter() {
        return 4 * size;
    }

    public boolean isInside(int x, int y) {
        // Для оси Y, направленной вверх: y между top и top + size
        return x >= topLeft.getX() && x <= topLeft.getX() + size &&
                y >= topLeft.getY() && y <= topLeft.getY() + size;
    }

    public boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
    }

    public boolean isIntersects(Square square) {
        return !(square.getTopLeft().getX() + square.size < topLeft.getX() ||
                square.getTopLeft().getX() > topLeft.getX() + size ||
                square.getTopLeft().getY() + square.size < topLeft.getY() ||
                square.getTopLeft().getY() > topLeft.getY() + size);
    }

    public boolean isInside(Square square) {
        return isInside(square.getTopLeft()) &&
                isInside(square.getTopLeft().getX() + square.size, square.getTopLeft().getY() + square.size);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return size == square.size && Objects.equals(topLeft, square.topLeft);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topLeft, size);
    }
}