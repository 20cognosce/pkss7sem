package com.mirea.code.prac2;

/*
6. Составить пpогpамму для pасчета значений гипотенузы тpеугольника,
   опpеделив функцию, выполняющую этот pасчет. Катеты передаются в качестве параметров.
*/
public class Task6 {

    public static String calculate(String input) {
        var args = extractParameters(input);

        if (args.length != 2) {
            return "Incorrect input format.";
        }

        return calculateExpression(args[0], args[1]);
    }

    private static String calculateExpression(double a, double b) {
        return String.valueOf(Math.sqrt(a * a + b * b));
    }
    private static double[] extractParameters(String input) {
        try {
            var args = input.trim().split(" ");
            double a = Double.parseDouble(args[0]);
            double b = Double.parseDouble(args[1]);
            System.out.printf("Extracted input parameters: a = {%s}, b = {%s}", a, b);
            return new double[] {a, b};
        } catch (Exception e) {
            return new double[] {};
        }
    }
}
