package string;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.HashSet;
import java.util.Set;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }


    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void 원소확인체크(int input) {
        assertThat(numbers.contains(input)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void 빈칸_확인(String input) {
        assertThat(input.isBlank()).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"test:test", "tEst:test", "Java:java"}, delimiter = ':')
    void 테스트(String input, String expected) {
        String actualValue = input.toLowerCase();
        assertThat(expected).isEqualTo(actualValue);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true" ,"3:true" ,"4:false" ,"5:false"}, delimiter = ':')
    void 테스트_1(String input, String expected) {
        int inputNumber = Integer.parseInt(input);
        boolean result = Boolean.parseBoolean(expected);
        assertThat(numbers.contains(inputNumber)).isEqualTo(result);
    }
}
