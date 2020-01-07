package com.example.aufgabe1.Model;
import android.text.TextUtils;
import com.example.aufgabe1.Presenter.RegisterPresenter;
import com.example.aufgabe1.View.RegisterView;



public class RegPresenterImpl implements RegisterPresenter {

    RegisterView mRegisterView;


    public RegPresenterImpl(RegisterView registerView){
        this.mRegisterView=registerView;
    }


    @Override
    public void performRegister(String userName, String password, String confirmPassword) {

        if(TextUtils.isEmpty(userName) || TextUtils.isEmpty(password) || TextUtils.isEmpty(confirmPassword)){

            mRegisterView.registerValidation();
        }
        else{

            if(password.equals(confirmPassword) && password.length() == 8){

                    //Put logic of fragment here

                    mRegisterView.registerSuccess();


                }
                else{
                mRegisterView.registerError();
            }
        }

    }



}
