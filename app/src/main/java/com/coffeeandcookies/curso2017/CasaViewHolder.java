package com.coffeeandcookies.curso2017;

import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by Gonzalo on 07/06/2017.
 */

public class CasaViewHolder extends RecyclerView.ViewHolder
{
    //componentes XML que representan el objecto CASA
    TextView textView_calle_numero;
    TextView textView_owner;
    CheckBox checkBox_ocupado;
    SeekBar seekBar_habitciones;
    TextView textView_hab;


    public CasaViewHolder(View itemView) {
        super(itemView);
        //relacionar las variables de + arriba con sus contrapartidas en XML
        textView_calle_numero = (TextView)itemView.findViewById(R.id.textView_calle_numero);
        textView_owner = (TextView)itemView.findViewById(R.id.textView_owner);
        textView_hab = (TextView)itemView.findViewById(R.id.textView_hab);
        checkBox_ocupado = (CheckBox)itemView.findViewById(R.id.checkBox_ocupado);
        seekBar_habitciones = (SeekBar)itemView.findViewById(R.id.seekBar_habitciones);
    }
    //completa los elementos XML con los datos de UNA sola casa/elemento
    public void setItem(final Casa miCasa)
    {
        textView_calle_numero.setText(miCasa.getCalle()+" "+miCasa.getNumero());
        //controlo la longitud del nombre del dueño
        if (miCasa.getOwner().length()>0) //si es mayor a 0 lo muestro
                textView_owner.setText(miCasa.getOwner());
        else  //sino oculto el componente
                textView_owner.setVisibility(View.GONE);

        checkBox_ocupado.setChecked(miCasa.isOcupada());



        seekBar_habitciones.setProgress(miCasa.getHabitaciones());
        textView_hab.setText("("+miCasa.getHabitaciones()+")");

        textView_calle_numero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                miCasa.delete();

            }
        });

        //que no se pueda tocar
        seekBar_habitciones.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                miCasa.setHabitaciones(i);
                textView_hab.setText("("+miCasa.getHabitaciones()+")");
                miCasa.save();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        checkBox_ocupado.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
                miCasa.setOcupada(b);
                miCasa.save();
            }
        });


    }

}
