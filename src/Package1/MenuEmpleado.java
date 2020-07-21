package Package1;
import java.util.*;
import java.util.stream.Collectors;

public class MenuEmpleado {

    public static void Listar() {

 try {
     Scanner entrada = new Scanner(System.in);
     int opcion;


         do {
             System.out.println("Elegir opción");
             System.out.println("1. Agregar Empleado");
             System.out.println("2. Eliminar Empleado");
             System.out.println("3. Actualizar Empleado");
             System.out.println("4. Mostrar Empleados");
             System.out.println("5. Salir");
             opcion = entrada.nextInt();
             if (opcion < 1 || opcion > 5) {
                 System.out.println("Opción inválida");
             }
         } while (opcion < 1 || opcion > 5);

         switch (opcion) {
             case 1:
                 Operaciones.agregar();
                 break;

             case 2:
                 Operaciones.eliminar();
                 break;

             case 3:
                 Operaciones.actualizar();
                 break;

             case 4:
                 Operaciones.mostrar();
                 break;

             case 5:
                 System.out.println("Fin de la aplicación");

         }

 }catch (Exception ex){
     System.out.println("Opción inválida");
     Listar();
 }
    }



}
