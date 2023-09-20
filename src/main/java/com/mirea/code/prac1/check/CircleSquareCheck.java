package com.mirea.code.prac1.check;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class CircleSquareCheck {

    public static HBox render() {
        TextField radiusField = new TextField();
        TextField sideLengthField = new TextField();
        Label resultLabel = new Label();
        Button checkButton = new Button("Проверить");

        checkButton.setOnAction(e -> {
            try {
                double radius = Double.parseDouble(radiusField.getText());
                double sideLength = Double.parseDouble(sideLengthField.getText());

                if (sideLength <= 2 * radius && radius <= Math.sqrt(2) * sideLength / 2.0) {
                    resultLabel.setText("Круг и квадрат пересекаются.");
                } else {
                    resultLabel.setText("Круг и квадрат не пересекаются.");
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Ошибка: Введите корректные числа");
            }
        });

        HBox hbox = new HBox(10);
        hbox.setPadding(new Insets(10));
        hbox.getChildren().addAll(
                new Label("Введите радиус круга (R):"),
                radiusField,
                new Label("Введите сторону квадрата (A):"),
                sideLengthField,
                checkButton,
                resultLabel
        );

        return hbox;
    }
}
