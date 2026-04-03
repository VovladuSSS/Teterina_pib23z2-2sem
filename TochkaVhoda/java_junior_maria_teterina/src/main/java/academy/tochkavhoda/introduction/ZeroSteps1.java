package academy.tochkavhoda.introduction;

public class ZeroSteps1 {

    // 1. Сумма двух чисел
    public int sum(int x, int y) {
        return x + y;
    }

    // 2. Произведение двух чисел
    public int mul(int x, int y) {
        return x * y;
    }

    // 3. Частное от деления
    public int div(int x, int y) {
        return x / y;
    }

    // 4. Остаток от деления
    public int mod(int x, int y) {
        return x % y;
    }

    // 5. Проверка равенства
    public boolean isEqual(int x, int y) {
        return x == y;
    }

    // 6. Проверка, что x больше y
    public boolean isGreater(int x, int y) {
        return x > y;
    }

    // 7. Площадь прямоугольного треугольника по катетам
    public double calculateTriangleSquare(int side1, int side2) {
        return (side1 * side2) / 2.0;
    }

    // 8. Периметр прямоугольного треугольника по катетам
    public double calculateTrianglePerimeter(int side1, int side2) {
        double hypotenuse = Math.sqrt(side1 * side1 + side2 * side2);
        return side1 + side2 + hypotenuse;
    }

    // 9. Реверс трехзначного числа
    public int reverseNumber(int number) {
        int hundreds = number / 100;
        int tens = (number / 10) % 10;
        int units = number % 10;
        return units * 100 + tens * 10 + hundreds;
    }

    // 10. Возведение в степень 15 за 5 умножений
    public long calculate15Degree(int number) {
        long result = number;
        result = result * result; // 2
        result = result * result; // 4
        result = result * result; // 8
        result = result * result; // 16
        return result / number; // 15
    }

    // 11. Проверка точки внутри прямоугольника
    public boolean isInsideRect(int xLeft, int yTop, int xRight, int yBottom, int x, int y) {
        return x >= xLeft && x <= xRight && y >= yTop && y <= yBottom;
    }

    // 12. Квадратный корень абсолютного значения
    public double sqrtAbs(int number) {
        return Math.sqrt(Math.abs(number));
    }

    // 13. Проверка существования треугольника
    public boolean isTriangleExist(int side1, int side2, int side3) {
        return side1 + side2 > side3 &&
                side1 + side3 > side2 &&
                side2 + side3 > side1;
    }

    // 14. Произведение цифр четырехзначного числа
    public int getDigitsProduction(int number) {
        int digit1 = number / 1000;
        int digit2 = (number / 100) % 10;
        int digit3 = (number / 10) % 10;
        int digit4 = number % 10;
        return digit1 * digit2 * digit3 * digit4;
    }

    // 15. Проверка, помещается ли круг в квадрат
    public boolean isCircleInsideSquare(int radius, int side) {
        return 2 * radius < side;
    }

    // 16. Получение символа по коду
    public char getCharByCode(short code) {
        return (char) code;
    }

    // 17. Получение кода символа
    public short getCodeByChar(char character) {
        return (short) character;
    }

    // 18. Получение символа со смещением
    public char getCharByCodeAndOffset(char ch, short offset) {
        return (char) (ch + offset);
    }

    // 19. Проверка, что код ch1 >= коду ch2
    public boolean isGreaterOrEqual(char ch1, char ch2) {
        return ch1 >= ch2;
    }

    // 20. Средний символ
    public char getAverageChar(char ch1, char ch2) {
        return (char) ((ch1 + ch2) / 2);
    }
}