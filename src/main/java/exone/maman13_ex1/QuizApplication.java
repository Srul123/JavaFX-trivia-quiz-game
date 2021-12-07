package exone.maman13_ex1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @ Maman 13 - EX1
 * @author Israel Heiblum 301823555
 */

public class QuizApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(QuizApplication.class.getResource("quiz-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Maman 13 ex 1");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}