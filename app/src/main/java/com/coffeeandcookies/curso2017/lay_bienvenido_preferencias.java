package com.coffeeandcookies.curso2017;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Gonzalo on 31/05/2017.
 */

public class lay_bienvenido_preferencias extends AppCompatActivity
{
    TextView textView_nombre;
    Button button_salir;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bienvenido);
        findViews();
        setEvents();
        String nombre = getIntent().getExtras().getString("nombre");
        textView_nombre.setText(nombre);
    }
    void findViews()
    {
        textView_nombre = (TextView)findViewById(R.id.textView_nombre);
        button_salir = (Button) findViewById(R.id.button_salir);
    }

    void setEvents()
    {
        button_salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                SharedPreferences misPreferencias = getSharedPreferences("usuario", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = misPreferencias.edit();
                editor.clear();
                editor.commit();
                finish();
            }
        });
    }

}
