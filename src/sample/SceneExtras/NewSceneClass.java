
//Klasa do tworzenia nowych scen
// Czyli przechodzenie po oknach
//Pobiera event ( czyli typ akcji i obiekt parent czyli cos co ma sciezke do nowego fxmla
//
package sample.SceneExtras;

import javafx.event.ActionEvent;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public  class NewSceneClass {


    public NewSceneClass() throws IOException {
    }


    public void newScene(ActionEvent event, Parent paneParent) {

        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.hide();
        appStage.setScene(new Scene(paneParent));


        appStage.setResizable(false);
        appStage.show();
    }


}
