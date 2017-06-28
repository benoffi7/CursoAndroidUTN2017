package com.coffeeandcookies.curso2017.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.coffeeandcookies.curso2017.R;
import com.coffeeandcookies.curso2017.viaje.Viaje;
import com.coffeeandcookies.curso2017.viaje.ViajeViewHolder;

import java.util.ArrayList;

/**
 * Created by Gonzalo on 23/06/2017.
 */

public class ViajeAdapter extends RecyclerView.Adapter<ViajeViewHolder>
{
    ArrayList<Viaje>misViajes;

    public ViajeAdapter(ArrayList<Viaje> viajeArrayList)
    {
        misViajes = viajeArrayList;
    }

    @Override
    public int getItemCount()
    {
        return misViajes.size();
    }

    //debemos crear el ViewHolder (hacer el new y llamar al constructor)
    //el constructor del viewholder necesita un objeto view...
    //tenemos que transformar el XML del renglon (fila_viaje.xml) a java (view)
    @Override
    public ViajeViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fila_viaje, parent, false);
        ViajeViewHolder vvh = new ViajeViewHolder(v);
        return vvh;
    }

    @Override
    public void onBindViewHolder(ViajeViewHolder holder, int position)
    {
        holder.setViaje(misViajes.get(position));
    }
}
