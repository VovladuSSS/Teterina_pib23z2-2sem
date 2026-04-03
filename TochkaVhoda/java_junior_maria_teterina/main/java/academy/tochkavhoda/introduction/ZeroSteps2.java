package academy.tochkavhoda.introduction;

import java.util.Random;

public class ZeroSteps2 {

    // 1. Сумма квадратов целых чисел от 1 до count
    public int sumSquares(int count) {
        int sum = 0;
        for (int i = 1; i <= count; i++) {
            sum += i * i;
        }
        return sum;
    }

    // 2. Сумма нечетных целых чисел от 1 до count
    public int sumOdds(int count) {
        int sum = 0;
        for (int i = 1; i <= count; i += 2) {
            sum += i;
        }
        return sum;
    }

    // 3. Сумма обратных величин целых чисел от 1 до count
    public double sumInverses(int count) {
        double sum = 0.0;
        for (int i = 1; i <= count; i++) {
            sum += 1.0 / i;
        }
        return sum;
    }

    // 4. Факториал от count
    public long factorial(int count) {
        if (count == 0) return 1;
        long result = 1;
        for (int i = 1; i <= count; i++) {
            result *= i;
        }
        return result;
    }

    // 5. Произведение цифр целого числа value
    public int prodDigits(int value) {
        if (value == 0) return 0;
        int product = 1;
        int num = Math.abs(value);
        while (num > 0) {
            product *= num % 10;
            num /= 10;
        }
        return product;
    }

    // 6. Число Фибоначчи номер number (без рекурсии)
    public int fibonacci(int number) {
        if (number == 0) return 0;
        if (number == 1) return 1;

        int prev1 = 0;
        int prev2 = 1;
        int current = 0;

        for (int i = 2; i <= number; i++) {
            current = prev1 + prev2;
            prev1 = prev2;
            prev2 = current;
        }
        return current;
    }

    // 7. Сумма всех степеней 2 от 2^0 до 2^max
    public long sum2Powers(int max) {
        long sum = 0;
        long power = 1;
        for (int i = 0; i <= max; i++) {
            sum += power;
            power *= 2;
        }
        return sum;
    }

    // 8. Сумма квадратов с барьером - ВАРИАНТ 2
    public int sumSquaresWithBarrier(int count, int barrier) {
        int sum = 0;
        for (int i = 1; i <= count; i++) {
            sum += i * i;
            if (sum > barrier) {
                break;
            }
        }
        return sum;
    }

    // 9. Сумма всех произведений i*j
    public int sumPairProd(int count1, int count2) {
        int sum = 0;
        for (int i = 1; i <= count1; i++) {
            for (int j = 1; j <= count2; j++) {
                sum += i * j;
            }
        }
        return sum;
    }

    // 10. Сумма произведений i*j, которые меньше barrier
    public int sumPairProdWithBarrier(int count1, int count2, int barrier) {
        int sum = 0;
        for (int i = 1; i <= count1; i++) {
            for (int j = 1; j <= count2; j++) {
                int product = i * j;
                if (product < barrier) {
                    sum += product;
                }
            }
        }
        return sum;
    }

    // 11. Сумма всех величин 1/(i*j)
    public double sumInversePairProd(int count1, int count2) {
        double sum = 0.0;
        for (int i = 1; i <= count1; i++) {
            for (int j = 1; j <= count2; j++) {
                sum += 1.0 / (i * j);
            }
        }
        return sum;
    }

    // 12. Сумма всех произведений i*j*k
    public int sumTripleProd(int count1, int count2, int count3) {
        int sum = 0;
        for (int i = 1; i <= count1; i++) {
            for (int j = 1; j <= count2; j++) {
                for (int k = 1; k <= count3; k++) {
                    sum += i * j * k;
                }
            }
        }
        return sum;
    }

    // 13. Вычисление числа e
    public double calculateE() {
        double e = 1.0;
        double term = 1.0;
        int n = 1;

        while (term >= 1E-6) {
            term /= n;
            e += term;
            n++;
        }
        return e;
    }

    // 14. Вычисление числа π
    public double calculatePi() {
        double pi = 0.0;
        double term;
        int sign = 1;
        int denominator = 1;

        do {
            term = 1.0 / denominator;
            pi += sign * term;
            sign = -sign;
            denominator += 2;
        } while (term >= 1E-8);

        return 4 * pi;
    }

    // 15. Вычисление площади круга методом Монте-Карло
    public double calculateCircleSquare(double length, int count) {
        if (count <= 0) return 0;

        Random random = new Random();
        int k = 0; // количество точек, попавших в круг
        double radius = length / 2;
        double center = length / 2;

        for (int i = 0; i < count; i++) {
            double x = random.nextDouble() * length;
            double y = random.nextDouble() * length;

            // Проверяем, находится ли точка внутри круга
            double distanceSquared = Math.pow(x - center, 2) + Math.pow(y - center, 2);
            if (distanceSquared <= radius * radius) {
                k++;
            }
        }

        return length * length * k / count;
    }
}