package com.example.aufgabe1.Model;

import android.widget.CheckBox;

import com.example.aufgabe1.Activities.DataPrivacy;
import com.example.aufgabe1.Presenter.DataPrvPresenter;
import com.example.aufgabe1.View.DataPrvView;
import com.example.aufgabe1.View.RegisterView;

public class DataPrvPresImpl implements DataPrvPresenter {

    DataPrvView mDataPrivacy;
    public DataPrvPresImpl(DataPrivacy dataPrivacy) {this.mDataPrivacy=dataPrivacy;}

    @Override
    public boolean checkedBoxes() {
        return false;
    }
}
