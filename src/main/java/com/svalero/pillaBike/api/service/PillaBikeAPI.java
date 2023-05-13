package com.svalero.pillaBike.api.service;

import com.svalero.pillaBike.api.model.Parking;
import io.reactivex.Observable;

import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;

import java.util.List;

public interface PillaBikeAPI {

    @GET("/parkings")
    Observable<List<Parking>> getParkings();

    @GET("parkings/{id}")
    Observable<Parking> getParking(@Path("id") long id);
}
