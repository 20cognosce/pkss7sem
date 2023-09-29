package com.mirea.code.prac3.server.task15;

import java.util.Collections;
import java.util.List;

/*
15. Ввести с клавиатуры и напечатать квадраты N чисел, если введено кpатное 3
    положительное число, ввод и печать прекратить.
*/
public class Task15Server {

    public static String calculate(String input) {
        var args = extractParameters(input);
        if (args.size() < 1) {
            return "Incorrect input format.";
        }
        return calculateExpression(args);
    }

    private static String calculateExpression(List<Double> args) {
        List<Double> result = args.stream()
                .takeWhile(number -> !(number % 3 == 0 && number > 0))
                .map(number -> number * number).toList();

        return result.toString();
    }

    private static List<Double> extractParameters(String input) {
        try {
            var args = List.of(input.trim().split(" "));
            var argsAsDouble = args.stream().map(Double::parseDouble).toList();
            System.out.printf("Extracted input parameters: %s \n", argsAsDouble);
            return argsAsDouble;
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
}

