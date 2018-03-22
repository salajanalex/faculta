package ui;

import controller.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.ObserverPattern.Observer;

public class Newspaper extends Application {

    private Controller controller = new Controller();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Button btn = new Button();
        btn.setText("New Reader");

        btn.setOnAction(event -> {
            Reader reader = new Reader();
            try {
                reader.start(new Stage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Button btnAdd = new Button();
        btnAdd.setText("Add");

        /**
         * Textfields unde introducem noi News
         */
        TextField title = new TextField();
        title.setPromptText("Title");

        TextField content = new TextField();
        content.setPromptText("Content");

        VBox hb = new VBox();
        hb.setSpacing(15);
        hb.getChildren().addAll(btn, title, content, btnAdd);

        btnAdd.setOnAction(event -> {
            if (title.getText().isEmpty() || content.getText().isEmpty())  {
                return;
            } else {
                controller.addNews(title.getText(),content.getText());
            }
        });

        StackPane root = new StackPane();
        root.getChildren().addAll(hb);

        Scene scene = new Scene(root, 400, 300);

        primaryStage.setTitle("Newspaper");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}
