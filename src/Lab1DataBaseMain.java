import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Lab1DataBaseMain extends Application {

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Lab01_DB_Graph - Students/Groups");
        Parent main = FXMLLoader.load(getClass().getResource("/view/main_window.fxml"));
        primaryStage.setScene(new Scene(main));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
