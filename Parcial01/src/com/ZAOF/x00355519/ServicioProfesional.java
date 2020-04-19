package com.ZAOF.x00355519;

public class ServicioProfesional extends Empleado{
    private int mesesContrato;

    public ServicioProfesional(String nombreEmpresa, String nombre, String puesto, double salario, int mesesContrato) {
        super(nombreEmpresa, nombre, puesto, salario);
        this.mesesContrato = mesesContrato;
    }

    public int getMesesContrato() {
        return mesesContrato;
    }

    public void setMesesContrato(int mesesContrato) {
        this.mesesContrato = mesesContrato;
    }

    @Override
    public void addDocumento(Documento d){
        documentos.add(d);
    }

    public String ToString(){
        String doc = "";

        for(Documento d : documentos){
            doc += d.toString();
        }

        if(doc != ""){
            return "Nombre: " + nombre + " Puesto: " + puesto + " Salario: " + salario +
                    "Meses de Contrato: " + mesesContrato + " Documentos: " + doc;
        }
        else{
            return "Nombre: " + nombre + " Puesto: " + puesto + " Salario: " + salario +
                    "Meses de Contrato: " + mesesContrato + " Documentos: No hay documentos";
        }
    }
}
