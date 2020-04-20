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
                try {
                    menuPrincipal();
                    //Eleccion de proceso del menu
                    System.out.print("Opcion: ");
                    opcion = scan.nextLine().charAt(0);
                    //Verificacion de datos de entrada
                    if (opcion < 0 && opcion >= '6' && opcion != ' ')
                        throw new WrongDataException("Ingreso de datos erroneo!");

                    switch (opcion) {
                        case '1':
                            //add empleado
                            String nombre = "", puesto = "";
                            double salario = 0;
                            int extension = 0, mesesContrato = 0;
                            PlazaFija unEmpleadoPlaza = null;
                            ServicioProfesional unEmpleadoProfesional = null;

                            boolean continuar1 = true;

                            do {
                                try {
                                    System.out.println("\nDatos del Empleado");
                                    System.out.print("Nombre: ");
                                    nombre = scan.nextLine();

                                    //Verificacion de nombre
                                    if (nombre.equals(""))
                                        throw new InvalidNameException("No puede quedar vacio el nombre!");

                                    String nombreF = nombre;
                                    for (Empleado e : unaEmpresa.getPlanilla()) {
                                        //Verificacion sobre nombres repetidos
                                        if (e.getNombre().equals(nombreF))
                                            throw new InvalidNameException("Nombre ya registrado!");
                                    }


                                    System.out.print("Puesto: ");
                                    puesto = scan.nextLine();

                                    //Verificacion de tipo de empleo
                                    if (!puesto.equalsIgnoreCase("Servicio Profesional") &&
                                            !puesto.equalsIgnoreCase("Plaza Fija"))
                                        throw new NotFoundJobException("No esta ese tipo de puesto en la Empresa!");

                                    System.out.print("Salario: $");
                                    salario = scan.nextDouble();
                                    scan.nextLine();

                                    //Verificacion de salario minimo
                                    if (salario < 300)
                                        throw new InvalidSalaryException("Salario minimo $300!");


                                    if (puesto.equalsIgnoreCase("Plaza Fija")) {
                                        System.out.print("Extension: ");
                                        extension = scan.nextInt();
                                        scan.nextLine();

                                        unEmpleadoPlaza = new PlazaFija("CodigoSV", nombre, puesto,
                                                salario, extension);
                                        //ciclo para ingresar los documentos que tenga el empleado
                                        boolean seguir = true;
                                        char opcion1 = 0;
                                        do {
                                            System.out.print("Agregar Documentos? S/N: ");
                                            opcion1 = scan.nextLine().charAt(0);

                                            switch (opcion1) {
                                                case 's':
                                                    //Agrega documento
                                                    unEmpleadoPlaza.addDocumento(pedirDatosDocumento());
                                                    unaEmpresa.addEmpleado(unEmpleadoPlaza);
                                                    break;
                                                case 'n':
                                                    //Continuar proceso
                                                    unaEmpresa.addEmpleado(unEmpleadoPlaza);
                                                    seguir = false;
                                                    break;
                                                default:
                                                    System.out.println("Opcion Invalida!");
                                                    break;
                                            }
                                        } while (seguir);

                                        continuar1 = false;

                                    } else {
                                        System.out.print("Meses de Contrato: ");
                                        mesesContrato = scan.nextInt();
                                        scan.nextLine();

                                        //Verificaion plazo minimo de contrato
                                        if (mesesContrato < 1)
                                            throw new InvalidContractException("Debe ser un contrado " +
                                                    "de un mes en adelante!");

                                        unEmpleadoProfesional = new ServicioProfesional("CodigoSV", nombre,
                                                puesto, salario, mesesContrato);
                                        boolean seguir = true;
                                        char opcion2 = 0;
                                        do {
                                            System.out.print("Agregar Documentos? S/N: ");
                                            opcion2 = scan.nextLine().charAt(0);

                                            switch (opcion2) {
                                                case 's':
                                                    //Agregar empleado
                                                    unEmpleadoProfesional.addDocumento(pedirDatosDocumento());
                                                    unaEmpresa.addEmpleado(unEmpleadoProfesional);
                                                    break;
                                                case 'n':
                                                    //Continuar proceso
                                                    unaEmpresa.addEmpleado(unEmpleadoProfesional);
                                                    seguir = false;
                                                    break;
                                                default:
                                                    System.out.println("\nOpcion Invalida!");
                                                    break;
                                            }
                                        } while (seguir);

                                        continuar1 = false;

                                    }

                                    //Excepciones generales
                                } catch (InputMismatchException e) {
                                    System.out.println("\nValor no valido!");
                                    scan.nextLine();
                                    //Excepciones sobre restricciones de salario, trabajo y contratos
                                } catch (InvalidSalaryException | NotFoundJobException | InvalidContractException e) {
                                    System.out.println("\nError: " + e.getMessage());
                                    //Excepcion sobre nombres no validos
                                } catch (InvalidNameException e) {
                                    System.out.println();
                                    System.out.println(e.getMessage());
                                }

                            } while (continuar1);

                            break;
                        case '2':
                            //remove empleado
                            try {
                                System.out.println();
                                System.out.print("Ingrese el nombre del empleado: ");
                                String empleado = scan.nextLine();
                                String empleadoF = empleado;
                                Empleado aDespedir = null;

                                for(Empleado e: unaEmpresa.getPlanilla()){
                                    if(e.getNombre().equals(empleado)){
                                        aDespedir = e;
                                    }
                                }

                                if(aDespedir == null)
                                    throw new NotExistingEmployeeException("No esta registrado ese nombre!");

                                unaEmpresa.getPlanilla().removeIf(s->s.getNombre().equals(empleadoF));
                                System.out.println("Empleado despedido!");
                            }
                            catch (NotExistingEmployeeException e){
                                System.out.println();
                                System.out.println(e.getMessage());
                            }

                            break;
                        case '3':
                            //lista
                            //Mostrar lista de empleados
                            unaEmpresa.getPlanilla().forEach(s -> {
                                System.out.println();
                                System.out.println(s.ToString());
                            });
                            break;
                        case '4':
                            //sueldo
                            String name = "";
                            boolean encontrado = false;
                            System.out.println();
                            System.out.print("Ingrese nombre del trabajador: ");
                            name = scan.nextLine();
                            String nombreF = name;
                            //Buscar empleado en planilla
                            for (Empleado e : unaEmpresa.getPlanilla()) {
                                if (e.getNombre().equals(nombreF)){
                                    CalculadoraImpuestos.calcularPago(e);
                                    encontrado = true;
                                }

                            }
                            if(!encontrado){
                                System.out.println();
                                System.out.println("No encontrado o lista vacia!");
                            }

                            break;
                        case '5':
                            //Mostrar totales de impuestos
                            System.out.println();
                            System.out.println(CalculadoraImpuestos.MostrarTotales());
                            break;
                        case '6':
                            continuar = false;
                            break;
                        default:
                            System.out.println("\nOpcion no valida!");
                            break;
                    }
                }
                //Verificacion de datos de entrada
                catch (WrongDataException e) {
                        System.out.println(e.getMessage());
                    }
            }
            //Verificacion de excepciones generales
            catch (Exception e){
                System.out.println();
                System.out.println(e.getMessage());
            }


        }while(continuar);
    }

    public static void menuPrincipal(){
        //Mostrar menu principal
        System.out.println("\n1-Agregar Empleado\n2-Despedir Empleado\n3-Ver lista de Empleados\n" +
                "4-Calcular Sueldo\n5-Mostrar Totales\n6-Salir");
    }

    public static Documento pedirDatosDocumento() {
        String nombreDoc = "", numero = "";
        boolean seguir = true;

        do{
            try {
                System.out.println("Documentos");
                System.out.print("\tNombre: ");
                nombreDoc = scan.nextLine();
                if(nombreDoc.equals(""))
                    throw new InvalidNameException("Tiene que llenar todos los campos!!");
                System.out.print("\tNumero: ");
                numero = scan.nextLine();
                if(numero.equals(""))
                    throw new InvalidNameException("Tiene que llenar todos los campos!!");
                seguir = false;
            }
            catch (InvalidNameException e){
                System.out.println(e.getMessage());
            }
        }while(seguir);


        //Retornando valores del documento
        return new Documento(nombreDoc,numero);
    }
}
