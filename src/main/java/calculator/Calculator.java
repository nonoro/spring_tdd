package calculator;

import java.util.List;

public interface Calculator {
    void input(String value);

    int calculate();

    List<InputValue> getValues();
}


