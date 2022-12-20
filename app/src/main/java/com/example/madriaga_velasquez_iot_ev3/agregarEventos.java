package com.example.madriaga_velasquez_iot_ev3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class agregarEventos extends AppCompatActivity {
    private TextView evento;
    private Spinner importancia;
    private EditText titulo, lugar, observaciones, fecha, aviso;
    private Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void referencias(){
        titulo = findViewById(R.id.etTitulo);
        lugar = findViewById(R.id.etLugar);
        observaciones = findViewById(R.id.etObservaciones);
        fecha = findViewById(R.id.etFecha);
        aviso = findViewById(R.id.etAviso);
        importancia = findViewById(R.id.spnInportancia);



    }
}
