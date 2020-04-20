package com.ZAOF.x00355519;

public class PlazaFija extends Empleado{
    private int extension;

    public PlazaFija(String nombreEmpresa, String nombre, String puesto, double salario, int extension) {
        super(nombreEmpresa, nombre, puesto, salario);
        this.extension = extension;
    }

    public int getExtension() {
        return extension;
    }

    public void setExtension(int extension) {
        this.extension = extension;
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
                    "\nExtencion: " + extension + "\nDocumentos: " + doc;
        }
        else{
            return "Nombre: " + nombre + "\nPuesto: " + puesto + "\nSalario: $" + salario +
                    "\nExtencion: " + extension + "\nDocumentos: No hay documentos";
        }
    }
}
