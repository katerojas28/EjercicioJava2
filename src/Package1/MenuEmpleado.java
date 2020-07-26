package Package1;
import java.util.*;

public class MenuEmpleado {

    public static void Listar() {

        try {
            Scanner entrada = new Scanner(System.in);
            int opcion;


                do {
                    System.out.println();
                    System.out.println("***    Elegir opción del Menu de Empleados     ***");
                    System.out.println("1. Agregar Empleado");
                    System.out.println("2. Eliminar Empleado");
                    System.out.println("3. Actualizar Empleado");
                    System.out.println("4. Mostrar Empleados");
                    System.out.println("5. Empleado con mayor salario");
                    System.out.println("6. Empleado con menor salario");
                    System.out.println("7. Empleados ordenados por nombre");
                    System.out.println("8. Suma de los salarios de todos los Empleados mayores a 700000");
                    System.out.println("9. Total de Empleados cuyo Apellido comienza por la letra ‘A’ ");
                    System.out.println("10. Los 5 primeros Empleados con el mayor salario.");
                    System.out.println("11. Salir");
                      opcion = entrada.nextInt();
                      if (opcion < 1 || opcion > 11) {
                         System.out.println();
                         System.out.println("Opción inválida");
                      }
                } while (opcion < 1 || opcion > 11);

                      switch (opcion) {
                         case 1:
                             System.out.println("----------------------------------------------------------------------------");
                             System.out.println();
                             Operaciones.agregar();
                             break;

                         case 2:
                             System.out.println("----------------------------------------------------------------------------");
                             System.out.println();
                             Operaciones.eliminar();
                             break;

                         case 3:
                             System.out.println("----------------------------------------------------------------------------");
                             System.out.println();
                             Operaciones.actualizar();
                             break;

                         case 4:
                             System.out.println("----------------------------------------------------------------------------");
                             System.out.println();
                             Operaciones.mostrar();
                             break;

                         case 5:
                             System.out.println("----------------------------------------------------------------------------");
                             System.out.println();
                             Operaciones.mostrarEmpleadoConMayorSalario();
                             break;

                         case 6:
                             System.out.println("----------------------------------------------------------------------------");
                             System.out.println();
                             Operaciones.mostrarEmpleadoConMenorSalario();
                             break;

                         case 7:
                             System.out.println("----------------------------------------------------------------------------");
                             System.out.println();
                             Operaciones.mostrarEmpleadosOrdenadosPorNombre();
                             break;

                         case 8:
                             System.out.println("----------------------------------------------------------------------------");
                             System.out.println();
                             Operaciones.sumaDeSalariosEmpleados();
                             break;

                         case 9:
                             System.out.println("----------------------------------------------------------------------------");
                             System.out.println();
                             Operaciones.totalDeEmpleadosConApellidoQueEmpiezaConA();
                             break;

                         case 10:
                             System.out.println("----------------------------------------------------------------------------");
                             System.out.println();
                             Operaciones.primerosCincoEmpeladosConMayorSalario();
                             break;


                         case 11:
                            System.out.println("----------------------------------------------------------------------------");
                            System.out.println();
                            System.out.println("Fin de la aplicación");
                            Operaciones.salir();

                      }

            }catch (Exception ex) {
                System.out.println();
                System.out.println("Opción inválida");
                Listar();
            }
    }

}
