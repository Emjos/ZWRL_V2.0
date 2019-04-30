// Kontroler sceny logowania
// handleButtonAction - sprwadza czy username i password do czegos pasuja
// Jezeli nie to wyswietla komunikat  aktualnie dane to admin admin
// registerButton przechodzi do sceny z rejestracja
//

package sample.Controllers;

import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;


public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML

    private Label errorLabel;


    FunctionsButtonController functionsButtonController = new FunctionsButtonController();
    @FXML // Przycisk zalogowania sprawdza usernameField i passwordField i loguje do maina
    private void handleButtonAction(ActionEvent event) throws IOException {

        if ( usernameField.getText().equals("admin") && passwordField.getText().equals("admin")) {
           functionsButtonController.funtionFirstController(event);

        }
        else
            errorLabel.setVisible(true);
    }




    @FXML
    void registerButton(ActionEvent event) throws IOException {
        Parent registerParent = FXMLLoader.load(getClass().getResource("../View/RegisterPane.fxml"));
        NewSceneClass newScene = new NewSceneClass();
       newScene.newScene(event,registerParent);
    }
}


