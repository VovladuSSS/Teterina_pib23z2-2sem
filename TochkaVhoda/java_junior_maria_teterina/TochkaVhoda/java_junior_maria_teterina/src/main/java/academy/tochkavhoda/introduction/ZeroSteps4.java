package academy.tochkavhoda.introduction;

public class ZeroSteps4 {

    // 1. Минимальный элемент в матрице
    public int min(int[][] matrix) {
        if (matrix.length == 0) return Integer.MAX_VALUE;

        int min = Integer.MAX_VALUE;
        for (int[] row : matrix) {
            if (row.length > 0) {
                int rowMin = new ZeroSteps3().min(row);
                if (rowMin < min) {
                    min = rowMin;
                }
            }
        }
        return min;
    }

    // 2. Максимальный элемент в матрице
    public int max(int[][] matrix) {
        if (matrix.length == 0) return Integer.MIN_VALUE;

        int max = Integer.MIN_VALUE;
        for (int[] row : matrix) {
            if (row.length > 0) {
                int rowMax = new ZeroSteps3().max(row);
                if (rowMax > max) {
                    max = rowMax;
                }
            }
        }
        return max;
    }

    // 3. Поиск элемента в матрице
    public boolean find(int[][] matrix, int value) {
        for (int[] row : matrix) {
            if (new ZeroSteps3().find(row, value)) {
                return true;
            }
        }
        return false;
    }

    // 4. Проверка, что все строки упорядочены по убыванию
    public boolean isSortedDescendant(int[][] matrix) {
        for (int[] row : matrix) {
            if (!new ZeroSteps3().isSortedDescendant(row)) {
                return false;
            }
        }
        return true;
    }

    // 5. Количество строк без нулевых элементов
    public int hasNoZeroRows(int[][] matrix) {
        int count = 0;
        for (int[] row : matrix) {
            boolean hasZero = false;
            for (int element : row) {
                if (element == 0) {
                    hasZero = true;
                    break;
                }
            }
            if (!hasZero) {
                count++;
            }
        }
        return count;
    }

    // 6. Проверка наличия полностью нулевой строки
    public boolean hasFullZeroRow(int[][] matrix) {
        for (int[] row : matrix) {
            if (row.length == 0) continue;
            boolean allZero = true;
            for (int element : row) {
                if (element != 0) {
                    allZero = false;
                    break;
                }
            }
            if (allZero) {
                return true;
            }
        }
        return false;
    }

    // 7. Проверка симметричности матрицы
    public boolean isSymmetric(int[][] matrix) {
        if (matrix.length == 0) return true;
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            if (matrix[i].length != n) return false; // Проверяем, что матрица квадратная
            for (int j = 0; j < i; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    // 8. Максимальный элемент на главной диагонали
    public int mainDiagonalMax(int[][] matrix) {
        if (matrix.length == 0) return Integer.MIN_VALUE;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            if (i < matrix[i].length) { // Проверяем, что элемент существует
                if (matrix[i][i] > max) {
                    max = matrix[i][i];
                }
            }
        }
        return max;
    }

    // 9. Сумма положительных элементов на главной диагонали
    public int mainDiagonalPositivesSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (i < matrix[i].length && matrix[i][i] > 0) {
                sum += matrix[i][i];
            }
        }
        return sum;
    }

    // 10. Максимальный элемент на побочной диагонали
    public int secondaryDiagonalMax(int[][] matrix) {
        if (matrix.length == 0) return Integer.MIN_VALUE;

        int max = Integer.MIN_VALUE;
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            int j = n - 1 - i;
            if (j < matrix[i].length && matrix[i][j] > max) {
                max = matrix[i][j];
            }
        }
        return max;
    }

    // 11. Сумма положительных элементов на побочной диагонали
    public int secondaryDiagonalPositivesSum(int[][] matrix) {
        int sum = 0;
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            int j = n - 1 - i;
            if (j < matrix[i].length && matrix[i][j] > 0) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    // 12. Сумма двух матриц
    public int[][] matrixSum(int[][] matrix1, int[][] matrix2) {
        if (matrix1.length != matrix2.length) return new int[0][0];

        int[][] result = new int[matrix1.length][];
        for (int i = 0; i < matrix1.length; i++) {
            if (matrix1[i].length != matrix2[i].length) {
                return new int[0][0];
            }
            result[i] = new int[matrix1[i].length];
            for (int j = 0; j < matrix1[i].length; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    // 13. Транспонирование квадратной матрицы
    public void transpose(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    // 14. Обмен четных и нечетных строк
    public void interchange(int[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i += 2) {
            int[] temp = matrix[i];
            matrix[i] = matrix[i + 1];
            matrix[i + 1] = temp;
        }
    }

    // 15. Преобразование в одномерный массив по строкам
    public int[] toLinearByRow(int[][] matrix) {
        // Сначала считаем общее количество элементов
        int totalElements = 0;
        for (int[] row : matrix) {
            totalElements += row.length;
        }

        int[] result = new int[totalElements];
        int index = 0;
        for (int[] row : matrix) {
            for (int element : row) {
                result[index++] = element;
            }
        }
        return result;
    }

    // 16. Преобразование в одномерный массив по столбцам (для квадратной матрицы)
    public int[] toLinearByColumn(int[][] matrix) {
        if (matrix.length == 0) return new int[0];

        int n = matrix.length;
        int[] result = new int[n * n];
        int index = 0;

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                result[index++] = matrix[i][j];
            }
        }
        return result;
    }

    // 17. Преобразование верхнего треугольника в одномерный массив
    public int[] toLinearByRowUpperTriangle(int[][] matrix) {
        if (matrix.length == 0) return new int[0];

        int n = matrix.length;
        int totalElements = n * (n + 1) / 2; // Формула для суммы арифметической прогрессии
        int[] result = new int[totalElements];
        int index = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                result[index++] = matrix[i][j];
            }
        }
        return result;
    }

    // 18. Сумма элементов до барьера в каждой строке
    public int sumUntilNotFoundInRow(int[][] matrix, int barrier) {
        int sum = 0;
        for (int[] row : matrix) {
            for (int element : row) {
                if (element == barrier) {
                    break;
                }
                sum += element;
            }
        }
        return sum;
    }

    // 19. Сумма элементов до барьера во всей матрице
    public int sumUntilNotFound(int[][] matrix, int barrier) {
        int sum = 0;
        for (int[] row : matrix) {
            for (int element : row) {
                if (element == barrier) {
                    return sum;
                }
                sum += element;
            }
        }
        return sum;
    }
}