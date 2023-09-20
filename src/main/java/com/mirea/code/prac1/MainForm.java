package com.mirea.code.prac1;

import com.mirea.code.prac1.check.BrickPassCheck;
import com.mirea.code.prac1.check.CircleSquareCheck;
import com.mirea.code.prac1.check.InequalityCheck;
import com.mirea.code.prac1.check.NumberOperationsCheck;
import com.mirea.code.prac1.check.NumberOperationsCheck2;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainForm extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Варианты 3, 6, 9, 12, 15");

        var brickPassCheckHbox = BrickPassCheck.render();
        var inequalityCheckHbox = InequalityCheck.render();
        var circleSquareCheckHbox = CircleSquareCheck.render();
        var numberOperationsCheckHbox = NumberOperationsCheck.render();
        var numberOperationsCheck2Hbox = NumberOperationsCheck2.render();

        VBox vbox = new VBox(20);
        vbox.getChildren().addAll(
                brickPassCheckHbox,
                inequalityCheckHbox,
                circleSquareCheckHbox,
                numberOperationsCheckHbox,
                numberOperationsCheck2Hbox);

        Scene scene = new Scene(vbox, 1500, 500);

        stage.setScene(scene);
        stage.show();
    }
}
