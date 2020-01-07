package com.example.aufgabe1.Model;

import com.example.aufgabe1.Presenter.DashboardPresenter;
import com.example.aufgabe1.View.DashboardView;

public class DashboardPresImpl implements DashboardPresenter {

    DashboardView mDashboardView;
    public DashboardPresImpl(DashboardView dashboardView) {this.mDashboardView=dashboardView;}
}
