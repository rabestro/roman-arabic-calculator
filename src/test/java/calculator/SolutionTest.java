package calculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(out));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @ParameterizedTest (name = "{0} = {1}")
    @DisplayName("Should calculate result on correct expressions")
    @CsvFileSource(resources = "/correctExpressions.csv", numLinesToSkip = 1, delimiter = '=')
    void correctExpressions(String input, String expected) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Solution.main(null);
        assertEquals(expected, out.toString().stripTrailing());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/inputMismatch.csv")
    @DisplayName("Should throw InputMismatchException exception")
    void inputMismatch(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThrows(InputMismatchException.class, () -> Solution.main(null));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/noSuchElement.csv")
    @DisplayName("Should throw NoSuchElementException exception")
    void noSuchElement(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThrows(NoSuchElementException.class, () -> Solution.main(null));
    }
}