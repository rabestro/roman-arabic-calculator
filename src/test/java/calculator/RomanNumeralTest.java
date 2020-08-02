package calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/romanToArabic.csv", numLinesToSkip = 1, delimiter = '=')
    void romanToArabic(String input, int expected) {
        assertEquals(expected, RomanNumeral.romanToArabic(input));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/arabicToRoman.csv", numLinesToSkip = 1, delimiter = '=')
    void arabicToRoman(int input, String expected) {
        assertEquals(expected, RomanNumeral.arabicToRoman(input));
    }
}