package com.example.madriaga_velasquez_iot_ev3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class registrousuario extends AppCompatActivity {

    EditText username, password, repassword, preguntasecreta, respuesta;
    Button signup, signin;
    DBhelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.etUsuario);
        password = (EditText) findViewById(R.id.etContrasena);
        repassword = (EditText) findViewById(R.id.etContrasenaConfirm);
        preguntasecreta = (EditText) findViewById(R.id.etPreguntaSecreta);
        respuesta = (EditText) findViewById(R.id.etRespuesta);
        signup = (Button) findViewById(R.id.btnGuardar);
        signin = (Button) findViewById(R.id.btnIngresar);
        DB = new DBhelper(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if(user.equals("")||pass.equals("")||repass.equals(""))
                    Toast.makeText(registrousuario.this, "Por favor ingrese todos los campos.", Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(repass)){
                        Boolean checkuser = DB.checkusername(user);
                        if(checkuser==false){
                            Boolean insert = DB.insertData(user, pass);
                            if(insert==true){
                                Toast.makeText(registrousuario.this, "Registro exitoso !", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(registrousuario.this, "Registro fállido.", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(registrousuario.this, "El usuario ingresado ya existe, haga login !", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(registrousuario.this, "Las contraseñas no coinciden.", Toast.LENGTH_SHORT).show();
                    }
                } }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}