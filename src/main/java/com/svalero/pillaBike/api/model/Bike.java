package com.svalero.pillaBike.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bike {

    private long id;
    private LocalDate buyDate;
    private boolean electric;
    private String description;
    private float price;
    private Parking parking;

}
