package com.coffeeandcookies.curso2017;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * Created by Gonzalo on 17/05/2017.
 */

public class Login extends AppCompatActivity
{
    //iria aca pero no...
    String palabra = "pepe1234";
    int num = 0;
    boolean accion = false;
    double numd = 4.3;


    Button miboton;
    EditText editText2;
    EditText editText3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_login);
        miboton = (Button)findViewById(R.id.button3);
        editText2 = (EditText)findViewById(R.id.editText2);
        editText3 = (EditText)findViewById(R.id.editText3);



        miboton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /*
                num = num +1 ;
                miboton.setText("Presione :"+num);
                Log.d("curso",miboton.getText().toString());
                */
               if (palabra.equals(editText3.getText().toString()))
               {
                   Toast.makeText(Login.this,"Login ok",Toast.LENGTH_SHORT).show();
                   Intent camion = new Intent(Login.this,Bienvenido.class);
                   camion.putExtra("nombreDelUsuario",editText2.getText().toString());
                   camion.putExtra("numero",4);
                   camion.putExtra("activado",true);
                   startActivity(camion);
               }
               else
               {
                   Toast.makeText(Login.this,"Incorrecto",Toast.LENGTH_SHORT).show();
               }

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        editText2.setText("");
        editText3.setText("");
    }

    int sumar(int n1, int n2)
    {
        return n1+n2;
    }
}
//aca no va codigo!