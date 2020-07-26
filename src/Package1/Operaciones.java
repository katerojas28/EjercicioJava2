package Package1;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        }MenuEmpleado.Listar();
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
                    System.out.println("----------------------------------------------------------------------------");
                    System.out.println();
                    OperacionesActualizar.Nombre();
                    break;
                case 2:
                    System.out.println("----------------------------------------------------------------------------");
                    System.out.println();
                    OperacionesActualizar.Apellido();
                    break;
                case 3:
                    System.out.println("----------------------------------------------------------------------------");
                    System.out.println();
                    OperacionesActualizar.Salario();
                    break;
                case 4:
                    System.out.println("----------------------------------------------------------------------------");
                    System.out.println();
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

    public static void mostrarEmpleadoConMayorSalario() {
        System.out.println("\nEmpleado con el salario más alto:");
        System.out.println(ListaEmpleado.stream()
                .max(Comparator.comparing(Empleado::getSalario))
                .map(Empleado ::toString)
                .orElse("No hay Empleados"));
        MenuEmpleado.Listar();
    }

    public static void mostrarEmpleadoConMenorSalario() {
        System.out.println("\nEmpleado con el salario más bajo:");
        System.out.println(ListaEmpleado.stream()
                .min(Comparator.comparing(Empleado::getSalario))
                .map(Empleado::toString)
                .orElse("No hay Empleados"));
        MenuEmpleado.Listar();
    }

    public static void mostrarEmpleadosOrdenadosPorNombre() {
        System.out.println("\nEmpleados ordenados por Nombre:");
        ListaEmpleado.stream()
                .sorted(Comparator.comparing(Empleado::getNombre))
                .forEach(System.out::println);
        MenuEmpleado.Listar();
    }

    public static void sumaDeSalariosEmpleados(){
        System.out.println("\nSuma de los salarios de todos los Empleados cuyo salario es mayor a 700000:");
        System.out.println(ListaEmpleado.stream()
                .filter(empleado -> empleado.getSalario() >= 700000)
                .map(Empleado :: getSalario)
                .reduce((double) 0,(acc, sueldo) -> acc+sueldo));
        MenuEmpleado.Listar();
    }

    public static Stream<Empleado> filtroEmpleadoConApellidoQueEmpiezaConA(){
        return ListaEmpleado.stream()
                .filter(empleado -> empleado.getApellido().toUpperCase().startsWith("A"));
    }

    public static void totalDeEmpleadosConApellidoQueEmpiezaConA() {
        System.out.print( "Hay un total de "+ filtroEmpleadoConApellidoQueEmpiezaConA().count()+
                " Empleados que su apellido empieza por A");
        System.out.println();
        MenuEmpleado.Listar();
    }

    public static void primerosCincoEmpeladosConMayorSalario(){
        System.out.println("\nEmpleados con el salario más alto:");
        System.out.println(ListaEmpleado.stream()
                .sorted(Comparator.comparing(Empleado:: getSalario, Comparator.reverseOrder()))
                .limit(5)
                .collect(Collectors.toList()));
        MenuEmpleado.Listar();
    }

    public static void salir (){
        System.exit(0);
    }
}