package trainticketapp;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainMenuController implements Initializable {


    @FXML
    private AnchorPane apMainMenu;

    @FXML
    private TextField tfName;

    @FXML
    private Button btnPreviousPage;

    @FXML
    private Button btnBookTicket;

    @FXML
    private ComboBox<String> cbTo;

    @FXML
    private ComboBox<String> cbFrom;

    @FXML
    private ComboBox<String> cbClass;

    @FXML
    private ComboBox<String> cbSeatNum;

    @FXML
    private DatePicker dpBookingDate;

    Station station = new Station();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        /**
           Memasukan list stasiun ke combo box
         */

        cbFrom.setItems(station.stationList);
        cbFrom.setViewOrder(15);

        cbTo.setItems(station.stationList);
        cbTo.setViewOrder(15);

        /**
         *  Memasukan list kelas ke combo box
         */

        cbClass.setItems(station.classList);

        /**
         *  Memasukan list nomor kursi ke combobox
         */

        cbSeatNum.setItems(station.seatnumList);

        /**
         *  Membuat batas karakter yang bisa dimasukan di textfield
         */

        tfName.lengthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {

                if (newValue.intValue() > oldValue.intValue()){

                    if (tfName.getText().length() >= 30){

                        tfName.setText(tfName.getText().substring(0, 30));
                    }
                }
            }
        });

        /**
         *  Mengatur agar datepicker tidak bisa memilih waktu yang sudah berlalu / terlewat
         */

        dpBookingDate.setDayCellFactory(datePicker -> new DateCell() {
            public void updateItem(LocalDate date, boolean empty){
                super.updateItem(date, empty);
                LocalDate today = LocalDate.now();

                setDisable(empty || date.compareTo(today) < 0);
            }
        });

    }

    public void backToLoginPage(ActionEvent actionEvent) throws IOException {

        /**
         *   Kembali ke halaman login
         */

        Stage stage = (Stage) btnPreviousPage.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void bookTicket(ActionEvent actionEvent) {

        /**
         *  Pemilihan stasiun awal dan akhir di combo box
         */

        float distance;

        if (cbFrom.getValue() == "Bogor" && cbTo.getValue() == "Bogor"){
            notification();
        }else if (cbFrom.getValue() == "Bogor" && cbTo.getValue() == "Cilebut" || cbFrom.getValue() == "Bogor" && cbTo.getValue() == "Bojong Gede" || cbFrom.getValue() == "Bogor" && cbTo.getValue() == "Citayam" || cbFrom.getValue() == "Bogor" && cbTo.getValue() == "Depok" || cbFrom.getValue() == "Bogor" && cbTo.getValue() == "Depok Baru") {
            distance = 23.8f;
        } else if (cbFrom.getValue() == "Bogor" && cbTo.getValue() == "Pondok Cina" || cbFrom.getValue() == "Bogor" && cbTo.getValue() == "Lenteng Agung" || cbFrom.getValue() == "Bogor" && cbTo.getValue() == "Tanjung Barat") {
            distance = 33.3f;
        } else
            distance = 44.9f;

        if (cbFrom.getValue() == "Cilebut" && cbTo.getValue() == "Cilebut"){
            notification();
        }else if (cbFrom.getValue() == "Cilebut" && cbTo.getValue() == "Bogor" || cbFrom.getValue() == "Cilebut" && cbTo.getValue() == "Bojong Gede" || cbFrom.getValue() == "Cilebut" && cbTo.getValue() == "Citayam" || cbFrom.getValue() == "Cilebut" && cbTo.getValue() == "Depok" || cbFrom.getValue() == "Cilebut" && cbTo.getValue() == "Depok Baru" || cbFrom.getValue() == "Cilebut" && cbTo.getValue() == "Pondok Cina" || cbFrom.getValue() == "Cilebut" && cbTo.getValue() == "Lenteng Agung") {
            distance = 23.3f;
        } else if (cbFrom.getValue() == "Cilebut" && cbTo.getValue() == "Tanjung Barat" || cbFrom.getValue() == "Cilebut" && cbTo.getValue() == "Pasar Minggu" || cbFrom.getValue() == "Cilebut" && cbTo.getValue() == "Pasar Minggu Baru" || cbFrom.getValue() == "Cilebut" && cbTo.getValue() == "Duren Kalibata" || cbFrom.getValue() == "Cilebut" && cbTo.getValue() == "Cawang" || cbFrom.getValue() == "Cilebut" && cbTo.getValue() == "Tebet") {
            distance = 34.7f;
        } else
            distance = 37.4f;

        if (cbFrom.getValue() == "Bojong Gede" && cbTo.getValue() == "Bogor"){
            notification();
        }else if (cbFrom.getValue() == "Bojong Gede" && cbTo.getValue() == "Bogor" || cbFrom.getValue() == "Bojong Gede" && cbTo.getValue() == "Cilebut" || cbFrom.getValue() == "Bojong Gede" && cbTo.getValue() == "Citayam" || cbFrom.getValue() == "Bojong Gede" && cbTo.getValue() == "Depok" || cbFrom.getValue() == "Bojong Gede" && cbTo.getValue() == "Depok Baru" || cbFrom.getValue() == "Bojong Gede" && cbTo.getValue() == "Pondok Cina" || cbFrom.getValue() == "Bojong Gede" && cbTo.getValue() == "Lenteng Agung" || cbFrom.getValue() == "Bojong Gede" && cbTo.getValue() == "Tanjung Barat" || cbFrom.getValue() == "Bojong Gede" && cbTo.getValue() == "Pasar Minggu") {
            distance = 24.4f;
        } else if (cbFrom.getValue() == "Bojong Gede" && cbTo.getValue() == "Pasar Minggu Baru" || cbFrom.getValue() == "Bojong Gede" && cbTo.getValue() == "Duren Kalibata" || cbFrom.getValue() == "Bojong Gede" && cbTo.getValue() == "Cawang" || cbFrom.getValue() == "Bojong Gede" && cbTo.getValue() == "Tebet") {
            distance = 34.7f;
        } else
            distance = 37.4f;

        if (cbFrom.getValue() == "Citayam" && cbTo.getValue() == "Citayam") {
            notification();
        }else if (cbFrom.getValue() == "Citayam" && cbTo.getValue() == "Bogor" || cbFrom.getValue() == "Citayam" && cbTo.getValue() == "Cilebut" || cbFrom.getValue() == "Citayam" && cbTo.getValue() == "Bojong Gede" || cbFrom.getValue() == "Citayam" && cbTo.getValue() == "Depok" || cbFrom.getValue() == "Citayam" && cbTo.getValue() == "Depok Baru" | cbFrom.getValue() == "Citayam" && cbTo.getValue() == "Pondok Cina" || cbFrom.getValue() == "Citayam" && cbTo.getValue() == "Lenteng Agung" || cbFrom.getValue() == "Citayam" && cbTo.getValue() == "Tanjung Barat" || cbFrom.getValue() == "Citayam" && cbTo.getValue() == "Pasar Minggu" || cbFrom.getValue() == "Citayam" && cbTo.getValue() == "Pasar Minggu Baru" || cbFrom.getValue() == "Citayam" && cbTo.getValue() == "Duren Kalibata" || cbFrom.getValue() == "Citayam" && cbTo.getValue() == "Cawang") {
            distance = 23.9f;
        } else
            distance = 27.8f;

        if (cbFrom.getValue() == "Pondok Cina" && cbTo.getValue() == "Pondok Cina"){
            notification();
        }else if (cbFrom.getValue() == "Pondok Cina" && cbTo.getValue() == "Bogor") {
            distance = 26.4f;
        } else
            distance = 18.9f;

        if (cbFrom.getValue() == "Lenteng Agung" && cbTo.getValue() == "Lenteng Agung"){
            notification();
        }else if (cbFrom.getValue() == "Lenteng Agung" && cbTo.getValue() == "Bogor") {
            distance = 30.8f;
        } else
            distance = 23.3f;

        if (cbFrom.getValue() == "Tanjung Barat" && cbTo.getValue() == "Tanjung Barat"){
            notification();
        }
        if (cbFrom.getValue() == "Tanjung Barat" && cbTo.getValue() == "Bogor" || cbFrom.getValue() == "Tanjung Barat" && cbTo.getValue() == "Cilebut") {
            distance = 33.3f;
        } else
            distance = 21.4f;

        if (cbFrom.getValue() == "Pasar Minggu" && cbTo.getValue() == "Pasar Minggu"){
            notification();
        }else if (cbFrom.getValue() == "Pasar Minggu" && cbTo.getValue() == "Cilebut"){
            distance = 28.8f;
        } else if (cbFrom.getValue() == "Pasar Minggu" && cbTo.getValue() == "Bogor"){
            distance = 36.3f;
        } else
            distance = 24.4f;

        if (cbFrom.getValue() == "Pasar Minggu Baru" && cbTo.getValue() =="Pasar Minggu Baru"){
            notification();
        }else if (cbFrom.getValue() == "Pasar Minggu Baru" && cbTo.getValue() =="Cilebut" || cbFrom.getValue() == "Pasar Minggu Baru" && cbTo.getValue() == "Bojong Gede"){
            distance = 30.5f;
        } else if (cbFrom.getValue() =="Pasar Minggu Baru" && cbTo.getValue() =="Bogor"){
            distance = 38f;
        } else
            distance = 20.9f;

        if (cbFrom.getValue() == "Duren Kalibata" && cbTo.getValue() == "Duren Kalibata"){
            notification();
        }else if (cbFrom.getValue() == "Duren Kalibata" && cbTo.getValue() == "Cilebut" || cbFrom.getValue() == "Duren Kalibata" && cbTo.getValue() == "Bojong Gede"){
            distance = 32f;
        } else if (cbFrom.getValue() == "Duren Kalibata" && cbTo.getValue() == "Bogor"){
            distance = 39.5f;
        } else
            distance = 22.4f;

        if (cbFrom.getValue() == "Cawang" && cbTo.getValue() == "Cawang"){
            notification();
        }else if (cbFrom.getValue() == "Cawang" && cbTo.getValue() == "Cilebut" || cbFrom.getValue() == "Cawang" && cbTo.getValue() == "Bojong Gede" ){
            distance = 33.4f;
        } else if (cbFrom.getValue() == "Cawang" && cbTo.getValue() == "Bogor"){
            distance = 41f;
        } else
            distance = 23.9f;

        if (cbFrom.getValue() == "Tebet" && cbTo.getValue() == "Tebet"){
            notification();
        }else if (cbFrom.getValue() == "Tebet" && cbTo.getValue() == "Cilebut" || cbFrom.getValue() == "Tebet" && cbTo.getValue() == "Bojong Gede" || cbFrom.getValue() == "Tebet" && cbTo.getValue() == "Citayam" ){
            distance = 34.7f;
        } else if (cbFrom.getValue() == "Tebet" && cbTo.getValue() == "Bogor"){
            distance = 42.3f;
        } else
            distance = 20.1f;

        if (cbFrom.getValue() == "Manggarai" && cbTo.getValue() == "Manggarai"){
            notification();
        }else if (cbFrom.getValue() == "Manggarai" && cbTo.getValue() == "Bojong Gede" || cbFrom.getValue() == "Manggarai" && cbTo.getValue() == "Citayam"){
            distance = 33f;
        } else if (cbFrom.getValue() == "Manggarai" && cbTo.getValue() == "Bogor" || cbFrom.getValue() == "Manggarai" && cbTo.getValue() == "Cilebut"){
            distance = 44.9f;
        } else
            distance = 22.7f;

        if (cbFrom.getValue() == "Depok" && cbTo.getValue() == "Depok"){
            notification();
        }else
            distance = 22.7f;


        if (cbFrom.getValue() == "Depok Baru" && cbTo.getValue() == "Depok Baru"){
            notification();
        }else
            distance = 21f;

        /**
         *  Penentuan harga sesuai jarak
         */

        int price = 0;

        if (distance > 1 && distance <= 25) {
            price = price + 3000;
        } else if (distance > 25 && distance <= 35) {
            price = price + 4000;
        } else if (distance > 35) {
            price = price + 5000;
        }

        /**
         *  Penentuan harga sesuai kelas
         */

        int priceClass = 0;

        if (cbClass.getValue() == "Eksekutif / A") {
            priceClass = priceClass + (price * 3);
        } else if (cbClass.getValue() == "Ekonomi / B") {
            priceClass = priceClass + (price * 2);
        } else if (cbClass.getValue() == "Bisnis / C") {
            priceClass = priceClass + price;

        }

        if (tfName.getText() == null || cbClass.getValue() == null || cbSeatNum.getValue() == null || dpBookingDate.getValue() == null || cbFrom.getValue() == null || cbTo.getValue() == null ) {

            /**
             *  Jika data ada yang kosong maka muncul alert box
             */

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Semua data harus diisi dengan benar dan tidak boleh kosong");
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.showAndWait();


        } else {

            /**
             *  Jika data semua telah terisi maka muncul konfirmasi
             */

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Apakah anda yakin ingin memesan tiket ? ");
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {

                /**
                 *  Mengambil nilai yang ada di Main Menu
                 */

                String name = tfName.getText();
                LocalDate date = dpBookingDate.getValue();
                String from = cbFrom.getValue();
                String to = cbTo.getValue();
                String classTicket = cbClass.getValue();
                String seatNum = cbSeatNum.getValue();
                String totalPrice = String.valueOf(priceClass);

                /**
                 *  Mengganti format tanggal pemesanan
                 */

                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                String formattedBookingDate = date.format(dateTimeFormatter);

                /**
                 *  Load ticket.fxml lalu mencetak teks yang sudah diambil valuenya
                 */

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("ticket.fxml"));

                try {
                    loader.load();
                } catch (IOException e) {
                    Logger.getLogger(MainMenuController.class.getName()).log(Level.SEVERE, null, e);
                }

                TicketController ticketResult = loader.getController();
                ticketResult.setText(name, from, to, formattedBookingDate,classTicket,seatNum, totalPrice);

                Parent root = loader.getRoot();
                Stage stage = (Stage) btnBookTicket.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();

            }

        }
    }

    private void notification() {

        /**
         *  Jika memilih stasiun keberangkatan sama dengan stasiun tujuan, akan muncul alert box
         */

        Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Tidak bisa memilih stasiun tujuan yang sama dengan stasiun keberangkatan");
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == ButtonType.OK){
                cbTo.setValue(null);
            }
    }

}
