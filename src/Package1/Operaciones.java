package Package1;

import java.util.*;

public class Operaciones {

   static List<Empleado> ListaEmpleado = new LinkedList<>();

    private static boolean validarId(int id){
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
            System.out.println("Ya existe");
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
                System.out.println("Empleado Agregado");

               // ListaEmpleado.add( new Empleado(id, nombre,apellido, salario));
            }catch (NumberFormatException ex){
                System.out.println("Solo se admite salario de tipo double " );
                agregar();
            }

        } }catch (NumberFormatException ex){
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
                System.out.println("Empleado eliminado");
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


    public static void actualizar (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el Id del Empleado que desea actualizar");
        int id = Integer.parseInt(scanner.nextLine());

        Optional<Integer> nombre = Optional.ofNullable(id);
        if(nombre.isPresent()){
            if(validarId(id)){
                for (Empleado empleado : ListaEmpleado) {
                    if (empleado.getId() == id) {
                        System.out.println("Actualice en Nombre");
                        String nombres = scanner.nextLine();
                        System.out.println("Actualice el Apellido");
                        String apellido = scanner.nextLine();
                        System.out.println("Altualice el Salario");
                        double salario = scanner.nextDouble();
                        empleado.setId(id);
                        empleado.setNombre(nombres);
                        empleado.setApellido(apellido);
                        empleado.setSalario(salario);
                        System.out.println("Empleado Actualizado");
                    }
                }

            }else{
                System.out.println("No existe un empleado con ese Id");
                actualizar();
            }
        }else{
            System.out.println("No se ha escrito ningun Id de Empleado");
            actualizar();
        }
        MenuEmpleado.Listar();
    }


    public static void mostrar (){
        ListaEmpleado.stream()
                .forEach(listaEmpleados ->{
                    System.out.println(listaEmpleados);
                });
        MenuEmpleado.Listar();
    }



}