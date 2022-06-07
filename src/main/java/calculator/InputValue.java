package calculator;

public class InputValue {
    public boolean InputValue(String s) {
        if (isStringDouble(s)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isStringDouble(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isNumber(String s) {
        boolean result = true;

        if (s == null || s.length() == 0) {
            result = false;
        } else {
            for (int i = 0; i < s.length(); i++) {
                int c = (int) s.charAt(i);

                if (c < 48 || c > 57) {
                    result = false;
                }
            }
        }
        return result;
    }
}