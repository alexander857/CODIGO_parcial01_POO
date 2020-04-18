package com.ZAOF.x00355519;

import java.util.ArrayList;

public class Empresa {
    private String nombreEmpresa;
    private ArrayList<Empleado> planilla;

    public Empresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
        planilla = new ArrayList<>();
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
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
