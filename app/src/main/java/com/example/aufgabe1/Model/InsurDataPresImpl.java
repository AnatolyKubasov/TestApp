package com.example.aufgabe1.Model;

import com.example.aufgabe1.Presenter.InsurDataPresenter;
import com.example.aufgabe1.View.InsurDataView;

public class InsurDataPresImpl implements InsurDataPresenter {

    InsurDataView mInsurDataView;
    public InsurDataPresImpl(InsurDataView persDataView){ this.mInsurDataView=persDataView; }
}
