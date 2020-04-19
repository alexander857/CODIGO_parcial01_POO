package com.ZAOF.x00355519;

import java.util.Scanner;

public class CalculadoraImpuestos {
        private double TotalRenta;
        private double TotalIsss;
        private double TotalAFP;

    private CalculadoraImpuestos() {
    }

    public static void calcularPago(Empleado empleado) {
        Scanner sca = new Scanner(System.in);
        if (empleado instanceof PlazaFija) {
            double BaseSalary = Empleado.getSalario();
            double SalaryWithoutTaxes;

            //AFP
            double AFP = (0.0625 * BaseSalary);

            //ISSS
            double ISSS = (0.03 * BaseSalary);

            SalaryWithoutTaxes = (BaseSalary - AFP - ISSS);

            //Renta
            if (SalaryWithoutTaxes > 0.01 && SalaryWithoutTaxes <= 472.00) {
                double Renta = 0;
                System.out.println("No debe pagar renta\n");
                System.out.println("Salario a pagar al empleado: $" + (SalaryWithoutTaxes - Renta) +
                        " dolares");
            }

            if (SalaryWithoutTaxes > 472.00 && SalaryWithoutTaxes <= 895.24) {
                double Renta1 = ((0.1 * (SalaryWithoutTaxes - 472)) + 17.67);
                System.out.println("Debe pagar: $" + Renta1 + " dolares\n");
                System.out.println("Salario a pagar al empleado: $" + (SalaryWithoutTaxes - Renta1) +
                        " dolares");
            }

            if (SalaryWithoutTaxes > 895.24 && SalaryWithoutTaxes <= 2038.10) {
                double Renta2 = ((0.2 * (SalaryWithoutTaxes - 895.25)) + 60);
                System.out.println("Debe pagar: $" + Renta2 + " dolares\n");
                System.out.println("Salario a pagar al empleado: $" + (SalaryWithoutTaxes - Renta2) +
                        " dolares");
            }

            if (SalaryWithoutTaxes > 2038.10) {
                double Renta3 = ((0.3 * (SalaryWithoutTaxes - 2038.10)) + 288.57);
                System.out.println("Debe pagar: $" + Renta3 + " dolares\n");
                System.out.println("Salario a pagar al empleado: $" + (SalaryWithoutTaxes - Renta3) +
                        " dolares");
            }
        }

        if (empleado instanceof ServicioProfesional){
            double BaseSalary = Empleado.getSalario();
            System.out.println("Se le descontara el 10% de su salario como valor de renta\n");
                double Renta = (0.1 * BaseSalary);
                double LiquidSalary = BaseSalary - Renta;
                System.out.println("Su salario es: $" + LiquidSalary + " dolares");
        }

    }
}
