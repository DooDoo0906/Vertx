package ultilities.operation;

public class Operation {
    public int operation(int a, int b, String op){

        switch (op) {
            case "+":
                return a + b;

            case "-":
                return  a - b;

            case "x":
                return  a * b;

            case ":":
                return  a / b;

            default:

        }
        return 0;
    }

}
