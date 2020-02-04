package com.julioalfaro.intentejemplo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnop1, btnop2, boton3;
    private EditText txtNombre;
    public static final int FORMULARIO = 123;
    public static final int MARCAR = 134;
    public static final int PARAMETROS = 145;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnop1 = findViewById(R.id.btnop1);
        btnop2 = findViewById(R.id.btnop2);
        boton3 = findViewById(R.id.btnop3);
        txtNombre = findViewById(R.id.txtNombre);
        btnop1.setOnClickListener(this);
        btnop2.setOnClickListener(this);
        boton3.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ((requestCode == FORMULARIO) && (resultCode == 101)) {
            if (data.hasExtra("estado")) {
                Toast.makeText(this, "Se termino la actividad formulario de forma " + data.getExtras().getString("estado"), Toast.LENGTH_LONG).show();
            }
        } else if (requestCode == MARCAR) {
            Toast.makeText(this, "Se termino la actividad marcado ", Toast.LENGTH_LONG).show();
        } else if (requestCode == PARAMETROS) {
            Toast.makeText(this, "Se termino la actividad parametros ", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        if (v.getId() == R.id.btnop1) {
            //Abrir Intent Explicito, es decir una Actividad que yo cree
            intent = new Intent(this, FormularioActivity.class);
            startActivityForResult(intent, FORMULARIO);
        } else if (v.getId() == R.id.btnop2) {
            //Abrir un Intent Implicito
           intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:44445555"));
           startActivityForResult(intent, MARCAR );
        }else if (v.getId() == R.id.btnop3) {
            intent = new Intent (this, ParametrosActivity.class);
            intent.putExtra("nombre", txtNombre.getText().toString());
            startActivityForResult(intent, PARAMETROS);
        }
    }


}
