package sample.SceneExtras;

import javafx.scene.control.Alert;

public class AlertWindow {
    public void setAlert(String dialog) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText(dialog);

        alert.showAndWait();
    }
}
