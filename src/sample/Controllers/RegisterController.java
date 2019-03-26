// Controler do Sceny o tej samej nazwie
// jest to zbior modolow co kiedy ma sie wykonac
// backButtonUse - powrot do sceny glownej "Logowania"
// checkButtonInUse- powinno sprawdzac czy dany uzytkownik juz istnieje
// registrykButtonInUse - powinnien dopisywac uzytkownika i haslo do DB
// narazie check i registry wypisuja w konsoli co sie podalo do poszczegolnych kwardracikow
package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class RegisterController {

    @FXML
    private TextField userButton;

    @FXML
    private PasswordField passwordButton;

    @FXML
    private Button checkButton;

    @FXML
    private Button registryButton;

    @FXML
    private Button backButton;


    public void backButtonUse(ActionEvent event) throws IOException {
        Parent backToLogin = FXMLLoader.load(getClass().getResource("../View/LoginPane.fxml"));
        NewSceneClass newScene = new NewSceneClass();
        newScene.newScene(event,backToLogin);
    }

    public void checkButtonInUse(ActionEvent event){
        System.out.println("Wybrano username : " + userButton.getText());
        System.out.println("Wybrano password : " + passwordButton.getText());

    }
    public void registrykButtonInUse(ActionEvent event){
        System.out.println("Wybrano username : " + userButton.getText());
        System.out.println("Wybrano password : " + passwordButton.getText());
    }
}
