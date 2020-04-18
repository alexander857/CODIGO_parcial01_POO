package com.ZAOF.x00355519;

import java.util.ArrayList;

public abstract class Empleado extends Empresa{
    protected String nombre, puesto;
    protected ArrayList<Documento> documentos;
    protected double salario;

    public Empleado(String nombreEmpresa, String nombre, String puesto, double salario) {
        super(nombreEmpresa);
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
        documentos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public ArrayList<Documento> getDocumentos() {
        return documentos;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    //metodos de agregar documentos
    public void addDocumentos(Documento d){

    }
    public void removeDocumento(String nombre){

    }
}
