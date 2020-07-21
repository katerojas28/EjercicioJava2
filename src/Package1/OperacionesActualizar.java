package Package1;

import java.util.Scanner;

public class OperacionesActualizar {

    public static void Nombre (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el Id del empleado a actualizar");
        int id = Integer.parseInt(scanner.nextLine());
        if(Operaciones.validarId(id)){
            for (Empleado empleado : Operaciones.ListaEmpleado) {
                if (empleado.getId() == id) {
                    System.out.println("Ingrese el Nombre");
                    String nombre = scanner.nextLine();
                    empleado.setNombre(nombre);
                    System.out.println("Se ha actualizado el Nombre del empleado con el id: "+id);
                }
            }
        }else{
            System.out.println("No existe un empleado con el id: "+id);
            Operaciones.actualizar();
        }
    }

    public static void Apellido (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el Id del empleado a actualizar");
        int id = Integer.parseInt(scanner.nextLine());
        if(Operaciones.validarId(id)){
            for (Empleado empleado : Operaciones.ListaEmpleado) {
                if (empleado.getId() == id) {
                    System.out.println("Ingrese el Apellido");
                    String apellido = scanner.nextLine();
                    empleado.setApellido(apellido);
                    System.out.println("Se ha actualizado el Apellido del empleado con el id: "+id);
                }
            }
        }else{
            System.out.println("No existe un empleado con el id: "+id);
            Operaciones.actualizar();
        }
    }

    public static void Salario (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el Id del empleado a actualizar");
        int id = Integer.parseInt(scanner.nextLine());
        if(Operaciones.validarId(id)){
            for (Empleado empleado : Operaciones.ListaEmpleado) {
                if (empleado.getId() == id) {
                    System.out.println("Ingrese el Salario");
                    double salario = scanner.nextDouble();
                    empleado.setSalario(salario);
                    System.out.println("Se ha actualizado el Salario del empleado con el id: "+id);
                }
            }
        }else{
            System.out.println("No existe un empleado con el id: "+id);
            Operaciones.actualizar();
        }
    }
}
