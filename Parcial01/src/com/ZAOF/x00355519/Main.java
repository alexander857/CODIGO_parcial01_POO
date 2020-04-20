package com.ZAOF.x00355519;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Empresa unaEmpresa = new Empresa("CodigoSV");

        boolean continuar = true;
        char opcion;
        do{

            try {
                menuPrincipal();
                System.out.print("Opcion: ");
                opcion = scan.nextLine().charAt(0);

                switch (opcion){
                    case '1':
                        //add empleado
                        String nombre = "", puesto = "";
                        double salario = 0;
                        int extension = 0, mesesContrato = 0;
                        PlazaFija unEmpleadoPlaza = null;
                        ServicioProfesional unEmpleadoProfesional = null;

                        boolean continuar1 = true;

                        do{
                            try {
                                System.out.println("\nDatos del Empleado");
                                System.out.print("Nombre: ");
                                nombre = scan.nextLine();

                                if(nombre.equals(""))
                                    throw new InvalidNameException("No puede quedar vacio el nombre");

                                String nombreF = nombre;
                                for(Empleado e : unaEmpresa.getPlanilla()){
                                    if(e.getNombre().equals(nombreF))
                                        throw new InvalidNameException("Nombre ya registrado");
                                }


                                System.out.print("Puesto: ");
                                puesto = scan.nextLine();

                                if(!puesto.equalsIgnoreCase("Servicio Profesional") && !puesto.equalsIgnoreCase("Plaza Fija"))
                                    throw new NotFoundJobException("No esta ese tipo de puesto en la Empresa!");

                                System.out.print("Salario: $");
                                salario = scan.nextDouble(); scan.nextLine();

                                if(salario < 300)
                                    throw new InvalidSalaryException("Salario minimo $300!");


                                if(puesto.equalsIgnoreCase("Plaza Fija")){
                                    System.out.print("Extension: ");
                                    extension = scan.nextInt(); scan.nextLine();

                                    unEmpleadoPlaza = new PlazaFija("CodigoSV", nombre, puesto, salario, extension);
                                    unaEmpresa.addEmpleado(unEmpleadoPlaza);
                                    //ciclo para ingresar los documentos que tenga el empleado
                                    boolean seguir = true;
                                    char opcion1 = 0;
                                    do{
                                        System.out.print("Agregar Documentos? S/N: ");
                                        opcion1 = scan.nextLine().charAt(0);

                                        switch (opcion1){
                                            case 's':
                                                unEmpleadoPlaza.addDocumento(pedirDatosDocumento());
                                                break;
                                            case 'n':
                                                seguir = false;
                                                break;
                                            default:
                                                System.out.println("Opcion Invalida!");
                                                break;
                                        }
                                    }while(seguir);

                                    continuar1 = false;

                                }
                                else{
                                    System.out.print("Meses de Contrato: ");
                                    mesesContrato = scan.nextInt(); scan.nextLine();

                                    if(mesesContrato < 1)
                                        throw new InvalidContractException("Debe ser un contrado de un mes en adelante!");

                                    unEmpleadoProfesional = new ServicioProfesional("CodigoSV",nombre,
                                            puesto, salario, mesesContrato);
                                    unaEmpresa.addEmpleado(unEmpleadoProfesional);
                                    boolean seguir = true;
                                    char opcion2 = 0;
                                    do{
                                        System.out.print("Agregar Documentos? S/N: ");
                                        opcion2 = scan.nextLine().charAt(0);

                                        switch (opcion2){
                                            case 's':
                                                unEmpleadoProfesional.addDocumento(pedirDatosDocumento());
                                                break;
                                            case 'n':
                                                seguir = false;
                                                break;
                                            default:
                                                System.out.println("\nOpcion Invalida!");
                                                break;
                                        }
                                    }while(seguir);

                                    continuar1 = false;

                                }

                            }
                            catch (InputMismatchException e){
                                System.out.println("\nValor no valido!");
                                scan.nextLine();
                            }
                            catch (InvalidSalaryException | NotFoundJobException | InvalidContractException e){
                                System.out.println("\nError: " + e.getMessage());
                            }
                            catch (InvalidNameException e) {
                                System.out.println();
                                System.out.println(e.getMessage());
                            }

                        }while(continuar1);

                        break;
                    case '2':
                        //remove empleado
                        break;
                    case '3':
                        //lista
                        System.out.println();
                        unaEmpresa.getPlanilla().forEach(s->{
                            System.out.println(s.ToString());
                        });
                        break;
                    case '4':
                        //sueldo
                        break;
                    case '5':
                        //totales
                        break;
                    case '0':
                        continuar = false;
                        break;
                    default:
                        System.out.println("\nOpcion no valida!");
                        break;
                }
            }
            catch (Exception e){
                System.out.println();
                System.out.println(e.getMessage());
            }


        }while(continuar);
    }

    public static void menuPrincipal(){
        System.out.println("\n1-Agregar Empleado\n2-Despedir Empleado\n3-Ver lista de Empleados\n" +
                "4-Calcular Sueldo\n5-Mostrar Totales\n0-Salir");
    }

    public static Documento pedirDatosDocumento() {
        String nombreDoc = "", numero = "";
        boolean seguir = true;

        System.out.println("Documentos");
        System.out.print("\tNombre: ");
        nombreDoc = scan.nextLine();
        System.out.print("\tNumero: ");
        numero = scan.nextLine();

        return new Documento(nombreDoc,numero);
    }
}
