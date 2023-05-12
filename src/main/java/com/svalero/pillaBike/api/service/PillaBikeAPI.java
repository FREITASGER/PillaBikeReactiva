package com.svalero.pillaBike.api.service;

import com.svalero.pillaBike.api.model.Parking;
import io.reactivex.Observable;

import retrofit2.http.GET;

public interface PillaBikeAPI {

    @GET("/parkings")
    Observable<Parking> getInformationParking();
}