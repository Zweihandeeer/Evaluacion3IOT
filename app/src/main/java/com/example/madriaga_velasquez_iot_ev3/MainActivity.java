package com.example.madriaga_velasquez_iot_ev3;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText username, password;
    private Button btnlogin;
    private DBhelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.etUsuario);
        password = (EditText) findViewById(R.id.etContrasena);
        btnlogin = (Button) findViewById(R.id.btnIngresar);
        DB = new DBhelper(this);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("")||pass.equals(""))
                    Toast.makeText(MainActivity.this, "Por favor ingrese todos los campos", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.checkusernamepassword(user, pass);
                    if(checkuserpass==true){
                        Toast.makeText(MainActivity.this, "Login exitoso !", Toast.LENGTH_SHORT).show();
                        Intent intent  = new Intent(getApplicationContext(), menu.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(MainActivity.this, "Credenciales inválidas.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}