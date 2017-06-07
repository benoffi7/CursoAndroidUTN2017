package com.coffeeandcookies.curso2017;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by Gonzalo on 07/06/2017.
 */

public class lay_listado extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_listado);
        //listado de casas
        ArrayList<Casa> casas = new ArrayList<>();
        //una casa
        Casa casa = new Casa();
        casa.setCalle("salta");
        casa.setNumero(123);
        casa.setHabitaciones(3);
        casa.setOcupada(true);
        casa.setOwner("pepe grillo");
        //otra casa
        Casa otraCasa = new Casa();
        otraCasa.setCalle("independencia");
        otraCasa.setNumero(456);
        otraCasa.setHabitaciones(9);
        otraCasa.setOcupada(false);
        otraCasa.setOwner("");
        //agrego las casas al listado
        casas.add(casa);
        casas.add(otraCasa);

        RecyclerView contenedor_listado = (RecyclerView)findViewById(R.id.listado);
        AdaptadorCasas adaptadorCasas = new AdaptadorCasas(casas);
        contenedor_listado.setAdapter(adaptadorCasas);

    }
}
