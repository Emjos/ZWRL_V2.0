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
import javafx.scene.text.Text;

import java.io.IOException;
import java.sql.*;

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

    @FXML
    private TextField emailText;

    @FXML
    private Text istnieje;

    @FXML
    private Text nieistnieje;



    private String query;
    private String procedure;
    private static ServerConnect serverConnect = new ServerConnect();



    public void backButtonUse(ActionEvent event) throws IOException {
        Parent backToLogin = FXMLLoader.load(getClass().getResource("../View/LoginPane.fxml"));
        NewSceneClass newScene = new NewSceneClass();
        newScene.newScene(event,backToLogin);
    }


    public void registrykButtonInUse(ActionEvent event){
        serverConnect.DBConnect();

        procedure = "{call 30712964_test.look_for_user(?)}";
        try {
            CallableStatement stmt = serverConnect.connection.prepareCall(procedure);
            stmt.setString(1, userButton.getText());
            ResultSet rs = stmt.executeQuery();
            int check = 0;
            while (rs.next()) {
                check++;
            }
            if (check == 0) {
                System.out.println("uzytkownik " + userButton.getText() + " nie istnieje");
                procedure = "{call 30712964_test.create_new_user(?,?,?)}";
                PreparedStatement stmt2 = serverConnect.connection.prepareStatement(procedure);
                stmt2.setString(1, userButton.getText());
                stmt2.setString(2, passwordButton.getText());
                stmt2.setString(3, emailText.getText());
                stmt2.executeUpdate();
                System.out.println("Data Added Successfully");
                nieistnieje.setVisible(true);
                istnieje.setVisible(false);
                nieistnieje.setText("Data Added Successfully");


            }
            else if (check != 0) {
                istnieje.setText("uzytkownik " + userButton.getText() + " istnieje");
                istnieje.setVisible(true);
                nieistnieje.setVisible(false);


                System.out.println("uzytkownik " + userButton.getText() + " istnieje");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
