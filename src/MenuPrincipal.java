import java.util.Scanner;
public class MenuPrincipal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // para leer la entrada
        Agenda agenda = new Agenda();
        boolean salir = false;

        // bucle principal
        while (!salir) {
            mostrarMenu();// imprime las opciones

            // validamos que lo escrito sea un numero entero antes de leerlo
            if (!scanner.hasNextInt()) {
                scanner.nextLine();//lees lo que escriben por ocnsola
                System.out.println("opcion invalida intenta de nuevo");
                continue; // dataso esto no ayuda a que vuelva al inicio del while
            }
            int op = scanner.nextInt();// lee el numero seleccionado
            scanner.nextLine();// limpia

            // ahora un switch que ejecuta el bloque que va a la op elegida
            switch (op) {
                case 1:
                    System.out.println("agregar contacto");
                    System.out.println("nombre");
                    String nombre = scanner.nextLine();// nextline nos permite nombre con espaciosn

                    System.out.println("telefono");
                    String telefono = scanner.nextLine();

                    System.out.print("email");
                    String email = scanner.nextLine();

                    //creamos el contacto con los datos para pasarlo a la agenda
                    agenda.agregarContacto(new Contacto(nombre, telefono, email));
                    break;

                case 2:
                    System.out.println("buscar contacto");
                    System.out.println("nombre");
                    String nombreBuscar = scanner.nextLine();
                    Contacto encontrado = agenda.buscarContacto(nombreBuscar);
                    if (encontrado != null) {
                        System.out.println(encontrado);
                    } else {
                        System.out.println("contacto no encontrado " + nombreBuscar);
                    }

                    break;

                case 3:
                    System.out.println("eliminar contacto");
                    System.out.println("nombre");
                    String nombreEliminar = scanner.nextLine();

                    //eliminarcontacto devuelve true si lo elimino
                    if (agenda.eliminarContacto(nombreEliminar)) {
                        System.out.println("contacto eliminado " + nombreEliminar);
                    } else {
                        System.out.println("contacto no encontrado " + nombreEliminar);
                    }
                    break;

                case 4:
                    agenda.listarContactos();
                    break;

                case 5:
                    agenda.listarHistorial();
                    break;

                case 6:
                    System.out.print("nombre del grupo ");
                    String nombreGrupo = scanner.nextLine();
                    agenda.agregarGrupo(nombreGrupo);
                    break;

                case 7:
                    System.out.print("nombre del contacto ");
                    String contactoGrupo = scanner.nextLine();
                    System.out.print("nombre del grupo ");
                    String grupoDestino = scanner.nextLine();
                    agenda.agregarContactoAGrupo(contactoGrupo, grupoDestino);
                    break;

                case 8:
                    agenda.listarGrupos();
                    break;

                case 9:
                    System.out.print("nombre del grupo ");
                    String grupoMostrar = scanner.nextLine();
                    agenda.mostrarContactosPorGrupo(grupoMostrar);
                    break;

                case 10: // Salir
                    System.out.println("saliendo de la agenda");
                    salir = true;  // Hace que el while termine
                    break;

                default://cualquier otro numero lo invalidamos
                    System.out.println("opcion invalida, por favor intente de nuevo");


            }
            System.out.println();// pasa separar un pococ por que no se como hacer otro salto de liena

        }

        scanner.close();

    }
    // menu
    private static void mostrarMenu(){
        System.out.println("agenda de contactos ");
        System.out.println("1. agregar contacto");
        System.out.println("2. buscar contacto");
        System.out.println("3. eliminar contacto");
        System.out.println("4. ver lita de contacto en orden alfabetico");
        System.out.println("5. ver lista historial ");
        System.out.println("6. agregar grupo");
        System.out.println("7. agregar contacto al grupo");
        System.out.println("8.  ver lista de grupos");
        System.out.println("9. mostrar contactos por grupo");
        System.out.println("10. salir");




    }
}