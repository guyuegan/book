package enumAndAnnotation_cpt6;

import java.util.Arrays;
import java.util.Optional;

/**
 *  enum type with constant-specific method implementations
 *  enum type with constant-specific class bodies and data
 */
public enum OperationBetter {
    PLUS("+") {
        @Override
        double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-") {
        @Override
        double apply(double x, double y) {
            return x - y;
        }
    },
    TIMES("*") {
        @Override
        double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        @Override
        double apply(double x, double y) {
            return x / y;
        }
    };

    private final String symbol;
    OperationBetter(String symbol) {this.symbol = symbol;}

    @Override
    public String toString() {
        return symbol;
    }

    abstract double apply(double x, double y);

    public static OperationBetter fromString(String symbol) {
        Optional<OperationBetter> matchOp = Arrays.stream(values())
                .filter(op -> op.symbol.equals(symbol.trim())).findAny();
        return matchOp.get();
    }
}

class OperationBetterTest {
    public static void main(String[] args) {
        double x = 2, y = 4;

        Arrays.stream(OperationBetter.values()).forEach(op ->
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y)));

        System.out.println(OperationBetter.fromString("+"));
    }
}
