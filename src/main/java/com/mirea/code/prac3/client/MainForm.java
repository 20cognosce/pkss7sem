package com.mirea.code.prac3.client;

import com.mirea.code.prac3.client.task12.Task12Client;
import com.mirea.code.prac3.client.task15.Task15Client;
import com.mirea.code.prac3.client.task3.Task3Client;
import com.mirea.code.prac3.client.task6.Task6Client;
import com.mirea.code.prac3.client.task9.Task9Client;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lombok.SneakyThrows;

public class MainForm extends Application {

    @SneakyThrows
    @Override
    public void start(Stage stage) {
        stage.setTitle("Варианты 3, 6, 9, 12, 15");

        var client = new Client();
        var numberModules = Task3Client.render(client);
        var logarithm = Task6Client.render(client);
        var sin = Task9Client.render(client);
        var sequence = Task12Client.render(client);
        var squares = Task15Client.render(client);

        VBox vbox = new VBox(20);
        vbox.getChildren().addAll(
                numberModules,
                logarithm,
                sin,
                sequence,
                squares);

        Scene scene = new Scene(vbox, 1500, 500);

        stage.setScene(scene);
        stage.show();
    }
}
