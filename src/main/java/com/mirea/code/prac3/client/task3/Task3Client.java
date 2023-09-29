package com.mirea.code.prac3.client.task3;

import com.mirea.code.prac3.client.Client;
import com.mirea.code.prac3.route.Port;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class Task3Client {

    public static HBox render(Client client) {
        TextField aField = new TextField();
        Label resultLabel = new Label();
        Button checkButton = new Button("Поcчитать модули чисел");

        checkButton.setOnAction(e -> resultLabel.setText(client.sendRequestToServer(Port.ONE, aField.getText())));

        HBox hbox = new HBox(10);
        hbox.setPadding(new Insets(10));
        hbox.getChildren().addAll(
                new Label("Введите числа через пробел:"),
                new HBox(10, new Label(""), aField),
                checkButton,
                resultLabel
        );

        return hbox;
    }
}
