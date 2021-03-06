// Controller do sceny z pierwsza funkcjonalnoscia
// funtionFirstController functionSecondController functionThirdController  to bedzie przechodzenie pomiedzy scenami
// backButtonUse powrot do logowania
// loadButtonInAction laduje liste IP ktora lacza sie z karta sieciowa
// do zrobienia funkcja CHECK ktora pobiera wcisniety adres i wyswietla info

package sample.Controllers;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import sample.Classes.ImportIpData;
import sample.Classes.ListUpdateClass;


import java.io.IOException;



public class MainController {



    @FXML
    private ListView<String> listIp;

    @FXML
    private TextArea textAreaIp;
    FunctionsButtonController functionsButtonController = new FunctionsButtonController();

    public MainController() throws IOException {
    }

    @FXML
    void funtionFirstController(ActionEvent event) throws IOException {

        functionsButtonController.funtionFirstController(event);
    }
    @FXML
    void functionSecondController(ActionEvent event) throws IOException {
      functionsButtonController.functionSecondController(event);
    }

    @FXML
    void functionThirdController(ActionEvent event) throws IOException {
        functionsButtonController.functionThirdController(event);
    }
    @FXML
    void loadButtonInAction() throws IOException {
        ListUpdateClass listUpdateClass = new ListUpdateClass();
        listUpdateClass.Update(listIp);

    }
    @FXML
    public void backButtonUse(ActionEvent event) throws IOException {
        functionsButtonController.backButtonController(event);
    }


    @FXML
    void listVievImport(ActionEvent event) {
        textAreaIp.clear();
        String ip;
        ip = listIp.getSelectionModel().getSelectedItem();
        ImportIpData importIpData = new ImportIpData();




        for (Object o : importIpData.Check(ip)) {
    textAreaIp.appendText(o.toString());
    textAreaIp.appendText("\n");
        }

        textAreaIp.setWrapText(true);



        }

        }






