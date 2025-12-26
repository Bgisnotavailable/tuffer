package hellofx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    private Label label;

    @FXML
    private void onHelloClick() {
        label.setText("Hello JavaFX!");
    }
}
