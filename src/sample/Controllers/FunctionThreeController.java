


package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.util.Scanner;

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


     FunctionsButtonController functionsButtonController = new FunctionsButtonController();

    @FXML
    void functionSecondController(ActionEvent event) {

    }

    @FXML
    void functionThirdController(ActionEvent event) throws IOException {
        functionsButtonController.functionThirdController(event);
    }

    @FXML
    void funtionFirstController(ActionEvent event) throws IOException {
        functionsButtonController.funtionFirstController(event);
    }

    @FXML
    void backButtonApp(ActionEvent event) throws IOException {
        functionsButtonController.backButtonController(event);
    }

    @FXML
    void checkButtonApp(ActionEvent event) throws IOException {
        String[] cmdarray = {"ipconfig", "-all"};
        Process process = Runtime.getRuntime().exec(cmdarray);
        Scanner sc = new Scanner(process.getInputStream());
        sc.useDelimiter("\\A");

        informationArea.clear();
        informationArea.appendText(sc.next());
    }
}
