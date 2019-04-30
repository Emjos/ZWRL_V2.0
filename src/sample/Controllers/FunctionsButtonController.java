// To bedzie controller ktory bedzie umozliwial przechdozenie po oknach
// jako ze nie umiem zrobic tego na stale bede musial zaimportowac kod do kazdej z funkcji oddzielnie
// wiec oszczedzi to sporo miejsca, czasu i bedzie ladnie wygladac
// narazie po kliknieciu w konsoli wyswietla sie napis

package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class FunctionsButtonController {

    public void funtionFirstController(ActionEvent event)throws IOException{
        Parent mainPaneParent = FXMLLoader.load(getClass().getResource("../View/MainPane.fxml"));
        NewSceneClass newScene = new NewSceneClass();
        newScene.newScene(event,mainPaneParent);

    }
    public void functionSecondController(ActionEvent event){
        System.out.println("Funkcja druga");
    }


    public void functionThirdController(ActionEvent event) throws IOException {

        Parent backToLogin = FXMLLoader.load(getClass().getResource("../View/FunctionThreePane.fxml"));
        NewSceneClass newScene = new NewSceneClass();
        newScene.newScene(event,backToLogin);
    }
    public void backButtonController(ActionEvent event) throws IOException{
        Parent backToLogin = FXMLLoader.load(getClass().getResource("../View/LoginPane.fxml"));
        NewSceneClass newScene = new NewSceneClass();
        newScene.newScene(event,backToLogin);

    }

}
