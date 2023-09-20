package com.mirea.code.prac1.check;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class NumberOperationsCheck2 {

    public static HBox render() {
        TextField aField = new TextField();
        TextField bField = new TextField();
        Label resultLabel = new Label();
        Button calculateButton = new Button("Выполнить операции");

        calculateButton.setOnAction(e -> {
            try {
                double a = Double.parseDouble(aField.getText());
                double b = Double.parseDouble(bField.getText());
                if (a >= 0 && b >= 0) {
                    a = a * a * a;
                    b = b * b * b;
                } else {
                    if (a < 0) {
                        a = Math.abs(a);
                    }
                    if (b < 0) {
                        b = Math.abs(b);
                    }
                }

                resultLabel.setText("A: " + a + ", B: " + b);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Ошибка: Введите корректные числа");
            }
        });

        HBox hbox = new HBox(10);
        hbox.setPadding(new Insets(10));
        hbox.getChildren().addAll(
                new Label("Введите число A:"),
                aField,
                new Label("Введите число B:"),
                bField,
                calculateButton,
                resultLabel
        );

        return hbox;
    }
}

