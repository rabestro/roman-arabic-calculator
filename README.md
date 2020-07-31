# roman-arabic-calculator

This code is proof of concept.

## The requirements

1. The calculator can perform operations of addition, subtraction, multiplication and division with two numbers: a + b, a - b, a * b, a / b. Data is entered in one line.
2. The calculator can work with both Arabic (1,2,3,4,5 ...) and Roman (I, II, III, IV, V ...) numbers.
3. The calculator must accept numbers from 1 to 10 inclusively. At the output, the numbers are not limited in size and can be any.
4. The calculator can only work with whole numbers.
5. The calculator can only work with Arabic or Roman numerals at the same time, when the user enters a line like 3 + II, the calculator should throw an exception and stop working.
6. When the user enters inappropriate numbers, the application throws an exception and exits.
7. When the user enters a string that does not match one of the above arithmetic operations, the application throws an exception and exits.

## The implementation

The class RomanNumeral.java used to parse and convert Roman Numerals. The code taked from [Baeldung](https://www.baeldung.com/java-convert-roman-arabic) 

The main idea is to validate user input using [next​(String pattern)](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Scanner.html#next(java.lang.String)) method of Scanner class. It allows to throw InputMismatchException immediately after incorrect user input. To fulfill the condition for the simultaneous input of either Arabic or Roman numbers, we determine the mode by the first number and use the appropriate pattern for the second number.
