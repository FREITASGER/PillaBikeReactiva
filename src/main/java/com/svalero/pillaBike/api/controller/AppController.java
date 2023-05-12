package com.svalero.pillaBike.api.controller;

import com.svalero.pillaBike.api.model.Parking;
import com.svalero.pillaBike.api.task.ParkingsTask;
import io.reactivex.functions.Consumer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;


public class AppController {

    public Button btShowParkings;
    public TextArea parkingsArea;

    public List<Parking> parkings;

    private ParkingsTask parkingsTask;

    @FXML
    public void showAllParkings(ActionEvent event) {
        this.parkings = new ArrayList<>();
        parkingsArea.setText("");

        Consumer<Parking> user = (parking -> {
            String previousText;
            previousText = parkingsArea.getText() + "\n";

            this.parkingsArea.setText(parkingsArea.getText() + "\n" + "ID" + parking.getId() + "Name" + parking.getName());
        });

        parkingsTask = new ParkingsTask(user);
        new Thread(parkingsTask).start();

    }
}
