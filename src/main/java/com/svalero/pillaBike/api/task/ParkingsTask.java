package com.svalero.pillaBike.api.task;

import com.svalero.pillaBike.api.model.Parking;
import com.svalero.pillaBike.api.service.PillaBikeService;
import io.reactivex.functions.Consumer;
import javafx.concurrent.Task;
import javafx.scene.control.ProgressIndicator;


public class ParkingsTask extends Task {

    public Consumer<Parking> userParking;
//    private ProgressIndicator progressIndicator; //Para usar el indicador

    public ParkingsTask(Consumer<Parking> userParking) {
        this.userParking = userParking;
//        this.progressIndicator = progressIndicator;
    }

    @Override
    protected Integer call() throws Exception {
//        this.progressIndicator.setVisible(true); //Hacemos visible el Indicador para traernos los datos

        PillaBikeService pillaBikeService = new PillaBikeService();
        pillaBikeService.getParkings().subscribe(userParking);

        return null;
    }
}
