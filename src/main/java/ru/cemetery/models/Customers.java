package ru.cemetery.models;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "customers")
public class Customers
{
    @Id
    private String id;
    @Indexed
    @NotNull(message = "Введите имя!")
    private String name;
    @Indexed
    @NotNull(message = "Введите фамилию!")
    private String lastName;
    @Indexed
    @NotNull(message = "Введите отчество!")
    private String patronymicName;
    @NotNull(message = "Введите дату рождения!")
    private Date birthDate;
    @Indexed
    @NotNull(message = "Введите номер телефона!")
    private String phone;
    @Indexed
    private String email;
    private Boolean role;
}
