// Controller do sceny z pierwsza funkcjonalnoscia
// funtionFirstController functionSecondController functionThirdController  to bedzie przechodzenie pomiedzy scenami
// backButtonUse powrot do logowania
// loadButtonInAction laduje liste IP ktora lacza sie z karta sieciowa
// do zrobienia funkcja CHECK ktora pobiera wcisniety adres i wyswietla info

package sample.Controllers;


import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import java.io.IOException;



public class MainController {
    private ObservableList<String> obList1;
    @FXML
    private ListView<String> listIp;

    @FXML
    private TextArea textAreaIp;
    FunctionsButtonController functionsButtonController = new FunctionsButtonController();

    @FXML
    void funtionFirstController(ActionEvent event) {
        functionsButtonController.funtionFirstController(event);
    }
    @FXML
    void functionSecondController(ActionEvent event) {
      functionsButtonController.functionSecondController(event);
    }

    @FXML
    void functionThirdController(ActionEvent event) {
        functionsButtonController.functionThirdController(event);
    }
    @FXML
    void loadButtonInAction() throws IOException {
        ListUpdateClass listUpdateClass = new ListUpdateClass();
        listUpdateClass.Update(listIp);
    }
    @FXML
    public void backButtonUse(ActionEvent event) throws IOException {
        Parent backToLogin = FXMLLoader.load(getClass().getResource("../View/LoginPane.fxml"));
        NewSceneClass newScene = new NewSceneClass();
        newScene.newScene(event,backToLogin);
    }

}
