package com.mirea.code.prac2;

/*
3. Даны числа S, T.
   Получить с использованием функции пользователя F(T,-2S,1.17) + F(2.2,T,S-T),
   где F(A, B, C) = (2A-B-sin(C))/(5+C)
*/
public class Task3 {

    public static String calculate(String input) {
        var args = extractParameters(input);
        if (args.length != 2) {
            return "Incorrect input format.";
        }
        return calculateExpression(args[0], args[1]);
    }

    private static String calculateExpression(double S, double T) {
        double result1 = calculateF(T, -2 * S, 1.17);
        double result2 = calculateF(2.2, T, S - T);
        return String.valueOf(result1 + result2);
    }

    private static double calculateF(double A, double B, double C) {
        return (2 * A - B - Math.sin(C)) / (5 + C);
    }

    private static double[] extractParameters(String input) {
        try {
            var args = input.trim().split(" ");
            double S = Double.parseDouble(args[0]);
            double T = Double.parseDouble(args[1]);
            System.out.printf("Extracted input parameters: S = {%s}, T = {%s}", S, T);
            return new double[] {S, T};
        } catch (Exception e) {
           return new double[] {};
        }
    }
}
