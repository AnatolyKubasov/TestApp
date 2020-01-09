package com.example.aufgabe1.View;

public interface PersDataView {

    void perDataValidation();
    void persDataSuccess();
    void persDataError();

    String getGender();
    String getFirstname();
    String getLastname();
    String getBirthday();
    String getPhone();
}
