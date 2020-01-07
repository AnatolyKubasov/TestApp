package com.example.aufgabe1.Model;

import android.text.TextUtils;

import com.example.aufgabe1.Presenter.LoginPresenter;
import com.example.aufgabe1.View.LoginView;

public class PresenterImpl implements LoginPresenter {


    LoginView mLoginView;

    public PresenterImpl(LoginView loginView){
        this.mLoginView=loginView;
    }


    @Override
    public void performLogin(String userName, String password) {

        if(TextUtils.isEmpty(userName) || TextUtils.isEmpty(password)){

            mLoginView.loginValidation();
        }
        else{
            if(!userName.isEmpty()){
                mLoginView.loginSuccess();

            }
            else{
                mLoginView.loginError();
            }
        }

    }

}
