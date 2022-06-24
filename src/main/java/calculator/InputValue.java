package calculator;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;


public class InputValue {
    private static String[] OPERATORES = {"+", "-", "*", "/"};
    private final String value;
    private InputType type;

    public InputValue(String value) {
        setType(value);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    private void setType(String value) {
        try {
            Integer.parseInt(value);
            type = InputType.NUMBER;
        } catch (NumberFormatException e) {
            isValidateOperator(value);
            type = InputType.OPERATOR;
        }
    }

    private void isValidateOperator(String value) {
        Optional<String> availableOperator = Arrays.stream(OPERATORES)
                .filter(op -> op.equals(value))
                .findAny();

        availableOperator.orElseThrow(() -> new IllegalArgumentException(value + "는 지원하지 않는 연산자 입니다"));
//        for (String operator : OPERATORES) {
//            if (value.equals(operator)) {
//                return;
//            }
//        }
//
//        throw new IllegalStateException(value + "는 지원하지 않는 연산자 입니다");
//    }
    }

    public boolean isNumber() {
        return type.equals(InputType.NUMBER);
    }

    public boolean isOperator() {
        return type.equals(InputType.OPERATOR);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof InputValue)) {
            return false;
        }
        InputValue that = (InputValue) o;
        return type == that.type && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, value);
    }
}
