package com.example.dispmovregistronotasclase;

import java.io.Serializable;

public class Corte implements Serializable {
    private float trabajos;
    private float autoevaluacion;
    private float parcial;
    

    public Corte(){

    }

    public void setTrabajos(float trabajos) {

        this.trabajos = trabajos;
    }
    public float getTrabajos() {

        return trabajos;
    }

    public void setAutoevaluacion(float autoevaluacion) {

        this.autoevaluacion = autoevaluacion;
    }
    public float getAutoevaluacion() {

        return autoevaluacion;
    }

    public void setParcial(float parcial) {

        this.parcial = parcial;
    }
    public float getParcial() {

        return parcial;
    }
}
