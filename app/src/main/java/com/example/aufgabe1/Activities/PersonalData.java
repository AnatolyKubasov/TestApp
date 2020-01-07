package com.example.aufgabe1.Activities;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aufgabe1.Model.PersDataPresImpl;
import com.example.aufgabe1.Network.DownloadCallback;
import com.example.aufgabe1.Network.NetworkFragment;
import com.example.aufgabe1.Presenter.PersDataPresenter;
import com.example.aufgabe1.Presenter.RegisterPresenter;
import com.example.aufgabe1.R;
import com.example.aufgabe1.View.PersDataView;

public class PersonalData extends AppCompatActivity implements PersDataView, DownloadCallback {

    String accesstoken;

    // Keep a reference to the NetworkFragment, which owns the AsyncTask object
    // that is used to execute network ops.
    private NetworkFragment networkFragment;

    // Boolean telling us whether a download is in progress, so we don't trigger overlapping
    // downloads with consecutive button clicks.
    private boolean downloading = false;

    EditText etrGender, etrFirstname, etrLastname, etrBirthday, etrPhone;
    PersDataPresenter mPersDataPresenter;

    Button btnPersonalNext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_data);

        mPersDataPresenter = new PersDataPresImpl(PersonalData.this);
        defineButton();
        btnPersonalNext= findViewById(R.id.btnPersonalNext);
        etrGender = findViewById(R.id.etGender);
        etrFirstname = findViewById(R.id.etPersonalName);
        etrLastname = findViewById(R.id.etPersonalSurName);
        etrBirthday = findViewById(R.id.etPersonalBD);
        etrPhone = findViewById(R.id.etPersonalPhone);


        Intent intent = getIntent();
        accesstoken = intent.getStringExtra(MainActivity.ACCESS_TOKEN);


        networkFragment = NetworkFragment.getInstance(getSupportFragmentManager(), "https://dev.api.digital-nursing-service.ucura.com/api/v1");
    }

    public void defineButton() {
        findViewById(R.id.btnPersonalNext).setOnClickListener(buttonClickListener);

    }

    public View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btnPersonalNext:
                    //String gender = .getText().toString();
                    String gender = etrGender.getText().toString();
                    String firstname = etrFirstname.getText().toString();
                    String lastname = etrLastname.getText().toString();
                    String birthday = etrBirthday.getText().toString();
                    String phone = etrPhone.getText().toString();
                    mPersDataPresenter.performPersData(gender, firstname, lastname, birthday, phone);

                    //Intent intent = new Intent(PersonalData.this, AddressData.class);
                    //intent.putExtra(MainActivity.ACCESS_TOKEN, accesstoken);
                    //startActivity(new Intent(PersonalData.this, AddressData.class));

                    break;
                case R.id.btGoToReg:
                    //mRegisterPresenter.moveToRegisterView();
                    //moveToRegPage();

                    break;
            }
        }
    };

    @Override
    public void perDataValidation() {
        Toast.makeText(getApplicationContext(),"Register Validation", Toast.LENGTH_LONG).show();

    }

    @Override
    public void persDataSuccess() {

        //Start download after click on register button
        startDownload(6);

        Toast.makeText(getApplicationContext(),"Register Success", Toast.LENGTH_LONG).show();
    }

    @Override
    public void persDataError() {

        Toast.makeText(getApplicationContext(),"Register Error", Toast.LENGTH_LONG).show();
    }

    private void startDownload(int t) {
        if (!downloading && networkFragment != null) {
            // Execute the async download.
            int downloadType = t;
            networkFragment.startDownload(downloadType);
            downloading = true;

        }
    }

    @Override
    public void updateFromDownload(Object result) {
        if (result == null) {
            Toast.makeText(getApplicationContext(), "No result", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Result : " + result.toString(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(PersonalData.this, AddressData.class);
            intent.putExtra(MainActivity.ACCESS_TOKEN, accesstoken);
            startActivity(intent);
        }

    }

    @Override
    public NetworkInfo getActiveNetworkInfo() {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        Toast.makeText(getApplicationContext(), "getActiveNetworkInfo : ", Toast.LENGTH_SHORT).show();
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo;
    }

    @Override
    public void onProgressUpdate(int progressCode, int percentComplete) {

        switch(progressCode) {
            // You can add UI behavior for progress updates here.
            case Progress.ERROR:
                Toast.makeText(getApplicationContext(), "ERROR : " + progressCode, Toast.LENGTH_SHORT).show();
                break;
            case Progress.CONNECT_SUCCESS:
                Toast.makeText(getApplicationContext(), "CONNECT_SUCCESS : " + progressCode, Toast.LENGTH_SHORT).show();
                break;
            case Progress.GET_INPUT_STREAM_SUCCESS:
                Toast.makeText(getApplicationContext(), "GET_INPUT_STREAM_SUCCESS : " + progressCode, Toast.LENGTH_SHORT).show();
                break;
            case Progress.PROCESS_INPUT_STREAM_IN_PROGRESS:
                Toast.makeText(getApplicationContext(), "PROCESS_INPUT_STREAM_IN_PROGRESS : " + progressCode, Toast.LENGTH_SHORT).show();
                break;
            case Progress.PROCESS_INPUT_STREAM_SUCCESS:
                Toast.makeText(getApplicationContext(), "PROCESS_INPUT_STREAM_SUCCESS : " + progressCode, Toast.LENGTH_SHORT).show();
                break;
        }

    }

    @Override
    public void finishDownloading() {
        downloading = false;
        if (networkFragment != null) {
            networkFragment.cancelDownload();
        }
    }

    //NEED
    @Override
    public String getGender() {
        EditText gender= findViewById(R.id.etGender);
        return gender.getText().toString();
    }

    @Override
    public String getFirstname() {
        EditText firstname= findViewById(R.id.etPersonalName);
        return firstname.getText().toString();
    }

    @Override
    public String getLastname() {
        EditText lastname= findViewById(R.id.etPersonalSurName);
        return lastname.getText().toString();

    }

    @Override
    public String getBirthday() {
        EditText birthday= findViewById(R.id.etPersonalBD);
        return birthday.getText().toString();
    }

    @Override
    public String getPhone() {
        EditText phone= findViewById(R.id.etPersonalPhone);
        return phone.getText().toString();
    }

    //Dont need
    @Override
    public String getMail() {
        return null;
    }

    @Override
    public String getRegMail() {
        return null;
    }

    @Override
    public String getRegPassword() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getAccesstoken() {
        return null;
    }

    @Override
    public String getNumber() {
        return null;
    }

    @Override
    public String getZip() {
        return null;
    }

    @Override
    public String getCity() {
        return null;
    }

    @Override
    public String getStreet() {
        return null;
    }

    @Override
    public String getCountry() {
        return null;
    }





}
