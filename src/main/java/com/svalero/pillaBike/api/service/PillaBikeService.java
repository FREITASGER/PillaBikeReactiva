package com.svalero.pillaBike.api.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.svalero.pillaBike.api.model.Parking;
import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class PillaBikeService {

    private String BASE_URL = "http://localhost:8081";

    private PillaBikeAPI pillaBikeAPI;

    public PillaBikeService() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Gson gsonParser = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gsonParser))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        this.pillaBikeAPI = retrofit.create(PillaBikeAPI.class);
    }

    public Observable<Parking> getParkings() {
        return this.pillaBikeAPI.getInformationParking().flatMapIterable(parking -> parking);
    }
}
