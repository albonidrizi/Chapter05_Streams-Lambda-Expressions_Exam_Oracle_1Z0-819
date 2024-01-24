/*
 * This code is part of the "Working with Streams and Lambda Expressions in Java (Java SE 11 Developer Certification 1Z0-819)".
 *
 * Copyright (C) 2024 by Albon Idrizi (albonidrizi@gmail.com).
 */

package S02_functional_interfaces.exercises;

import java.util.function.DoubleBinaryOperator;

public class FunctionalInterfacesExercise03 {

    public enum ArithmeticOperation {
        ADD((a, b) -> a + b),
        SUBTRACT((a, b) -> a - b),
        MULTIPLY((a, b) -> a * b),
        DIVIDE((a, b) -> a / b);

        private final DoubleBinaryOperator operator;

        ArithmeticOperation(DoubleBinaryOperator operator) {
            this.operator = operator;
        }

        public DoubleBinaryOperator getOperator() {
            return operator;
        }
    }

    /**
     * Exercise 3: Call a DoubleBinaryOperator to perform a calculation.
     *
     * @param a         First input value.
     * @param b         Second input value.
     * @param operation The operation to apply.
     * @return The result of applying the operation to the two input values.
     */
    public double calculate(double a, double b, ArithmeticOperation operation) {
        // TODO: Implement this method; apply the appropriate operation on the values a and b.
        // Note: This is a one-liner. You don't need a switch statement, for example.

//        return ...;

        throw new UnsupportedOperationException("Not yet implemented"); // Remove this line
    }
}
