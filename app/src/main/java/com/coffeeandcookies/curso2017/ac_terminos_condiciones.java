package com.coffeeandcookies.curso2017;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

/**
 * Created by Gonzalo on 24/05/2017.
 */

public class ac_terminos_condiciones extends AppCompatActivity
{
    CheckBox checkBox_acepto;
    Button button_seguir;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_terminos_condiciones);
        buscarIds();
        setearEventos();
        //button_seguir.setEnabled(checkBox_acepto.isChecked());
        if (checkBox_acepto.isChecked())
        {
            button_seguir.setVisibility(View.VISIBLE);
        }
        else
        {
            button_seguir.setVisibility(View.GONE);
        }
    }

    void buscarIds()
    {
        checkBox_acepto = (CheckBox)findViewById(R.id.checkBox_acepto);
        button_seguir = (Button)findViewById(R.id.button_seguir);
    }

    void setearEventos()
    {
        button_seguir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
               if (checkBox_acepto.isChecked())
               {
                   Toast.makeText(ac_terminos_condiciones.this, "Acepto, podes seguir!", Toast.LENGTH_SHORT).show();
                   Intent intento = new Intent(ac_terminos_condiciones.this,ac_clasificacion.class);
                   startActivity(intento);
               }
               else
               {
                   Toast.makeText(ac_terminos_condiciones.this, "No aceptaste!!", Toast.LENGTH_SHORT).show();
               }
            }
        });

        checkBox_acepto.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean activado) {

                /*if (activado)
                {
                    button_seguir.setEnabled(true);
                }
                else
                {
                    button_seguir.setEnabled(false);
                }*/
                //button_seguir.setEnabled(activado);
                if (activado)
                {
                    button_seguir.setVisibility(View.VISIBLE);
                }
                else
                {
                    button_seguir.setVisibility(View.GONE);
                }
            }
        });
    }
}
