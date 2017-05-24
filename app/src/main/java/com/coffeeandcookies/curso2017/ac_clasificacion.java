package com.coffeeandcookies.curso2017;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Gonzalo on 24/05/2017.
 */

public class ac_clasificacion extends AppCompatActivity
{
    Button button_marcar;
    RadioGroup rg_opciones;
    TextView tv_resultado;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_calificacion);
        buscarIds();
        setearEventos();


        RadioButton rb = (RadioButton)rg_opciones.getChildAt(2);
        rb.setChecked(true);
    }

    void buscarIds()
    {
         button_marcar  = (Button)findViewById(R.id.button_marcar);
         rg_opciones = (RadioGroup)findViewById(R.id.rg_opciones);
         tv_resultado = (TextView)findViewById(R.id.tv_resultado);
    }

    void setearEventos()
    {
        button_marcar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                int idSeleccionado =rg_opciones.getCheckedRadioButtonId();
                if (idSeleccionado>-1)
                {
                    RadioButton radioButton_seleccionado = (RadioButton)rg_opciones.findViewById(idSeleccionado);
                    String textoDelRadioButtonSeleccionado = radioButton_seleccionado.getText().toString();
                    tv_resultado.setText(textoDelRadioButtonSeleccionado);    
                }
                else
                {
                    Toast.makeText(ac_clasificacion.this, "No marcaste nada", Toast.LENGTH_SHORT).show();
                }
                
            }
        });
        rg_opciones.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int id)
            {

                RadioButton rb_seleccionado = (RadioButton)radioGroup.findViewById(id);
                tv_resultado.setText(rb_seleccionado.getText().toString());
                if (id == R.id.rb_malo)
                {
                    button_marcar.setVisibility(View.GONE);
                    tv_resultado.setEnabled(false);
                }
                else
                {
                    button_marcar.setVisibility(View.VISIBLE);
                    tv_resultado.setEnabled(true);
                }
            }
        });
    }

}
