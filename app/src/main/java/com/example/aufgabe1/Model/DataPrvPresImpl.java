package com.example.aufgabe1.Model;

import android.widget.CheckBox;

import com.example.aufgabe1.Activities.DataPrivacy;
import com.example.aufgabe1.Presenter.DataPrvPresenter;
import com.example.aufgabe1.View.DataPrvView;
import com.example.aufgabe1.View.RegisterView;

public class DataPrvPresImpl implements DataPrvPresenter {

    DataPrvView mDataPrivacy;
    //Hier die Checkboxen abfragen rein
    CheckBox checkBox1, checkBox2;


    @Override
    public boolean checkedBoxes() {
        return false;
    }
}
