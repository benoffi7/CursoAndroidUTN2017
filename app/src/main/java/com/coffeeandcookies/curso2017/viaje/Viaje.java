package com.coffeeandcookies.curso2017.viaje;

/**
 * Created by Gonzalo on 23/06/2017.
 */

public class Viaje
{
    String chofer;
    String direccion;
    boolean tomado;
    int monto;

    public Viaje(String chofer, String direccion, boolean tomado, int monto) {
        this.chofer = chofer;
        this.direccion = direccion;
        this.tomado = tomado;
        this.monto = monto;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getChofer() {
        return chofer;
    }

    public void setChofer(String chofer) {
        this.chofer = chofer;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isTomado() {
        return tomado;
    }

    public void setTomado(boolean tomado) {
        this.tomado = tomado;
    }
}
