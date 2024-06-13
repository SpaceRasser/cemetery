package ru.cemetery.exception;

public class CustomersCollectionException extends Exception {
    private static final long serialVersionUID = 1L;

    public CustomersCollectionException(String message) {
        super(message);
    }

    public static String NotFoundException(String id) {
        return "Пользователь с идентификатором " + id + " не найден!";
    }

    public static String CustomersAlreadyExists(){
        return "Такой пользователь уже существует!";
    }
}
