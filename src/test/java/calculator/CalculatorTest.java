package calculator;


import org.junit.jupiter.api.Test;

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

    @Test
    void 타입확인_숫자() {
        String[] strArr = {"1", "2", "3", "4", "s" };

        assertThat(new InputValue(strArr).isNumber()).isTrue();
        assertThat(new InputValue("-10").isNumber()).isTrue();
    }

    @Test
    void 타입확인_연산자() {
        assertThat(new InputValue("+").isOperator()).isTrue();
        assertThat(new InputValue("-").isOperator()).isTrue();
        assertThat(new InputValue("*").isOperator()).isTrue();
        assertThat(new InputValue("/").isOperator()).isTrue();

        assertThatThrownBy(() -> new InputValue("#")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new InputValue("**")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void equalsTest() {
        InputValue inputValue = new InputValue("5");

        assertThat(inputValue).isEqualTo(new InputValue("5"));
    }

    @Test
    void inputTest() {
        Calculator calculator = new Calculator();
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
        Calculator calculator = new Calculator();

        calculator.input("2 + 3 * 4 / 2");
        assertThat(calculator.calculate()).isEqualTo(10);

        calculator.input("2 + 2 * 4 / 1");
        assertThat(calculator.calculate()).isEqualTo(16);
    }
}