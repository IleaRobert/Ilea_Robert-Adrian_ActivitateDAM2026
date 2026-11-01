package com.example.laborator4;

import java.io.Serializable;

public class Imprimanta implements Serializable {
    String marca;
    String model;
    boolean estePornita;
    boolean areWIFI;
    float notaTiparire;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isEstePornita() {
        return estePornita;
    }

    public void setEstePornita(boolean estePornita) {
        this.estePornita = estePornita;
    }

    public boolean isAreWIFI() {
        return areWIFI;
    }

    public void setAreWIFI(boolean areWIFI) {
        this.areWIFI = areWIFI;
    }

    public float getNotaTiparire() {
        return notaTiparire;
    }

    public void setNotaTiparire(float notaTiparire) {
        this.notaTiparire = notaTiparire;
    }

    public Imprimanta(String marca, String model, boolean estePornita, boolean areWIFI, float notaTiparire) {
        this.marca = marca;
        this.model = model;
        this.estePornita = estePornita;
        this.areWIFI = areWIFI;
        this.notaTiparire = notaTiparire;
    }

    @Override
    public String toString() {
        return "Imprimanta{" +
                "marca='" + marca + '\'' +
                ", model='" + model + '\'' +
                ", estePornita=" + estePornita +
                ", areWIFI=" + areWIFI +
                ", notaTiparire=" + notaTiparire +
                '}';
    }

}
