package calculator;

import java.util.List;

enum RomanNumeral {
    C(100), XC(90), L(50), XL(40), X(10), IX(9), V(5), IV(4), I(1);

    private final int value;

    RomanNumeral(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    static int romanToArabic(final String number) {
        return 1 + List.of("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X").indexOf(number);
    }

    static String arabicToRoman(int number) {
        final var sb = new StringBuilder();
        for (var romanNumber : RomanNumeral.values()) {
            while (romanNumber.getValue() <= number) {
                number -= romanNumber.getValue();
                sb.append(romanNumber.toString());
            }
        }
        return sb.toString();
    }
}
