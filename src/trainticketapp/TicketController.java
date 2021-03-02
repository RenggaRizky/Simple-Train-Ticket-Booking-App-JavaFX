package trainticketapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.ResourceBundle;

public class TicketController implements Initializable {

    @FXML
    private Label lblName;

    @FXML
    private Label lblBookingDate;

    @FXML
    private Label lblTo;

    @FXML
    private Label lblFrom;

    @FXML
    private Label lblPrice;

    @FXML
    private Label lblId;

    @FXML
    private Label lblPurchaseDate;

    @FXML
    private Label lblClass;

    @FXML
    private Label lblSeatNum;

    @FXML
    private Button btnPreviousPage;

    @FXML
    private Label lblTrainCode;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        /**
         *  Membuat random nomor seri kereta dengan huruf dan angka
         */

        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";

        String alphanumeric = alphabet + numbers;

        StringBuilder stringBuilderTrainCode = new StringBuilder();
        Random random = new Random();

        int lengthTrainCode = 5;

        for (int x = 0; x < lengthTrainCode ; x++){

            int index = random.nextInt(alphanumeric.length());
            char randomChar = alphanumeric.charAt(index);

            stringBuilderTrainCode.append(randomChar);
        }

        String trainCode = String.valueOf(stringBuilderTrainCode);
        lblTrainCode.setText(trainCode);

        /**
         *  Membuat random ID pembeli dengan angka
         */

        StringBuilder stringBuilderIdUser = new StringBuilder();
        long lengthIdUser = 18;

        for (int y = 0; y < lengthIdUser; y++){

            int index = random.nextInt(numbers.length());
            char randomChar = numbers.charAt(index);
            stringBuilderIdUser.append(randomChar);
        }

        String idUser = String.valueOf(stringBuilderIdUser);
        lblId.setText(idUser);

        /**
         *  Mencetak tanggal pembelian tiket
         */

        LocalDateTime purchaseDate = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(("dd-MM-yyyy HH:mm"));
        String formattedPurchaseDate = purchaseDate.format(dateTimeFormatter);
        lblPurchaseDate.setText(formattedPurchaseDate);


    }



    public void setText(String name, String from, String to, String date, String classTicket, String seatNum, String totalPrice){

        /**
         *  mencetak teks dari parameter ke label
         */

        this.lblName.setText(name.toUpperCase());
        this.lblBookingDate.setText(date);
        this.lblFrom.setText(from.toUpperCase());
        this.lblTo.setText(to.toUpperCase());
        this.lblPrice.setText(totalPrice);
        this.lblClass.setText(classTicket.toUpperCase());
        this.lblSeatNum.setText(seatNum);




    }

    public void backToMainMenu(ActionEvent actionEvent) throws IOException {

        /**
         *  Kembali ke main menu
         */

        Stage stage = (Stage) btnPreviousPage.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("mainmenu.fxml"));;
        stage.setScene(new Scene(root));
        stage.show();
    }
}
