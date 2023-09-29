package com.mirea.code.prac3.client.task12;

import com.mirea.code.prac3.client.Client;
import com.mirea.code.prac3.route.Port;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class Task12Client {

    public static HBox render(Client client) {
        Label resultLabel = new Label();
        Button checkButton = new Button("Найти первый член последовательности ln(9n)/(n*n)");

        checkButton.setOnAction(e -> resultLabel.setText(client.sendRequestToServer(Port.FOUR, "")));

        HBox hbox = new HBox(10);
        hbox.setPadding(new Insets(10));
        hbox.getChildren().addAll(
                checkButton,
                resultLabel
        );

        return hbox;
    }
}
