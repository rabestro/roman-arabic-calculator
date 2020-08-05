package calculator;

import java.util.*;
import java.util.function.IntBinaryOperator;
import java.util.function.IntFunction;
import java.util.function.ToIntFunction;

public final class Solution {
    private static final String ROMAN = "I?[XV]|V?II?I?";
    private static final String ARABIC = "[1-9]|10";
    private static final String OPERATION = "[-+*/]";
    private static final String OR = "|";
    private static final Map<String, IntBinaryOperator> calculator = Map.of(
            "-", (x, y) -> x - y,
            "+", (x, y) -> x + y,
            "/", (x, y) -> x / y,
            "*", (x, y) -> x * y);

    public static void main(String[] args) {
        final var scanner = new Scanner(System.in);
        final var a = scanner.next(ROMAN + OR + ARABIC);
        final var op = scanner.next(OPERATION);
        final var isRoman = a.matches(ROMAN);
        final var b = scanner.next(isRoman ? ROMAN : ARABIC);

        final ToIntFunction<String> toInt = isRoman ? Solution::romanToArabic : Integer::parseInt;
        final IntFunction<String> toString = isRoman ? Solution::arabicToRoman : Integer::toString;

        final int result = calculator.get(op).applyAsInt(toInt.applyAsInt(a), toInt.applyAsInt(b));

        System.out.println(toString.apply(result));
    }

    static int romanToArabic(final String number) {
        return 1 + List.of("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X").indexOf(number);
    }

    static String arabicToRoman(int number) {
        return String.join("",
                number / 100 == 1 ? "C" : "",
                new String[]{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"}[number % 100 / 10],
                new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"}[number % 10]
        );
    }
}
