package sample;

import javafx.scene.*;
import javafx.scene.control.*;

import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.*;
import javafx.geometry.*;

public class AlertBox {
    public static void display(String title, String message){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(450);
        Label label = new Label();
        label.setText(message);
        Button closeButton = new Button("Close the window");
        closeButton.setOnAction(e-> window.close());
        VBox layout = new VBox();
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();
    }
}

