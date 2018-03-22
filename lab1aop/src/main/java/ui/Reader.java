package ui;

import controller.Controller;
import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.News;
import utils.ObserverPattern.Observer;



public class Reader extends Application implements Observer {

    private TableView<News> table = new TableView<>();
    private Controller controller = new Controller();
    private ObservableList<News> newsObservableList;

    public Reader() {
        super();
        controller.getNewsRepository().register(this);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        Button btn3 = new Button();
        btn3.setText("Delete News");

        Button btn1 = new Button();
        btn1.setText("Subscribe Reader");

        Button btn2 = new Button();
        btn2.setText("Unsubscribe Reader");

        btn3.setOnAction(event -> {
            News news = table.getSelectionModel().getSelectedItem();
            controller.removeNews(news.getId());
        });

        btn1.setOnAction(event -> {
            controller.subscribe(this);
        });

        btn2.setOnAction(event -> {
            controller.unSubscribe(this);
        });


        StackPane root = new StackPane();

        Scene scene = new Scene(new Group());

        final Label label = new Label("Reader");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);

        TableColumn id = new TableColumn("Id");
        id.setCellValueFactory(
                new PropertyValueFactory<News, Integer>("id")
        );
        TableColumn title = new TableColumn("Title");
        title.setCellValueFactory(
                new PropertyValueFactory<News, String>("title")
        );

        TableColumn content = new TableColumn("Content");
        content.setCellValueFactory(
                new PropertyValueFactory<News, String>("content")
        );

        table.getColumns().addAll(id, title, content);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        HBox hb = new HBox();
        hb.getChildren().addAll(btn1, btn2, btn3);
        vbox.getChildren().addAll(label, table, hb);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);


        primaryStage.setTitle("Programmer!");
        primaryStage.setWidth(300);
        primaryStage.setHeight(500);
        primaryStage.setScene(scene);
        primaryStage.show();

        update();

    }

    @Override
    public void update() {

        table.getItems().clear();
        newsObservableList = FXCollections.observableArrayList(controller.getNewsRepository().getAllNews());
        table.setItems(newsObservableList);

    }
}
