package com.mirea.code.prac3.server.task3;

import java.util.Collections;
import java.util.List;

/*
3. Вывести с клавиатуры и напечатать модули N чисел; если введено отрицательное число, ввод и печать прекратить.
*/
public class Task3Server {

    public static String calculate(String input) {
        System.out.printf("Получен запрос {%s} \n", input);
        var args = extractParameters(input);
        if (args.size() < 1) {
            return "Incorrect input.";
        }
        return calculateExpression(args);
    }

    public static String calculateExpression(List<Double> numbers) {
        StringBuilder result = new StringBuilder();
        for (Double number : numbers) {
            double absoluteValue = Math.abs(number);
            result.append(absoluteValue).append(" ");
        }
        return result.toString().trim();
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
