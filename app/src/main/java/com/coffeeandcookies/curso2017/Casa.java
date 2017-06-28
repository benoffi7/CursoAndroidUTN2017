package com.coffeeandcookies.curso2017;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Gonzalo on 07/06/2017.
 */
@Table(name = "casas")
public class Casa extends Model
{
    @Column(name = "habitaciones")
    int habitaciones;
    @Column(name = "calle")
    String calle;
    @Column(name = "numero")
    int numero;
    @Column(name = "ocupada")
    boolean ocupada;
    @Column(name = "owner")
    String owner;
    @Column(name = "banios")
    String banios;

    public String getBanios() {
        return banios;
    }

    public void setBanios(String banios) {
        this.banios = banios;
    }

    //alt + insert getter and setter

    public int getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(int habitaciones) {
        this.habitaciones = habitaciones;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
