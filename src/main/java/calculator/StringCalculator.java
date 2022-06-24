package calculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator implements Calculator {
    private final List<InputValue> inputValues = new ArrayList<>();
    private final List<Integer> numbers = new ArrayList<>();
    private final List<String> operators = new ArrayList<>();



    @Override
    public void input(String value) {
        String[] inputValues = value.split(" ");
        for (String inputValue : inputValues) {
            this.inputValues.add(new InputValue(inputValue));
        }
    }

    @Override
    public int calculate() {
        for (int i = 0; i < inputValues.size(); i++) {
            if (inputValues.get(i).isNumber()) {
                numbers.add(Integer.parseInt(inputValues.get(i).getValue()));
            } else if (inputValues.get(i).isOperator()) {
                operators.add(inputValues.get(i).getValue());
            }
        }
        int result = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            if (operators.get(i-1).equals("+")) {
                result = numbers.get(i) + result;
            } else if (operators.get(i-1).equals("*")) {
                result = numbers.get(i) * result;
            } else if (operators.get(i-1).equals("/")) {
                result = numbers.get(i) / result;
            }
        }
        return result;
    }

    @Override
    public List<InputValue> getValues() {
        return inputValues;
    }
}
