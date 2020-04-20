package com.ZAOF.x00355519;

public class CalculadoraImpuestos {
        private static double TotalRenta;
        private static double TotalIsss;
        private static double TotalAFP;

    private CalculadoraImpuestos() {
    }

    public static double calcularPago(Empleado empleado) {
        double AFP = 0; double ISSS = 0;
        double Renta = 0; double LiquidSalary = 0;

        if (empleado instanceof PlazaFija) {
            double BaseSalary = empleado.getSalario();
            double SalaryWithoutTaxes;

            //AFP
            AFP = (0.0625 * BaseSalary);
            TotalAFP += AFP;

            //ISSS
            ISSS = (0.03 * BaseSalary);
            TotalIsss += ISSS;

            SalaryWithoutTaxes = (BaseSalary - AFP - ISSS);

            //Renta
            if (SalaryWithoutTaxes > 0.01 && SalaryWithoutTaxes <= 472.00) {
                Renta = 0;
                System.out.println();
                System.out.println("No debe pagar renta\n");
                System.out.println("Salario a pagar al empleado: $" + (SalaryWithoutTaxes - Renta) +
                        " dolares");
                TotalRenta += Renta;
            }

            if (SalaryWithoutTaxes > 472.00 && SalaryWithoutTaxes <= 895.24) {
                Renta = ((0.1 * (SalaryWithoutTaxes - 472)) + 17.67);
                System.out.println();
                System.out.println("Debe pagar: $" + Renta + " dolares\n");
                System.out.println("Salario a pagar al empleado: $" + (SalaryWithoutTaxes - Renta) +
                        " dolares");
                TotalRenta += Renta;
            }

            if (SalaryWithoutTaxes > 895.24 && SalaryWithoutTaxes <= 2038.10) {
                Renta = ((0.2 * (SalaryWithoutTaxes - 895.25)) + 60);
                System.out.println();
                System.out.println("Debe pagar: $" + Renta + " dolares\n");
                System.out.println("Salario a pagar al empleado: $" + (SalaryWithoutTaxes - Renta) +
                        " dolares");
                TotalRenta += Renta;
            }

            if (SalaryWithoutTaxes > 2038.10) {
                Renta = ((0.3 * (SalaryWithoutTaxes - 2038.10)) + 288.57);
                System.out.println();
                System.out.println("Debe pagar: $" + Renta + " dolares\n");
                System.out.println("Salario a pagar al empleado: $" + (SalaryWithoutTaxes - Renta) +
                        " dolares");
                TotalRenta += Renta;
            }
        }

        if (empleado instanceof ServicioProfesional){
            double BaseSalary = empleado.getSalario();
            System.out.println("Se le descontara el 10% de su salario como valor de renta\n");
                Renta = (0.1 * BaseSalary);
                LiquidSalary = BaseSalary - Renta;
                System.out.println();
                System.out.println("Su salario es: $" + LiquidSalary + " dolares");
            TotalRenta += Renta;
        }

        return LiquidSalary;
    }

    public static String MostrarTotales(){
        return "Total de impuesto sobre AFP: $" + TotalAFP + "\n"
                            + "Total de impuesto sobre Isss: $" + TotalIsss + "\n"
                                + "Total de impuesto sobre Renta: $" + TotalRenta + "\n";
    }
}
