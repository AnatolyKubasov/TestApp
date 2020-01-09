package com.example.aufgabe1.View;

public interface RegisterView {

    void registerValidation();
    void registerSuccess();
    void registerError();

    String getRegMail();
    String getRegPassword();

}
