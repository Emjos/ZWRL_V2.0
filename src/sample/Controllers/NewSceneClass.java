
//Klasa do tworzenia nowych scen
// Czyli przechodzenie po oknach
//Pobiera event ( czyli typ akcji i obiekt parent czyli cos co ma sciezke do nowego fxmla
//
package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class NewSceneClass {
    void newScene(ActionEvent event, Parent paneParent) {
        Scene mainPaneScene = new Scene(paneParent);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.hide();
        appStage.setScene(mainPaneScene);

        appStage.setResizable(false);
        appStage.show();
    }


}
