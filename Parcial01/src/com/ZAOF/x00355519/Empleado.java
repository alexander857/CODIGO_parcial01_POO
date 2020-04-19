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
        documentos.add(d);
    }
    public void removeDocumento(String nombre){
    }

    public String ToString(){
        String doc = "";
        PlazaFija P = null;
        ServicioProfesional S = null;

        //lista de documentos del empleado
        for(Documento d : documentos){
            doc += d.toString();
        }

        if(doc != ""){
            if(puesto.equalsIgnoreCase("Plaza fija")){
                return "Nombre: " + nombre + " Puesto: " + puesto + " Salario: $" + salario + "\n" +
                        "Extencion: "+ P.getExtension() + "Documentos: " + doc;
            }
            else{
                return "Nombre: " + nombre + " Puesto: " + puesto + " Salario: $" + salario + "\n" +
                        "Mese de contrato: " + S.getMesesContrato() + "Documentos: " + doc;
            }
        }
        else{
            if(puesto.equalsIgnoreCase("Plaza fija")){
                return "Nombre: " + nombre + " Puesto: " + puesto + " Salario: $" + salario + "\n" +
                        "Extencion: "+ P.getExtension() + "Documentos: No tiene documentos";
            }
            else{
                return "Nombre: " + nombre + " Puesto: " + puesto + " Salario: $" + salario + "\n" +
                        "Mese de contrato: " + S.getMesesContrato() + "Documentos: No tiene documentos";
            }
        }
    }
}
