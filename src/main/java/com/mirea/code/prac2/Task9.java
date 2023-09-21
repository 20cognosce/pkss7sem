package com.mirea.code.prac2;

import java.util.Arrays;
import java.util.Locale;

/*
9. Найти площадь пятиугольника, кооpдинаты веpшин котоpого заданы.
   Опpеделить пpоцедуpу вычисления pасстояния между двумя точками, заданными своими кооpдинатами,
   и пpоцедуpу вычисления площади тpеугольника по тpем стоpонам. Описать функции с соответствующими формальными параметрами.
*/
//example: 0,0 0,5 3,7 6,5 6,0 = 36
public class Task9 {

    public static String calculate(String input) {
        var args = extractParameters(input);
        if (args.length != 10) {
            return "Incorrect input format.";
        }
        return calculateExpression(args);
    }

    private static String calculateExpression(double[] args) {
        double x1 = args[0], y1 = args[1];
        double x2 = args[2], y2 = args[3];
        double x3 = args[4], y3 = args[5];
        double x4 = args[6], y4 = args[7];
        double x5 = args[8], y5 = args[9];

        double side1 = calculateDistance(x1, y1, x2, y2);
        double side2 = calculateDistance(x2, y2, x3, y3);
        double side3 = calculateDistance(x1, y1, x3, y3);
        double side4 = calculateDistance(x3, y3, x4, y4);
        double side5 = calculateDistance(x1, y1, x4, y4);
        double side6 = calculateDistance(x4, y4, x5, y5);
        double side7 = calculateDistance(x1, y1, x5, y5);

        double area1 = calculateTriangleArea(side1, side2, side3);
        double area2 = calculateTriangleArea(side3, side4, side5);
        double area3 = calculateTriangleArea(side5, side6, side7);

        return String.format(Locale.US,"%.2f", area1 + area2 + area3);
    }

    private static double calculateDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    private static double calculateTriangleArea(double a, double b, double c) {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    private static double[] extractParameters(String input) {
        try {
            var args = input.trim().split(" ");

            var p1 = Arrays.stream(args[0].split(","))
                    .map(Double::parseDouble).toList();
            var p2 = Arrays.stream(args[1].split(","))
                    .map(Double::parseDouble).toList();
            var p3 = Arrays.stream(args[2].split(","))
                    .map(Double::parseDouble).toList();
            var p4 = Arrays.stream(args[3].split(","))
                    .map(Double::parseDouble).toList();
            var p5 = Arrays.stream(args[4].split(","))
                    .map(Double::parseDouble).toList();

            System.out.printf("Extracted input parameters: p1 = %s, p2 = %s, p3 = %s, p4 = %s, p5 = %s", p1, p2, p3, p4, p5);
            return new double[] {
                    p1.get(0), p1.get(1),
                    p2.get(0), p2.get(1),
                    p3.get(0), p3.get(1),
                    p4.get(0), p4.get(1),
                    p5.get(0), p5.get(1),
            };
        } catch (Exception e) {
            return new double[] {};
        }
    }
}
