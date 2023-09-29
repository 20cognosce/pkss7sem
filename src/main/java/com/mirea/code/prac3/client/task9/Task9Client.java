package com.mirea.code.prac3.client.task9;

import com.mirea.code.prac3.client.Client;
import com.mirea.code.prac3.route.Port;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class Task9Client {

    public static HBox render(Client client) {
        Label resultLabel = new Label();
        Button checkButton = new Button("Посчитать z=sin(x)+cos(x)");

        checkButton.setOnAction(e -> resultLabel.setText(client.sendRequestToServer(Port.THREE, "")));

        HBox hbox = new HBox(10);
        hbox.setPadding(new Insets(10));
        hbox.getChildren().addAll(
                checkButton,
                resultLabel
        );

        return hbox;
    }
}
