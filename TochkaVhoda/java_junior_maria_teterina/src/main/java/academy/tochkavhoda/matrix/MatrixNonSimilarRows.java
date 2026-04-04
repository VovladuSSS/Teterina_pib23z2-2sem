package academy.tochkavhoda.matrix;

import java.util.*;

public class MatrixNonSimilarRows {
    private int[][] matrix;

    public MatrixNonSimilarRows(int[][] matrix) {
        this.matrix = matrix;
    }

    public Set<int[]> getNonSimilarRows() {
        List<Set<Integer>> rowSets = new ArrayList<>();
        List<Integer> selectedIndices = new ArrayList<>();

        // Преобразуем каждую строку в множество уникальных чисел
        for (int[] row : matrix) {
            Set<Integer> rowSet = new HashSet<>();
            for (int num : row) {
                rowSet.add(num);
            }
            rowSets.add(rowSet);
        }

        // Выбираем строки, которые не похожи друг на друга
        for (int i = 0; i < rowSets.size(); i++) {
            boolean isSimilar = false;

            for (int selectedIndex : selectedIndices) {
                if (rowSets.get(i).equals(rowSets.get(selectedIndex))) {
                    isSimilar = true;
                    break;
                }
            }

            if (!isSimilar) {
                selectedIndices.add(i);
            }
        }

        // Формируем результат
        Set<int[]> result = new LinkedHashSet<>();
        for (int index : selectedIndices) {
            result.add(matrix[index]);
        }

        return result;
    }
}