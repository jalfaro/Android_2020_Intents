package com.julioalfaro.intentejemplo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class ParametrosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parametros_layout);

        if (getIntent().hasExtra("nombre")) {
            Toast.makeText(this, "El nombre es " + getIntent().getExtras().getString("nombre"), Toast.LENGTH_LONG).show();
        }
    }
}
