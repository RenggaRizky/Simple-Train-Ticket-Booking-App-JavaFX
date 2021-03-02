package trainticketapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private BorderPane bpLogin;

    @FXML
    private Button btnLogin;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void goToMainMenu(ActionEvent actionEvent) throws IOException {

        /**
         *  Pindah Ke scene main menu
         */

        Stage stage = (Stage) btnLogin.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("mainmenu.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

}
