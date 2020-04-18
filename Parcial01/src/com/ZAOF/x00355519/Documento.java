package com.ZAOF.x00355519;

public class Documento {
    private String nombreDoc, numero;

    public Documento(String nombreDoc, String numero) {
        this.nombreDoc = nombreDoc;
        this.numero = numero;
    }

    public String getNombreDoc() {
        return nombreDoc;
    }

    public String getNumero() {
        return numero;
    }
}
