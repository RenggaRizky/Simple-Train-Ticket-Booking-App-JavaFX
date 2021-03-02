package trainticketapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Station {

    public ObservableList<String> stationList = FXCollections.observableArrayList(


            "Bogor",
            "Cilebut",
            "Bojong Gede",
            "Citayam",
            "Depok",
            "Depok Baru",
            "Pondok Cina",
            "Lenteng Agung",
            "Tanjung Barat",
            "Pasar Minggu",
            "Pasar Minggu Baru",
            "Duren Kalibata",
            "Cawang",
            "Tebet",
            "Manggarai"

    );

    public ObservableList<String> classList = FXCollections.observableArrayList(
            "Eksekutif / A",
            "Ekonomi / B",
            "Bisnis / C"
    );

    public ObservableList<String> seatnumList = FXCollections.observableArrayList(
            "A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9", "A10",
            "B1", "B2", "B3", "B4", "B5", "B6", "B7", "B8", "B9", "B10",
            "C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "C10"
    );


}
