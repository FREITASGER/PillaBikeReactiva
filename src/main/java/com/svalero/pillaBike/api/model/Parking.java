package com.svalero.pillaBike.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Parking {

    private long id;
    private String name;
    private String city;
    private String open;
    private String close;
    private boolean isFull;

}
