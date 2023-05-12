package com.svalero.pillaBike.api.task;

import com.svalero.pillaBike.api.model.Parking;
import com.svalero.pillaBike.api.service.PillaBikeService;
import io.reactivex.functions.Consumer;
import javafx.concurrent.Task;



public class ParkingsTask extends Task<Integer> {

    public Consumer<Parking> userParking;

    public ParkingsTask(Consumer<Parking> userParking) {
        this.userParking = userParking;
    }

    @Override
    protected Integer call() throws Exception {

        PillaBikeService pillaBikeService = new PillaBikeService();
        pillaBikeService.getParkings().subscribe(userParking);
        return null;
    }
}
