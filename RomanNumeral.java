// The following code is taken from the website:
// https://www.baeldung.com/java-convert-roman-arabic

import java.util.Arrays;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

enum RomanNumeral {
    I(1), IV(4), V(5), IX(9), X(10),
    XL(40), L(50), XC(90), C(100),
    CD(400), D(500), CM(900), M(1000);

    private final int value;

    RomanNumeral(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static List<RomanNumeral> getReverseSortedValues() {
        return Arrays.stream(values())
                .sorted(comparing((RomanNumeral e) -> e.value).reversed())
                .collect(toList());
    }

    public static int romanToArabic(final String input) {
        final var romanNumerals = getReverseSortedValues();
        var romanNumeral = input.toUpperCase();

        int result = 0;
        for (int i = 0; (romanNumeral.length() > 0) && (i < romanNumerals.size());) {
            final var symbol = romanNumerals.get(i);
            if (romanNumeral.startsWith(symbol.name())) {
                result += symbol.getValue();
                romanNumeral = romanNumeral.substring(symbol.name().length());
            } else {
                i++;
            }
        }
        if (romanNumeral.length() > 0) {
            throw new IllegalArgumentException(input + " cannot be converted to a Roman Numeral");
        }
        return result;
    }

    public static String arabicToRoman(int number) {
        if ((number <= 0) || (number > 4000)) {
            throw new IllegalArgumentException(number + " is not in range (0,4000]");
        }
        final var romanNumerals = getReverseSortedValues();
        final var sb = new StringBuilder();

        for (int i = 0; (number > 0) && (i < romanNumerals.size()); ) {
            final var currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }

        return sb.toString();
    }

}
