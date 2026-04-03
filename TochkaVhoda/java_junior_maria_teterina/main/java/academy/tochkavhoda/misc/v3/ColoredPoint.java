package academy.tochkavhoda.misc.v3;

import academy.tochkavhoda.figures.v2.Point;
import academy.tochkavhoda.iface.v2.Colored;
import academy.tochkavhoda.iface.v2.Movable;

import java.util.Objects;

public class ColoredPoint implements Movable, Colored {
    private Point point;
    private int color;

    public ColoredPoint(int x, int y, int color) {
        this.point = new Point(x, y);
        this.color = color;
    }

    public ColoredPoint(Point point, int color) {
        this.point = point;
        this.color = color;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    @Override
    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public int getColor() {
        return color;
    }

    @Override
    public void moveTo(int x, int y) {
        point.moveTo(x, y);
    }

    @Override
    public void moveRel(int dx, int dy) {
        point.moveRel(dx, dy);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColoredPoint that = (ColoredPoint) o;
        return color == that.color && Objects.equals(point, that.point);
    }

    @Override
    public int hashCode() {
        return Objects.hash(point, color);
    }

    @Override
    public String toString() {
        return "ColoredPoint{" + "point=" + point + ", color=" + color + '}';
    }
}