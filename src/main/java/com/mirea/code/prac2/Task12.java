package com.mirea.code.prac2;

import java.util.concurrent.atomic.AtomicReference;

/*
12. Используя подпpогpамму - функцию, составить пpогpамму для печати знаков тpех чисел,
    введенных с клавиатуpы и передаваемых функции в качестве параметра
*/
public class Task12 {

    public static String calculate(String input) {
        var args = extractParameters(input);
        if (args.length != 3) {
            return "Incorrect input format.";
        }
        return calculateExpression(args);
    }

    private static String calculateExpression(double[] args) {
        AtomicReference<String> result = new AtomicReference<>("");
        for (double arg : args) {
            if (arg > 0) {
                result.set(result + "+ ");
            } else {
                result.set(result + "- ");
            }
        }
        return result.get();
    }

    private static double[] extractParameters(String input) {
        try {
            var args = input.trim().split(" ");
            double a = Double.parseDouble(args[0]);
            double b = Double.parseDouble(args[1]);
            double c = Double.parseDouble(args[2]);
            System.out.printf("Extracted input parameters: a = {%s}, b = {%s}, c = {%s}", a, b, c);
            return new double[] {a, b, c};
        } catch (Exception e) {
            return new double[] {};
        }
    }
}
