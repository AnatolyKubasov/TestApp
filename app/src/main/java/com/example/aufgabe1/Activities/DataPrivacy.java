package com.example.aufgabe1.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aufgabe1.R;
import com.example.aufgabe1.View.DataPrvView;

public class DataPrivacy extends AppCompatActivity implements DataPrvView {

    Button btnAccept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dataprivacy);

        defineButton();
        btnAccept = findViewById(R.id.btnDPaccept);
    }

    public void defineButton() {
        findViewById(R.id.btnDPaccept).setOnClickListener(buttonClickListener);

    }

    public View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btnDPaccept:
                    startActivity(new Intent(DataPrivacy.this, FirstLoginView.class));
                    break;
                case R.id.btGoToReg:
                    //mRegisterPresenter.moveToRegisterView();
                    //moveToRegPage();

                    break;
            }
        }
    };

    @Override
    public void acceptAll() {

    }
}
