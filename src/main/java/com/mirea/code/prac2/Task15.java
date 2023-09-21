package com.mirea.code.prac2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
15. Задав функцию, вывести на печать сpедние аpифметические двух массивов, введенных с клавиатуpы.
    Массив передается функции в качестве параметра
*/
public class Task15 {

    public static String calculate(String input) {
        var args = extractParameters(input);
        if (args.length != 2) {
            return "Incorrect input format.";
        }
        return calculateExpression(args);
    }

    private static String calculateExpression(List<Double>[] args) {
        Double[] avgs = new Double[2];

        for (int i = 0; i < args.length; i++) {
            var array = args[i];
            final int j = i;
            array.stream()
                    .mapToDouble(e -> e)
                    .average()
                    .ifPresentOrElse(avg -> avgs[j] = avg, () -> avgs[j] = null);
        }

        return String.format("{%s} {%s}", avgs[0], avgs[1]);
    }

    private static List<Double>[] extractParameters(String input) {
        try {
            var args = input.trim().split(" ");

            var a = (ArrayList<Double>) Arrays.stream(args[0].split(","))
                    .map(Double::parseDouble).toList();
            var b = (ArrayList<Double>) Arrays.stream(args[1].split(","))
                    .map(Double::parseDouble).toList();

            System.out.printf("Extracted input parameters: a = %s, b = %s", a, b);
            return new ArrayList[]{a, b};
        } catch (Exception e) {
            return new ArrayList[]{};
        }
    }
}

