package academy.tochkavhoda.introduction;

import java.util.Arrays;

public class ZeroSteps3 {

    // 1. Сумма элементов массива
    public int sum(int[] array) {
        if (array.length == 0) return 0;
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        return sum;
    }

    // 2. Произведение элементов массива
    public int mul(int[] array) {
        if (array.length == 0) return 0;
        int product = 1;
        for (int num : array) {
            product *= num;
        }
        return product;
    }

    // 3. Минимальный элемент массива
    public int min(int[] array) {
        if (array.length == 0) return Integer.MAX_VALUE;
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    // 4. Максимальный элемент массива
    public int max(int[] array) {
        if (array.length == 0) return Integer.MIN_VALUE;
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    // 5. Среднее значение элементов массива
    public double average(int[] array) {
        if (array.length == 0) return 0;
        return (double) sum(array) / array.length;
    }

    // 6. Проверка упорядоченности по убыванию
    public boolean isSortedDescendant(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] <= array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    // 7. Возведение всех элементов в куб
    public void cube(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] * array[i] * array[i];
        }
    }

    // 8. Поиск элемента в массиве
    public boolean find(int[] array, int value) {
        for (int num : array) {
            if (num == value) {
                return true;
            }
        }
        return false;
    }

    // 9. Реверс массива
    public void reverse(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }

    // 10. Проверка на палиндром
    public boolean isPalindrome(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            if (array[i] != array[array.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    // 11. Замена элементов на квадраты до первого нуля
    public void replaceBySquare(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                break;
            }
            array[i] = array[i] * array[i];
        }
    }

    // 12. Произведение ненулевых элементов
    public int mulNonZero(int[] array) {
        if (array.length == 0) return 0;
        int product = 1;
        boolean hasNonZero = false;
        for (int num : array) {
            if (num != 0) {
                product *= num;
                hasNonZero = true;
            }
        }
        return hasNonZero ? product : 0;
    }

    // 13. Все ли элементы положительные
    public boolean allPositive(int[] array) {
        if (array.length == 0) return false;
        for (int num : array) {
            if (num <= 0) {
                return false;
            }
        }
        return true;
    }

    // 14. Все ли элементы равны
    public boolean allEqual(int[] array) {
        if (array.length == 0) return true;
        int first = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] != first) {
                return false;
            }
        }
        return true;
    }

    // 15. Первый элемент, больший своих соседей
    public int greaterThanNeighbours(int[] array) {
        for (int i = 1; i < array.length - 1; i++) {
            if (array[i] > array[i - 1] && array[i] > array[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    // 16. Есть ли элемент, равный полусумме соседей
    public boolean neighboursAverage(double[] array) {
        for (int i = 1; i < array.length - 1; i++) {
            double average = (array[i - 1] + array[i + 1]) / 2;
            if (Math.abs(array[i] - average) < 1e-10) {
                return true;
            }
        }
        return false;
    }

    // 17. Сумма между двумя нулями
    public int sumBetween2Zeros(int[] array) {
        int firstZero = -1;
        int secondZero = -1;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                if (firstZero == -1) {
                    firstZero = i;
                } else {
                    secondZero = i;
                    break;
                }
            }
        }

        if (firstZero == -1 || secondZero == -1) return 0;

        int sum = 0;
        for (int i = firstZero + 1; i < secondZero; i++) {
            sum += array[i];
        }
        return sum;
    }

    // 18. Количество совпадающих элементов на одинаковых позициях
    public int sameAtPosition(int[] array1, int[] array2) {
        int count = 0;
        int minLength = Math.min(array1.length, array2.length);
        for (int i = 0; i < minLength; i++) {
            if (array1[i] == array2[i]) {
                count++;
            }
        }
        return count;
    }

    // 19. Есть ли позиция с нулями в обоих массивах
    public boolean bothZeroAtPosition(int[] array1, int[] array2) {
        int minLength = Math.min(array1.length, array2.length);
        for (int i = 0; i < minLength; i++) {
            if (array1[i] == 0 && array2[i] == 0) {
                return true;
            }
        }
        return false;
    }

    // 20. Сумма с накоплением
    public void accumulatedSum(int[] array) {
        if (array.length == 0) return;
        int sum = array[0];
        for (int i = 1; i < array.length; i++) {
            sum += array[i];
            array[i] = sum;
        }
    }

    // 21. Слияние двух упорядоченных массивов
    public int[] mergeArrays(int[] array1, int[] array2) {
        int[] result = new int[array1.length + array2.length];
        int i = 0, j = 0, k = 0;

        while (i < array1.length && j < array2.length) {
            if (array1[i] <= array2[j]) {
                result[k++] = array1[i++];
            } else {
                result[k++] = array2[j++];
            }
        }

        while (i < array1.length) {
            result[k++] = array1[i++];
        }

        while (j < array2.length) {
            result[k++] = array2[j++];
        }

        return result;
    }

    // 22. Количество точек внутри круга
    public int insideCircle(int[] x, int[] y, int radius) {
        int count = 0;
        double radiusSquared = radius * radius;

        for (int i = 0; i < x.length; i++) {
            double distanceSquared = x[i] * x[i] + y[i] * y[i];
            if (distanceSquared <= radiusSquared) {
                count++;
            }
        }
        return count;
    }

    // 23. Скалярное произведение векторов
    public double scalarProduct(double[] array1, double[] array2) {
        double product = 0;
        for (int i = 0; i < array1.length; i++) {
            product += array1[i] * array2[i];
        }
        return product;
    }
}