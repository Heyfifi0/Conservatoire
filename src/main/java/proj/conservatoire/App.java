package proj.conservatoire;

import Models.Eleve;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static Eleve eleve;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("/vues/connexion_v2"));
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
    
    public static Eleve getEleve() {
        return eleve;
    }

    public static void setEleve(Eleve eleve) {
        App.eleve = eleve;
    }

}