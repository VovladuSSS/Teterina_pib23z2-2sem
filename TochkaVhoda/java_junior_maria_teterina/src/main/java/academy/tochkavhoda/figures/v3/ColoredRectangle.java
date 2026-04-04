package academy.tochkavhoda.figures.v3;

import academy.tochkavhoda.colors.v3.Color;
import academy.tochkavhoda.colors.v3.ColorException;
import academy.tochkavhoda.colors.v3.ColorErrorCode;
import academy.tochkavhoda.iface.v3.Colored;

import java.util.Objects;

public class ColoredRectangle extends Rectangle implements Colored {
    private Color color;

    // Конструкторы с Color
    public ColoredRectangle(Point leftTop, Point rightBottom, Color color) throws ColorException {
        super(leftTop, rightBottom);
        if (color == null) {
            throw new ColorException(ColorErrorCode.NULL_COLOR);
        }
        this.color = color;
    }

    public ColoredRectangle(int xLeft, int yTop, int xRight, int yBottom, Color color) throws ColorException {
        super(xLeft, yTop, xRight, yBottom);
        if (color == null) {
            throw new ColorException(ColorErrorCode.NULL_COLOR);
        }
        this.color = color;
    }

    public ColoredRectangle(int length, int width, Color color) throws ColorException {
        super(length, width);
        if (color == null) {
            throw new ColorException(ColorErrorCode.NULL_COLOR);
        }
        this.color = color;
    }

    public ColoredRectangle(Color color) throws ColorException {
        super(1, 1);
        if (color == null) {
            throw new ColorException(ColorErrorCode.NULL_COLOR);
        }
        this.color = color;
    }

    public ColoredRectangle() {
        super(1, 1);
        this.color = Color.RED;
    }

    // Конструкторы с String
    public ColoredRectangle(Point leftTop, Point rightBottom, String colorString) throws ColorException {
        this(leftTop, rightBottom, Color.colorFromString(colorString));
    }

    public ColoredRectangle(int xLeft, int yTop, int xRight, int yBottom, String colorString) throws ColorException {
        this(xLeft, yTop, xRight, yBottom, Color.colorFromString(colorString));
    }

    public ColoredRectangle(int length, int width, String colorString) throws ColorException {
        this(length, width, Color.colorFromString(colorString));
    }

    public ColoredRectangle(String colorString) throws ColorException {
        this(Color.colorFromString(colorString));
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) throws ColorException {
        if (color == null) {
            throw new ColorException(ColorErrorCode.NULL_COLOR);
        }
        this.color = color;
    }

    @Override
    public void setColor(String colorString) throws ColorException {
        setColor(Color.colorFromString(colorString));
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