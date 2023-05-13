package com.svalero.pillaBike.api.controller;

import com.svalero.pillaBike.api.model.Parking;
import com.svalero.pillaBike.api.task.ParkingTask;
import com.svalero.pillaBike.api.task.ParkingsTask;
import io.reactivex.functions.Consumer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


import java.util.ArrayList;
import java.util.List;


public class AppController {
    @FXML
    private Button btShowParkings;
    @FXML
    private Button btParkingId;
    @FXML
    private TextArea parkingsArea;
//    @FXML
//    private ProgressIndicator piChargeData;
    @FXML
    private TextField tfName;
    @FXML
    private TextField tfCity;
    @FXML
    private TextField tfOpen;
    @FXML
    private TextField tfClose;
    @FXML
    private TextField tfFull;
    @FXML
    private TextField tfIdParking;

    private List<Parking> parkings;

    private ParkingsTask parkingsTask;
    private ParkingTask parkingTask;

    @FXML
    public void showAllParkings(ActionEvent event) {
        this.parkings = new ArrayList<>();
        parkingsArea.setText("");

        Consumer<Parking> user = (parking -> {
            String previousText;
            previousText = parkingsArea.getText() + "\n";

//            this.parkingsArea.setText(parkingsArea.getText() + "\n" + "ID: " + parking.getId() + " - Name: " + parking.getName() + " - City: " + parking.getName() + " - Open: " + parking.getOpen() + " - Close: " + parking.getClose() + " - Full: " + parking.isFull());
            this.parkingsArea.setText(parkingsArea.getText() + "\n" + "ID: " + parking.getId() + " - Name: " + parking.getName() + " - City: " + parking.getName() + " - Full: " + parking.isFull());
        });

        parkingsTask = new ParkingsTask(user);
        new Thread(parkingsTask).start();

    }

    @FXML
    public void detailsParking(ActionEvent event) {
        String idString = tfIdParking.getText();
        long id = Long.parseLong(idString);

//        long id = Long.parseLong(tfIdParking.getText());
        tfIdParking.clear();
        tfIdParking.requestFocus();;

        Consumer<Parking> userId = (parking -> {
            tfName.setText(parking.getName());
            tfCity.setText(parking.getCity());
            tfOpen.setText(parking.getOpen());
            tfClose.setText(parking.getClose());
            tfFull.setText(String.valueOf(parking.isFull()));
        });

        parkingTask = new ParkingTask(userId, id);
        new Thread(this.parkingsTask).start();

    }
}
