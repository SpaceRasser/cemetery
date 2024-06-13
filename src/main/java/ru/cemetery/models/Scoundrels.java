package ru.cemetery.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "scoundrels")
public class Scoundrels {
    @Id
    private String id;
    @Indexed
    private String name;
    @Indexed
    private String lastName;
    @Indexed
    private String patronymicName;
    private Date birthDate;
    @Indexed
    private Date deathDate;
    private Boolean status;
}
