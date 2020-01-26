package com.ovais.khareedaari;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.strictmode.IntentReceiverLeakedViolation;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void towardRegister(View view) {
        Intent intent=new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }

    public void towardsHome(View view) {

        Intent intent=new Intent(this,HomeActivity.class);
        startActivity(intent);
    }
}
