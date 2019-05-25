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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class LoginController {

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
    @FXML // Przycisk zalogowania sprawdza usernameField i passwordField i loguje do maina
    private void handleButtonAction(ActionEvent event) throws IOException {
        serverConnect.DBConnect();
        query = "select user_nick,user_password from 30712964_test.users where user_nick ='"+usernameField.getText() +"';";
        String username =null;
        String password= null;
        try {
            statement = serverConnect.connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                 username = rs.getString("user_nick");
                 password = rs.getString("user_password");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(query);
        System.out.println(username);
        System.out.println(password);


        if ( usernameField.getText().equals(username) && passwordField.getText().equals(password)) {
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


