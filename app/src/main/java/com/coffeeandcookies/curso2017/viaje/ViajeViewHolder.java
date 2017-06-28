package com.coffeeandcookies.curso2017.viaje;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.coffeeandcookies.curso2017.R;

import static android.view.View.GONE;

/**
 * Created by Gonzalo on 23/06/2017.
 */

public class ViajeViewHolder extends RecyclerView.ViewHolder
{
    TextView textView_chofer;
    TextView textView_direccion;
    CheckBox checkBox_tomado;
    TextView textView_monton;

    Context context;
    //recibo renglon XML convertido a Java (View)
    //desde el View accedo a los componentes internos
    public ViajeViewHolder(View itemView) {
        super(itemView);
        textView_chofer = (TextView)itemView.findViewById(R.id.textView_chofer);
        textView_direccion = (TextView)itemView.findViewById(R.id.textView_direccion);
        checkBox_tomado = (CheckBox)itemView.findViewById(R.id.checkBox_tomado);
        textView_monton = (TextView)itemView.findViewById(R.id.textView_monton);
        context = itemView.getContext();
    }

    //recibo el objeto puro java (viaje)
    //armo la union entre componente y el dato
    public void setViaje(Viaje v)
    {
        textView_chofer.setText(v.getChofer());
        textView_direccion.setText(v.getDireccion());
        checkBox_tomado.setChecked(v.isTomado());

        textView_monton.setText(""+v.getMonto());

        if (v.getChofer().equals("ch3"))
        {
            textView_chofer.setText("soy yo!");
            textView_chofer.setTextColor(context.getResources().getColor(R.color.colorPrimaryDark));
        }

        if (!checkBox_tomado.isChecked())
        {
            textView_direccion.setVisibility(GONE);
        }

        checkBox_tomado.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean activo)
            {
                if (activo)
                {
                    textView_direccion.setVisibility(View.VISIBLE);
                }
                else
                {
                    textView_direccion.setVisibility(GONE);
                }
            }
        });
    }
}
