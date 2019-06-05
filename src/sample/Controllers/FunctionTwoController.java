package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import sample.Classes.ForFunctionTwo;
import sample.Classes.ListUpdateClass;

import java.io.IOException;

public class FunctionTwoController {

    @FXML
    private Button functionFirst;

    @FXML
    private Button functionSecond;

    @FXML
    private Button functionThird;

    @FXML
    private TextField ipPut;

    @FXML
    private TextArea toxic;

    @FXML
    private TextArea proxy;

    @FXML
    private TextArea spam;

    @FXML
    private Button checkButton;

    @FXML
    private Button backButton;


    FunctionsButtonController functionsButtonController = new FunctionsButtonController();


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
    void functionSecondController(ActionEvent event) throws IOException {
        functionsButtonController.functionSecondController(event);
    }

    public void check(ActionEvent event) throws IOException {


        String ip =ipPut.getText();
        ForFunctionTwo forFunctionTwo = new ForFunctionTwo();
        forFunctionTwo.check(ip);


        spam.setText(forFunctionTwo.getSpam());
        proxy.setText(forFunctionTwo.getProxy());
        toxic.setText(forFunctionTwo.getToxic());
    }


}
