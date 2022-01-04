package ultilities.validation;

public class Validation {
    public int validateOpe(int b, String ope) {
        if (!ope.equalsIgnoreCase("+") && !ope.equalsIgnoreCase("-") && !ope.equalsIgnoreCase("x")
                && !ope.equalsIgnoreCase(":")) {
            return -1;
        }
        if((ope.equalsIgnoreCase(":") && b == 0)){
            return 0;

        }
        return 1;
    }
}
