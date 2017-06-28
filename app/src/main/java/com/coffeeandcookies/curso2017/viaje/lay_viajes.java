package com.coffeeandcookies.curso2017.viaje;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.coffeeandcookies.curso2017.R;
import com.coffeeandcookies.curso2017.adapter.ViajeAdapter;

import java.util.ArrayList;

/**
 * Created by Gonzalo on 23/06/2017.
 */

public class lay_viajes extends AppCompatActivity
{
    ArrayList<Viaje>viajeArrayList;
    int i = 5;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viajes);
        viajeArrayList = getViajes();
        recyclerView = (RecyclerView)findViewById(R.id.rv_viajes);
        recyclerView.setLayoutManager(new LinearLayoutManager(lay_viajes.this));

        Button button = (Button)findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                viajeArrayList.add(new Viaje("ch"+i,"dir"+i,true,i));
                i++;
                setAdapter();
            }
        });
        setAdapter();
    }

    public ArrayList<Viaje>getViajes()
    {
        viajeArrayList=new ArrayList<>();
        viajeArrayList.add(new Viaje("ch1","dir1",true,1));
        viajeArrayList.add(new Viaje("ch2","dir2",false,2));
        viajeArrayList.add(new Viaje("ch3","dir3",true,3));
        viajeArrayList.add(new Viaje("ch4","dir4",false,4));
        return  viajeArrayList;
    }

    void setAdapter()
    {
        ViajeAdapter viajeAdapter = new ViajeAdapter(viajeArrayList);
        recyclerView.setAdapter(viajeAdapter);
    }
}
