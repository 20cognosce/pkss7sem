package com.mirea.code.prac3.server.task6;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
6. Напечатать значения функции y=ln(x+12/x),где значения x вводятся с клавиатуры.
   При вводе числа, не входящего в область определения функции, вычисления прекратить.
* */
public class Task6Server {

    public static String calculate(String input) {
        System.out.printf("Получен запрос {%s} \n", input);
        var args = extractParameters(input);
        if (args.size() != 1) {
            return "Incorrect input.";
        }
        return calculateExpression(args);
    }

    public static String calculateExpression(List<Double> numbers) {
        var x = numbers.get(0);

        if (x <= 0) {
           return "x = " + x + " находится вне области определения функции";
        } else {
            double result = Math.log(x + 12 / x);
            return "y = " + result;
        }
    }

    private static List<Double> extractParameters(String input) {
        try {
            var args = input.trim().split(" ");
            var argsAsDouble = Arrays.stream(args)
                    .map(Double::parseDouble)
                    .toList();
            System.out.printf("Extracted input parameters: %s \n", argsAsDouble);
            return argsAsDouble;
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
}
