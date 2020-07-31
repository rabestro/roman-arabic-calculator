import java.util.*;
import java.util.function.IntBinaryOperator;
import java.util.function.IntFunction;
import java.util.function.ToIntFunction;

public final class Solution {
    private static final String ROMAN = "I?[XV]|V?II?I?";
    private static final String ARABIC = "[1-9]|10";
    private static final String OPERATION = "[-+*/]";
    private static final Map<String, IntBinaryOperator> arithmeticOperations = Map.of(
            "-", (x, y) -> x - y,
            "+", (x, y) -> x + y,
            "/", (x, y) -> x / y,
            "*", (x, y) -> x * y);

    public static void main(String[] args) {
        final var scanner = new Scanner(System.in);
        final var a = scanner.next(ROMAN + "|" + ARABIC);
        final var op = scanner.next(OPERATION);
        final var isRoman = a.matches(ROMAN);
        final var b = scanner.next(isRoman ? ROMAN : ARABIC);

        final ToIntFunction<String> parse = isRoman ? RomanNumeral::romanToArabic : Integer::parseInt;
        final IntFunction<String> toString = isRoman ? RomanNumeral::arabicToRoman : Integer::toString;

        final int result = arithmeticOperations.get(op)
                .applyAsInt(parse.applyAsInt(a), parse.applyAsInt(b));

        System.out.println(toString.apply(result));
    }

}

