package ru.cemetery.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "places")
public class Places {
    @Id
    private String id;
    private Date placeDate;
    private GeoJsonPoint location;
    private int capacity;
    private double sizePlace;
    private Boolean status;
}
