

package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.io.IOException;

public class FunctionThreeController {

    @FXML
    private Button functionFirst;

    @FXML
    private Button functionSecond;

    @FXML
    private Button functionThird;

    @FXML
    private Button backButton;

    @FXML
    private TextArea informationArea;

    @FXML
    private Button checkInfoButton;

    @FXML
    void functionSecondController(ActionEvent event) {

    }

    @FXML
    void functionThirdController(ActionEvent event) {

    }

    @FXML
    void funtionFirstController(ActionEvent event) {

    }

    @FXML
    void backButtonApp(ActionEvent event)throws IOException {
        Parent mainPaneParent = FXMLLoader.load(getClass().getResource("../View/MainPane.fxml"));
        NewSceneClass newScene = new NewSceneClass();
        newScene.newScene(event,mainPaneParent);
    }
}
