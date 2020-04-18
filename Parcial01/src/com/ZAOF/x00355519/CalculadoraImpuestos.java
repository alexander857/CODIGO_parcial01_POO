package com.ZAOF.x00355519;

public class CalculadoraImpuestos extends Empleado{
        private Double TotalRenta;
        private Double TotalIsss;
        private Double TotalAFP;

        private CalculadoraImpuestos(){
            //Debe estar vacio
        }

        public Double calcularPago(Empleado) {
            if (Empleado instanceOf Empleado){
                System.out.println("Ingrese Nombre del empleado a buscar");
                String nameToFind = nextLine();
                for (Empleado e : Documento) {
                    if (nameToFind.equals(Empleado.getName())) {
                        Double BaseSalary = Empleado.getSalary();
                        Double SalaryWithoudTaxes = null;
                        Double LiquidSalary = null;

                        //AFP
                        Double AFP = (0.0625 * BaseSalary);
                        TotalAFP += AFP;

                        //ISSS
                        Double ISSS = (0.03 * BaseSalary);
                        TotalIsss += ISSS;

                        SalaryWithoutTaxes = (BaseSalary - AFP - ISSS);

                        //Renta
                        if (SalaryWithoutTaxes > 0.01 && SalaryWithoutTaxes <= 472.00) {
                            Double Renta = 0;
                            sout("No debe pagar renta\n");
                            System.out.println("Salario a pagar al empleado: $" + (Renta - SalaryWithoutTaxes) +
                                    " dolares");
                        }

                        if (SalaryWithoutTaxes > 472.00 && SalaryWithoutTaxes <= 895.24) {
                            Double Renta1 = ((0.1 * (SalaryWithoutTaxes - 472)) + 17.67);
                            System.out.println("Debe pagar: $" + Renta1 + " dolares\n");
                            System.out.println("Salario a pagar al empleado: $" + (Renta1 - SalaryWithoutTaxes) +
                                    " dolares");
                        }

                        if (SalaryWithoutTaxes > 895.24 && SalaryWithoutTaxes <= 2038.10) {
                            Double Renta2 = ((0.2 * (SalaryWithoutTaxes - 895.25)) + 60);
                            System.out.println("Debe pagar: $" + Renta2 + " dolares\n");
                            System.out.println("Salario a pagar al empleado: $" + (Renta2 - SalaryWithoutTaxes) +
                                    " dolares");
                        }

                        if (SalaryWithoutTaxes > 2038.10) {
                            Double Renta3 = ((0.3 * (SalaryWithoutTaxes - 2038.10)) + 288.57);
                            System.out.println("Debe pagar: $" + Renta3 + " dolares\n");
                            System.out.println("Salario a pagar al empleado: $" + (Renta3 - SalaryWithoutTaxes) +
                                    " dolares");
                        }

                    }
                }
            }
            else if (Empleado instanceOf Servicioprofesional){
                System.out.println("Ingrese Nombre del empleado a buscar");
                String nameToFind = next
                for (Empleado e : Documento) {
                    if (nameToFind.equals(Empleado)) {
                        Double BaseSalary = Empleado.getSalary();
                        System.out.println("Se le descontara el 10% de su salario como valor de renta\n");

                        Double Renta = (0.1 * BaseSalary);
                        Double LiquidSalary = BaseSalary - Renta;

                        System.out.println("Su salario es: $" + LiquidSalary + " dolares");
                    }
                    //Algún comentario del código?
                }
            }

        }
}
