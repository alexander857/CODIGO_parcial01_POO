package com.ZAOF.x00355519;

import java.util.ArrayList;

public class Empresa {
    private String nombre;
    private ArrayList<Empleado> planilla;

    public Empresa(String nombre) {
        this.nombre = nombre;
        planilla = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Empleado> getPlanilla() {
        return planilla;
    }

    //metodos de agregar y quitar empleado

    public void addEmpleado(Empleado e){

    }
    public void quitEmpleado(String nombre){

    }
}
