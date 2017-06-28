package com.coffeeandcookies.curso2017;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.activeandroid.query.Select;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gonzalo on 07/06/2017.
 */

public class lay_listado extends AppCompatActivity
{
    String elementos_dinamicos[];
    String nombre;
    RecyclerView contenedor_listado;
    Spinner spinner;
    Button button_ver;
    String elementos_dinamicos_recursos[];
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_listado);
        crearCasas();
        levantarComponentes();
        setearAdaptadorLista();
        setearAdaptadorSpinner();
        setearEventoSpinner();
        setearEventoBoton();
    }

    private void setearEventoBoton()
    {
        button_ver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                //int pos = spinner.getSelectedItemPosition();
                long id = 2;
                Casa casaPrueba = new Select().from(Casa.class).where("Id = ",id).executeSingle();
                if (casaPrueba!=null)
                {
                    Toast.makeText(lay_listado.this, "Se ha seleccionado el id: "+casaPrueba.getId(), Toast.LENGTH_SHORT).show();
                }
                //Toast.makeText(lay_listado.this, "Se ha seleccionado la opcion: "+elementos_dinamicos_recursos[pos], Toast.LENGTH_SHORT).show();
            }
        });
    }

    void setearEventoSpinner()
    {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l)
            {
                //Toast.makeText(lay_listado.this, "Opcion: "+elementos_dinamicos_recursos[pos], Toast.LENGTH_SHORT).show();
                if (pos == 0)
                {
                    crearCasas();
                    setearAdaptadorLista();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    void setearAdaptadorSpinner()
    {
        elementos_dinamicos = new String[2];

        elementos_dinamicos[0] = "Elemento 1";
        elementos_dinamicos[1] = "Elemento 2";

        elementos_dinamicos_recursos = getResources().getStringArray(R.array.valores_array);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, elementos_dinamicos_recursos);


        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adaptador);
    }

    private void setearAdaptadorLista()
    {
        List<Casa> casas = new Select().from(Casa.class).execute();
        AdaptadorCasas adaptadorCasas = new AdaptadorCasas(casas);
        contenedor_listado.setAdapter(adaptadorCasas);
    }

    private void levantarComponentes()
    {
        contenedor_listado = (RecyclerView)findViewById(R.id.listado);
        contenedor_listado.setLayoutManager(new LinearLayoutManager(lay_listado.this));
        spinner= (Spinner)findViewById(R.id.spinner);
        button_ver = (Button)findViewById(R.id.button_ver);
    }

    void crearCasas()
    {
        List<Casa> casas = new Select().from(Casa.class).execute();
        if (casas.size() == 0) {
            //listado de casas

            //una casa
            Casa casa = new Casa();
            casa.setCalle("salta");
            casa.setNumero(123);
            casa.setHabitaciones(3);
            casa.setOcupada(true);
            casa.setOwner("pepe grillo");
            casa.setBanios("1");
            long id = casa.save();
            Log.d("tp", "id: " + id);
            //otra casa
            Casa otraCasa = new Casa();
            otraCasa.setCalle("independencia");
            casa.setBanios("3");
            otraCasa.setNumero(456);
            otraCasa.setHabitaciones(9);
            otraCasa.setOcupada(false);
            otraCasa.setOwner("");
            id = otraCasa.save();
            Log.d("tp", "id: " + id);
            //agrego las casas al listado
        }
    }


}
