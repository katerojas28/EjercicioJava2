package Package1;

import java.util.*;

public class Operaciones {

   static List<Empleado> ListaEmpleado = new LinkedList<>();

    public static boolean validarId(int id){
        for(Empleado empleado : ListaEmpleado){
            if(empleado.getId() == id){
                return true;
            }
        }
        return false;
    }

    public static void agregar(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el Id del Empleado");
        try{
        int id = Integer.parseInt(scanner.nextLine());
        if(validarId(id)){
            System.out.println("Ya existe el Empleado con ese Id");
        }else{
            System.out.println("Ingrese el Nombre del Empleado");
            String nombre = scanner.nextLine();
            System.out.println("Ingrese el Apellido del Empleado");
            String apellido = scanner.nextLine();
            System.out.println("Ingrese el Salario del Empleado");
            try{
                double salario = Double.parseDouble(scanner.nextLine());
                Empleado nuevo = new Empleado(id, nombre,apellido, salario);
                ListaEmpleado.add(nuevo);
                System.out.println("Empleado ha sido Agregado");
            }catch (NumberFormatException ex){
                System.out.println("Solo se admite salario de tipo double utilice . en vez de , " );
                agregar();
            }
        }
        }catch (NumberFormatException ex){
            System.out.println("Solo se admite numeros de tipo entero" );
            agregar();
        }
        MenuEmpleado.Listar();
    }

    public static void eliminar () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el Id del Empleado que desea eliminar");
        int id = Integer.parseInt(scanner.nextLine());
        Optional<Integer> nombre = Optional.ofNullable(id);
        if (nombre.isPresent()) {
            if (validarId(id)) {
                ListaEmpleado.removeIf(empleado -> empleado.getId() == id);
                System.out.println("El Empleado ha sido eliminado");
            } else {
                System.out.println("No existe un empleado con ese Id");
                eliminar();
            }
        } else {
            System.out.println("No se ha escrito ningun Id de Empleado");
            eliminar();
            MenuEmpleado.Listar();
        }
    }

    public static void actualizar(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione la opcion correspondiente");
        try {
            Scanner entrada = new Scanner(System.in);
            int opcion;
            do {
                System.out.println("1. Actualizar Nombre");
                System.out.println("2. Actualizar Apellido");
                System.out.println("3. Actualizar Salario");
                System.out.println("4. Salir");
                opcion = entrada.nextInt();
                if (opcion < 1 || opcion > 4) {
                    System.out.println("Opción inválida");
                }
            } while (opcion < 1 || opcion > 4);
            switch (opcion) {
                case 1:
                    OperacionesActualizar.Nombre();
                    break;
                case 2:
                    OperacionesActualizar.Apellido();
                    break;
                case 3:
                    OperacionesActualizar.Salario();
                    break;
                case 4:
                    System.out.println("Se ha redireccionado al Menu principal del empleado");
                    MenuEmpleado.Listar();
            }
        }catch (Exception ex){
            System.out.println("Opción inválida");
            actualizar();
        }
       actualizar();
    }

    public static void mostrar (){
        ListaEmpleado.stream().forEach(listaEmpleados ->{System.out.println(listaEmpleados);});
        MenuEmpleado.Listar();
    }

    public static void salir (){
        System.exit(0);
    }
}