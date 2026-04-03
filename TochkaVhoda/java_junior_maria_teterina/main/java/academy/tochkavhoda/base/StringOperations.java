package academy.tochkavhoda.base;

import java.util.StringJoiner;

public class StringOperations {
    // 1 Возвращает суммарную длину строк, заданных массивом strings.
    public static int getSummaryLength(String[] strings) {
        if (strings == null) return 0;
        int sum = 0;
        for (String s : strings) {
            if (s != null) sum += s.length();
        }
        return sum;
    }
    // 2 Возвращает двухсимвольную строку, состоящую из начального и конечного символов заданной строки.
    public static String getFirstAndLastLetterString(String string) {
        if (string == null || string.isEmpty()) return "";
        char first = string.charAt(0);
        char last = string.charAt(string.length() - 1);
        return "" + first + last;
    }
    // 3 	Возвращает true, если обе строки в позиции index содержат один и тот же символ, иначе false.
    public static boolean isSameCharAtPosition(String string1, String string2, int index) {
        if (string1 == null || string2 == null) return false;
        if (index < 0 || index >= string1.length() || index >= string2.length()) return false;
        return string1.charAt(index) == string2.charAt(index);
    }
    // 4 Возвращает true, если в обеих строках первый встреченный символ character находится в одной и той же позиции. Просмотр строк ведется от начала.
    public static boolean isSameFirstCharPosition(String string1, String string2, char character) {
        return string1.indexOf(character) == string2.indexOf(character);
    }
    // 5 Возвращает true, если в обеих строках первый встреченный символ character находится в одной и той же позиции. Просмотр строк ведется от конца.
    public static boolean isSameLastCharPosition(String string1, String string2, char character) {
        return string1.lastIndexOf(character) == string2.lastIndexOf(character);
    }
    // 6 Возвращает true, если в обеих строках первая встреченная подстрока str начинается в одной и той же позиции. Просмотр строк ведется от начала.
    public static boolean isSameFirstStringPosition(String string1, String string2, String str) {
        return string1.indexOf(str) == string2.indexOf(str);
    }
    // 7 Возвращает true, если в обеих строках первая встреченная подстрока str начинается в одной и той же позиции. Просмотр строк ведется от конца.
    public static boolean isSameLastStringPosition(String string1, String string2, String str) {
        return string1.lastIndexOf(str) == string2.lastIndexOf(str);
    }
    // 8 Возвращает true, если строки равны.
    public static boolean isEqual(String string1, String string2) {
        return string1 == null ? string2 == null : string1.equals(string2);
    }
    // 9 Возвращает true, если строки равны без учета регистра (например, строки “abc” и “aBC” в этом смысле равны).
    public static boolean isEqualIgnoreCase(String string1, String string2) {
        return string1 == null ? string2 == null : string1.equalsIgnoreCase(string2);
    }
    // 10 Возвращает true, если строка string1 меньше строки string2.
    public static boolean isLess(String string1, String string2) {
        return string1 == null ? string2 != null : string1.compareTo(string2) < 0;
    }
    // 11 Возвращает true, если строка string1 меньше строки string2 без учета регистра (например, строка “abc” меньше строки “ABCd” в этом смысле).
    public static boolean isLessIgnoreCase(String string1, String string2) {
        return string1 == null ? string2 != null : string1.compareToIgnoreCase(string2) < 0;
    }
    // 12 Возвращает строку, полученную путем сцепления двух строк.
    public static String concat(String string1, String string2) {
        return string1 + string2;
    }
    // 13 Возвращает true, если обе строки string1 и string2 начинаются с одной и той же подстроки prefix.
    public static boolean isSamePrefix(String string1, String string2, String prefix) {
        return string1.startsWith(prefix) && string2.startsWith(prefix);
    }
    // 14 Возвращает true, если обе строки string1 и string2 заканчиваются одной и той же подстрокой suffix.
    public static boolean isSameSuffix(String string1, String string2, String suffix) {
        return string1.endsWith(suffix) && string2.endsWith(suffix);
    }
    // 15 Возвращает самое длинное общее “начало” двух строк. Если у строк нет общего начала, возвращает пустую строку.
    public static String getCommonPrefix(String string1, String string2) {
        if (string1 == null || string2 == null) return "";
        int minLen = Math.min(string1.length(), string2.length());
        int i = 0;
        while (i < minLen && string1.charAt(i) == string2.charAt(i)) i++;
        return string1.substring(0, i);
    }
    // 16 Возвращает самое длинное общее “начало” двух строк. Если у строк нет общего начала, возвращает пустую строку.
    public static String reverse(String string) {
        return new StringBuilder(string).reverse().toString();
    }
    // 17 Возвращает true, если строка является палиндромом, то есть читается слева направо так же, как и справа налево.
    public static boolean isPalindrome(String string) {
        return string.equals(reverse(string));
    }
    // 18 Возвращает true, если строка является палиндромом, то есть читается слева направо так же, как и справа налево, без учета регистра.
    public static boolean isPalindromeIgnoreCase(String string) {
        return string.equalsIgnoreCase(reverse(string));
    }
    // 19 Возвращает самый длинный палиндром (без учета регистра) из массива заданных строк. Если в массиве нет палиндромов, возвращает пустую строку.
    public static String getLongestPalindromeIgnoreCase(String[] strings) {
        if (strings == null) return "";
        String longest = "";
        for (String s : strings) {
            if (s != null && isPalindromeIgnoreCase(s) && s.length() > longest.length()) {
                longest = s;
            }
        }
        return longest;
    }
    // 20 Возвращает true, если обе строки содержат один и тот же фрагмент длиной length, начиная с позиции index.
    public static boolean hasSameSubstring(String string1, String string2, int index, int length) {
        if (string1 == null || string2 == null) return false;
        if (index < 0 || index + length > string1.length() || index + length > string2.length()) return false;
        return string1.substring(index, index + length).equals(string2.substring(index, index + length));
    }
    //  21 Возвращает true, если после замены в string1 всех вхождений replaceInStr1 на replaceByInStr1 и замены в string2 всех вхождений replaceInStr2 на replaceByInStr2 полученные строки равны.
    public static boolean isEqualAfterReplaceCharacters(String string1, char old1, char new1,
                                                        String string2, char old2, char new2) {
        return string1.replace(old1, new1).equals(string2.replace(old2, new2));
    }
    // 22 Возвращает true, если после замены в string1 всех вхождений строки replceInStr1 на replaceByInStr1 и замены в string2 всех вхождений replceInStr2 на replaceByInStr2 полученные строки равны.
    public static boolean isEqualAfterReplaceStrings(String string1, String old1, String new1,
                                                     String string2, String old2, String new2) {
        return string1.replace(old1, new1).equals(string2.replace(old2, new2));
    }
    // 23 Возвращает true, если строка после выбрасывания из нее всех пробелов является палиндромом, без учета регистра.
    public static boolean isPalindromeAfterRemovingSpacesIgnoreCase(String string) {
        String cleaned = string.replaceAll("\\s", "").toLowerCase();
        return cleaned.equals(reverse(cleaned));
    }
    // 24 Возвращает true, если две строки равны, если не принимать во внимание все пробелы в начале и конце каждой строки.
    public static boolean isEqualAfterTrimming(String string1, String string2) {
        return string1.trim().equals(string2.trim());
    }
    // 25 Для заданного массива целых чисел создает текстовую строку, в которой числа разделены знаком “запятая” (т.н. формат CSV - comma separated values). Для пустого массива возвращается пустая строка.
    public static String makeCsvStringFromInts(int[] array) {
        if (array == null || array.length == 0) return "";
        StringJoiner joiner = new StringJoiner(",");
        for (int n : array) joiner.add(String.valueOf(n));
        return joiner.toString();
    }
    // 26 Для заданного массива вещественных чисел создает текстовую строку, в которой числа разделены знаком “запятая”, причем каждое число записывается с двумя знаками после точки. Для пустого массива возвращается пустая строка.
    public static String makeCsvStringFromDoubles(double[] array) {
        if (array == null || array.length == 0) return "";
        StringJoiner joiner = new StringJoiner(",");
        for (double n : array) joiner.add(String.format("%.2f", n));
        return joiner.toString();
    }
    // 27 	То же, что и в упражнении 25, но возвращает StringBuilder.
    public static StringBuilder makeCsvStringBuilderFromInts(int[] array) {
        StringBuilder sb = new StringBuilder();
        if (array == null || array.length == 0) return sb;
        for (int i = 0; i < array.length; i++) {
            if (i > 0) sb.append(',');
            sb.append(array[i]);
        }
        return sb;
    }
    // 28 То же, что и в упражнении 26, но возвращает StringBuilder.
    public static StringBuilder makeCsvStringBuilderFromDoubles(double[] array) {
        StringBuilder sb = new StringBuilder();
        if (array == null || array.length == 0) return sb;
        for (int i = 0; i < array.length; i++) {
            if (i > 0) sb.append(',');
            sb.append(String.format("%.2f", array[i]));
        }
        return sb;
    }
    // 29 Удаляет из строки символы, номера которых заданы в массиве positions. Предполагается, что будут передаваться только допустимые номера, упорядоченные по возрастанию. Номера позиций для удаления указаны для исходной строки. Возвращает полученный в результате StringBuilder.
    public static StringBuilder removeCharacters(String string, int[] positions) {
        if (string == null || positions == null || positions.length == 0) return new StringBuilder(string == null ? "" : string);
        StringBuilder sb = new StringBuilder(string);
        int offset = 0;
        for (int pos : positions) {
            sb.deleteCharAt(pos - offset);
            offset++;
        }
        return sb;
    }
    // 30 Вставляет в строку символы. Массивы positions и characters имеют одинаковую длину. В позицию positions[i] в исходной строке string вставляется символ characters[i]. Если в массиве positions один и тот же номер позиции повторяется несколько раз, это значит, что в указанную позицию вставляется несколько символов, в том порядке, в котором они перечислены в массиве characters. Предполагается, что будут передаваться только допустимые номера, упорядоченные по неубыванию.  Возвращает полученный в результате StringBuilder.
    public static StringBuilder insertCharacters(String string, int[] positions, char[] characters) {
        if (string == null) return new StringBuilder();
        if (positions == null || characters == null || positions.length != characters.length) return new StringBuilder(string);
        StringBuilder sb = new StringBuilder(string);
        int offset = 0;
        for (int i = 0; i < positions.length; i++) {
            sb.insert(positions[i] + offset, characters[i]);
            offset++;
        }
        return sb;
    }
}