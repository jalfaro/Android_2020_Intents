package com.julioalfaro.intentejemplo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FormularioActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnCerrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulario_layout);
        btnCerrar = findViewById(R.id.btnFinalizar);
        btnCerrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        setResult(101, getIntent().putExtra("estado", "Exitoso"));
        finish();
    }
}
