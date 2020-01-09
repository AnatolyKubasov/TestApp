package com.example.aufgabe1.View;

public interface LoginView {

    void loginValidation();
    void loginSuccess();
    void loginError();

    String getAccesstoken();
    String getMail();
    String getPassword();

}
