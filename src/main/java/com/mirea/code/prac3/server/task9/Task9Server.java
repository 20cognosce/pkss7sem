package com.mirea.code.prac3.server.task9;

/*
9. Вывести на печать значения функции z=sin(x)+cos(x),
   находящиеся в интервале (-0,2; 0,8) для x изменяющегося на отрезке [4,-6] с шагом 0,91.
*/

public class Task9Server {

    public static String calculate() {
        return calculateExpression();
    }

    private static String calculateExpression() {
        StringBuilder result = new StringBuilder();
        double start = -0.2;
        double end = 0.8;
        double step = 0.91;

        for (double x = 4.0; x >= -6.0; x -= step) {
            double z = Math.sin(x) + Math.cos(x);
            if (z >= start && z <= end) {
                result.append(z).append(" ");
            }
        }

        return result.toString();
    }
}
