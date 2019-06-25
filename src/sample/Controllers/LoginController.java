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
import sample.SceneExtras.AlertWindow;
import sample.SceneExtras.NewSceneClass;
import sample.ServerClass.ServerConnect;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class LoginController {

    AlertWindow alertWindow = new AlertWindow();

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML

    private Label errorLabel;


    private String query;
    private static ServerConnect serverConnect = new ServerConnect();
    private Statement statement;
    FunctionsButtonController functionsButtonController = new FunctionsButtonController();

    public LoginController() throws IOException {
    }

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        serverConnect.DBConnect();
        query = "select * from 30712964_test.users where user_email ='"+usernameField.getText() +"';";
        String username =null;
        String password= null;
        String email = null;
        try {
            statement = serverConnect.connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                 username = rs.getString("user_nick");
                 password = rs.getString("user_password");
                 email = rs.getString("user_email");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
   ;


        if ( usernameField.getText().equals(email) && passwordField.getText().equals(password)) {
            alertWindow.setAlert("Witaj " + username + "\n Zalogowano Cie pomyslnie" );
           functionsButtonController.funtionFirstController(event);

        }
        else
        alertWindow.setAlert("Haslo badz login niepoprawne");
    }




    @FXML
    void registerButton(ActionEvent event) throws IOException {
        Parent registerParent = FXMLLoader.load(getClass().getResource("../View/RegisterPane.fxml"));
        NewSceneClass newScene = new NewSceneClass();
       newScene.newScene(event,registerParent);
    }
}


