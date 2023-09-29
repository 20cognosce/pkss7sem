package com.mirea.code.prac3.server.task12;

/*
12. Hайти пеpвый член последовательности ln(9n)/(n*n),
    меньший 1, для n изменяющегося следующим обpазом: n=1,2,3... .
*/
public class Task12Server {
    public static String calculate() {
        return calculateExpression();
    }

    private static String calculateExpression() {
        int n = 1;
        double term = Double.MAX_VALUE;

        while (term >= 1) {
            term = Math.log(9 * n) / (n * n);
            n++;
        }

        return "n = " + n + ", term = " + term;
    }
}
