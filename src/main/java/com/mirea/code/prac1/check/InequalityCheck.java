package com.mirea.code.prac1.check;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class InequalityCheck {

    public static HBox render() {
        TextField aField = new TextField();
        TextField bField = new TextField();
        TextField cField = new TextField();

        Label resultLabel = new Label();

        Button checkButton = new Button("Проверить");

        checkButton.setOnAction(e -> {
            try {
                double a = Double.parseDouble(aField.getText());
                double b = Double.parseDouble(bField.getText());
                double c = Double.parseDouble(cField.getText());

                if (a < b && b < c) {
                    a = b + c;
                } else {
                    a = c - b;
                }

                resultLabel.setText("Результат: " + a);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Ошибка: Введите корректные числа");
            }
        });

        HBox hbox = new HBox(10);
        hbox.setPadding(new Insets(10));
        hbox.getChildren().addAll(
                new Label("A:"),
                aField,
                new Label("B:"),
                bField,
                new Label("C:"),
                cField,
                checkButton,
                resultLabel
        );

        return hbox;
    }
}

