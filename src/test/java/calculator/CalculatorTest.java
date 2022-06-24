package calculator;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    @Test
    void splitTest() {
        String str = "2 + 3 * 4 / 2";
        String[] expectedValue = {"2", "+", "3", "*", "4", "/", "2"};

        assertThat(str.split(" ")).containsExactly(expectedValue);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2", "10", "/", "+", "-7"})
    void 타입확인_숫자(String input) {
        InputValue value = new InputValue(input);
        assertThat(value.isNumber()).isTrue();

    }

    @ParameterizedTest
    @ValueSource(strings = { "/", "+"})
    void 타입확인_숫자불일치(String input) {
        InputValue value = new InputValue(input);
        assertThat(value.isNumber()).isFalse();

    }

    @ParameterizedTest
    @ValueSource(strings = {"4", "+", "*", "11", "/", "-"})
    void 타입확인_연산자(String input) {
        InputValue value = new InputValue(input);
        assertThat(value.isOperator()).isTrue();

    }

    @ParameterizedTest
    @ValueSource(strings = {"4", "11"})
    void 타입확인_연산자불일치(String input) {
        InputValue value = new InputValue(input);
        assertThat(value.isOperator()).isFalse();

    }

    @Test
    void equalsTest() {
        InputValue inputValue = new InputValue("10");

        assertThat(inputValue).isEqualTo(new InputValue("10"));
    }

    @Test
    void inputTest() {
        Calculator calculator = new StringCalculator();
        calculator.input("2 + 3 * 4 / 2");

        List<InputValue> inputValues = calculator.getValues();

        assertThat(inputValues.size()).isEqualTo(7);
        assertThat(inputValues).containsExactly(new InputValue("2"),
                new InputValue("+"),
                new InputValue("3"),
                new InputValue("*"),
                new InputValue("4"),
                new InputValue("/"),
                new InputValue("2"));
    }


    @Test
    void calculate() {
        Calculator calculator = new StringCalculator();

        calculator.input("1 + 2 / 3 * 4 + 5");
        assertThat(calculator.calculate()).isEqualTo(9);

//        calculator.input("2 + 2 * 4 / 1");
//        assertThat(calculator.calculate()).isEqualTo(16);
    }
}