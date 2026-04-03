package academy.tochkavhoda.iface.v2;

public interface Stretchable extends Resizable {
    void stretch(double xRatio, double yRatio);

    // default реализация resize через stretch с одинаковым коэффициентом
    @Override
    default void resize(double ratio) {
        stretch(ratio, ratio);
    }
}