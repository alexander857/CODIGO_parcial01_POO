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
            return "Nombre: " + nombre + "\nPuesto: " + puesto + "\nSalario: $" + salario +
                    "\nMeses de Contrato: " + mesesContrato + "\nDocumentos: " + doc;
        }
        else{
            return "Nombre: " + nombre + "\nPuesto: " + puesto + "\nSalario: $" + salario +
                    "\nMeses de Contrato: " + mesesContrato + "\nDocumentos: No hay documentos";
        }
    }
}
