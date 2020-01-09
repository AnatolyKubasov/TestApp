package com.example.aufgabe1.Model;

import android.text.TextUtils;
import android.widget.EditText;

import com.example.aufgabe1.Presenter.AddrDataPresenter;
import com.example.aufgabe1.R;
import com.example.aufgabe1.View.AddrDataView;

public class AddrDataPresImpl implements AddrDataPresenter {


    AddrDataView mAddrDataView;
    public AddrDataPresImpl(AddrDataView persDataView){ this.mAddrDataView=persDataView; }

    @Override
    public void performAddrData(String street, String number, String zip, String city, String country) {

        if(TextUtils.isEmpty(street) || TextUtils.isEmpty(number) || TextUtils.isEmpty(zip) || TextUtils.isEmpty(city) || TextUtils.isEmpty(country)){

            mAddrDataView.addrDataValidation();
        }
        else{
            mAddrDataView.addrDataSuccess();
        }

    }


}
