package academy.tochkavhoda.figures.v3;

import java.util.HashMap;
import java.util.Map;

public class FigureBag {
    private Map<Figure, Integer> figureCounts;

    public FigureBag() {
        this.figureCounts = new HashMap<>();
    }

    public void addFigure(Figure figure) {
        figureCounts.put(figure, figureCounts.getOrDefault(figure, 0) + 1);
    }

    public void addFigure(Figure figure, int copies) {
        if (copies > 0) {
            figureCounts.put(figure, figureCounts.getOrDefault(figure, 0) + copies);
        }
    }

    public boolean removeFigure(Figure figure) {
        if (figureCounts.containsKey(figure)) {
            figureCounts.remove(figure);
            return true;
        }
        return false;
    }

    public boolean removeFigure(Figure figure, int copies) {
        if (copies <= 0) return false;

        Integer currentCount = figureCounts.get(figure);
        if (currentCount == null) return false;

        int newCount = currentCount - copies;
        if (newCount <= 0) {
            figureCounts.remove(figure);
        } else {
            figureCounts.put(figure, newCount);
        }
        return true;
    }

    public int getFigureCopies(Figure figure) {
        return figureCounts.getOrDefault(figure, 0);
    }
}