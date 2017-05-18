package com.coffeeandcookies.curso2017;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Gonzalo on 17/05/2017.
 */

public class Bienvenido extends AppCompatActivity
{
    String cajaRecibidaConElNombre;
    int cajaRecibidaConUnNumero;
    boolean cajaRecibidaConUnBool;

    TextView textView7;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bienvenido);
        textView7 = (TextView)findViewById(R.id.textView7);
        cajaRecibidaConElNombre = getIntent().getExtras().getString("nombreDelUsuario");
        cajaRecibidaConUnNumero = getIntent().getExtras().getInt("numero");
        cajaRecibidaConUnBool = getIntent().getExtras().getBoolean("activado");
        textView7.setText("cajaRecibidaConElNombre = "+cajaRecibidaConElNombre + " cajaRecibidaConUnNumero =  "+cajaRecibidaConUnNumero +" cajaRecibidaConUnBool = "+cajaRecibidaConUnBool);
    }
}
