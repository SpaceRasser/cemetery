package ru.cemetery.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "PlaceOfBuried")
public class PlaceOfBuried {
    @Id
    private String id;
    @DBRef
    private List<Places> places;
    @DBRef
    private List<Scoundrels> scoundrels;
    private Boolean status;
}
