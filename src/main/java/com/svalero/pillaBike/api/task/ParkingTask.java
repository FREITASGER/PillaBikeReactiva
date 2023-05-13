package com.svalero.pillaBike.api.task;

import com.svalero.pillaBike.api.model.Parking;
import com.svalero.pillaBike.api.service.PillaBikeService;
import io.reactivex.functions.Consumer;
import javafx.concurrent.Task;

public class ParkingTask extends Task{

    private Consumer<Parking> userParking;
    private long id;


    public ParkingTask(Consumer<Parking> parkingId, long id) {
        this.userParking = parkingId;
        this.id = id;
    }

    @Override
    protected Object call() throws Exception {

        PillaBikeService pillaBikeService = new PillaBikeService();
        pillaBikeService.getParking(id).subscribe(userParking);

        return null;
    }
}
