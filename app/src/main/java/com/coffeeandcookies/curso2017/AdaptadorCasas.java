package com.coffeeandcookies.curso2017;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gonzalo on 07/06/2017.
 */

public class AdaptadorCasas extends RecyclerView.Adapter<CasaViewHolder>
{
    private static final String TAG = "AdaptadorCasas";
    List<Casa> misCasas;

    public AdaptadorCasas(List<Casa>arrayList)
    {
        misCasas = arrayList;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    //retorna la cantidad de elementos
    //siempre pero siempre tiene que ser dinamico, nunca un valor puesto a mano
    @Override
    public int getItemCount() {
        return misCasas.size();
    }

    @Override
    public CasaViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        //inflar un XML (fila_casa) en una variable Java
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fila_casa, parent, false);
        //crea el renglon (fila) con un XML especifico
        CasaViewHolder pvh = new CasaViewHolder(v);
        return pvh;

    }

    @Override
    public void onBindViewHolder(CasaViewHolder holder, int position)
    {
        Log.d(TAG, "onBindViewHolder: "+position);
        Casa casaActual = misCasas.get(position);
        holder.setItem(casaActual);
    }
}
