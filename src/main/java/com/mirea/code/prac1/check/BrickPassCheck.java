package com.mirea.code.prac1.check;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class BrickPassCheck {

    public static HBox render() {
        TextField aField = new TextField();
        TextField bField = new TextField();
        TextField cField = new TextField();
        TextField xField = new TextField();
        TextField yField = new TextField();
        Label resultLabel = new Label();

        Button checkButton = new Button("Проверить");

        checkButton.setOnAction(e -> {
            try {
                double a = Double.parseDouble(aField.getText());
                double b = Double.parseDouble(bField.getText());
                double c = Double.parseDouble(cField.getText());
                double x = Double.parseDouble(xField.getText());
                double y = Double.parseDouble(yField.getText());

                if ((a <= x && b <= y) || (a <= y && b <= x) ||
                        (a <= x && c <= y) || (a <= y && c <= x) ||
                        (b <= x && c <= y) || (b <= y && c <= x)) {
                    resultLabel.setText("Кирпич пройдет через отверстие.");
                } else {
                    resultLabel.setText("Кирпич не пройдет через отверстие.");
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Ошибка: Введите корректные числа");
            }
        });

        HBox hbox = new HBox(10);
        hbox.setPadding(new Insets(10));
        hbox.getChildren().addAll(
                new Label("Введите размеры \nкирпича (A, B, C):"),
                new HBox(10, new Label("A:"), aField, new Label("B:"), bField, new Label("C:"), cField),
                new Label("Введите размеры \nотверстия (x, y):"),
                new HBox(10, new Label("x:"), xField, new Label("y:"), yField),
                checkButton,
                resultLabel
        );

        return hbox;
    }
}
