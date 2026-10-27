import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Agenda {

    //map nomre -> contacto y treemap para busqueda por nombre y orden alfabetico
    private Map<String, Contacto> contactos = new TreeMap<>();

    // set con los nombres de los grupos y treeset para evitar duplicados y mostrarlos en orden alfabetico
    private  Set<String> grupos = new TreeSet<>();

    //map grupo > el conjunto de nombres de contactos que van en ese grupo
    private Map<String, Set<String>> contactosPorGrupo = new TreeMap<>();

    //lista con los contactos en orden que se agregarin
    private List<Contacto> historial = new ArrayList<>();

    // contactos
    //& agregar un contacto al map y al historial,
    public void agregarContacto(Contacto c){// por que c porfe ?
        //dataso
        //con containskey revisa si hay un contacto con ese nombre en el map
        //generamos la condicion
        if (contactos.containsKey(c.getNombre())){
            System.out.println("error ya existe un contacto con el nombre "+c.getNombre());
            return; // se sale del metodo sin agregar nada

        }
        contactos.put(c.getNombre(), c); //cuarda en el map asi clave-nombre y vlaor-contacto
        historial.add(c);// aca guarda el final de la lista recorrida segun ingrese

        System.out.println("contacto agrefaro "+c.getNombre());


    }

    // vamos a buscar un contacto por su nombre
    public Contacto buscarContacto(String nombre){
        return contactos.get(nombre);//el get va a devolver null cuando la clave no exista
    }
    //vamos a eliminar el contacto del map
    public boolean eliminarContacto(String nombre){
        //para remover con remove y devuelve el contacto eliminado
        Contacto eliminado = contactos.remove(nombre);
        if (eliminado ==null){
            return false;// devuleve tru si lo elimino
        }
        // quitamos del historial el mismo objeto que sacamos del map
        historial.remove(eliminado);
        //recorremos cada grupo
        for (Set<String>miembros : contactosPorGrupo.values()){
            miembros.remove(nombre);//  si no estaba en ese grupo pue sno pasa nada

        }
        return true;// true si se elimino correctamente

    }

    // vamos a mostrar todos los contactos en orden alfabetico
    // para eso el treemap los tiene ordenados
    public void listarContactos(){
        System.out.println("lista de contactos ordenados alfabeticamente");
        if (contactos.isEmpty()){// es para ver si la lista esta vacia
            System.out.println("no hay contactos");
            return;
        }
        // ah si values devuelve los contactos en el orden
        for (Contacto c : contactos.values()){
            System.out.println(c);
        }
    }

    // mostramos los contactos en el orden que se van agregando
    // esto recorre el array
    public void listarHistorial(){
        System.out.println("historial en orden ");
        if (historial.isEmpty()){
            System.out.println("no hay contactos en el historial");
            return;
        }
        for (Contacto c : historial){
            System.out.println(c);
        }
    }

    // grupos
    // agregar un grupo nuevo
    public void agregarGrupo(String nombreGrupo){
        // add devuelve false cuando el elemento ya este en el set
        if ( !grupos.add(nombreGrupo)){
            System.out.println("error el grupo "+nombreGrupo +" ya existe ");
            // muestra error si ya existe

            return;
        }
        //creamos un conjunto vacio
        contactosPorGrupo.put(nombreGrupo, new TreeSet<>());
        System.out.println("grupo "+ nombreGrupo+ "creado");
    }

    //agregar un contacto al grupo
    public void agregarContactoAGrupo(String nombreContacto, String nombreGrupo) {
        // primero toca validar su ya existe
        if (!contactos.containsKey(nombreContacto)){
            System.out.println("error el contacto" + nombreContacto+ "no existe");
            return;
        }
        // validamos que el grupo exista
        if (!grupos.contains(nombreGrupo)) {
            System.out.println("error el grupo " + nombreGrupo + " no existe");
            return;
        }
        // vamos a obtener el conjunto del grupo y de paso agreagamos el nombre del contacto
        contactosPorGrupo.get(nombreGrupo).add(nombreContacto);
        System.out.println("contacto agregado al grupo " + nombreGrupo);

    }

    // muestra los grupos en ordenn alfabetico
    public void listarGrupos() {
        System.out.println("grupos");
        if(grupos.isEmpty()){
            System.out.println("no hay grupos");
            return;
        }
        for (String grupo : grupos) {
            System.out.println(grupo);
        }

    }

    // muestra los contactos que pertenecen al grupo
    public void mostrarContactosPorGrupo(String nombreGrupo) {
        // si el grupo no existe mostramos error
        if (!grupos.contains(nombreGrupo)) {
            System.out.println("error el grupo " + nombreGrupo + " no existe");
            return;
        }
        // obtenemos los nombres de los contactos del grupo
        Set<String> miembros = contactosPorGrupo.get(nombreGrupo);
        // si el grupo existe pero no tiene contactos y  avisamos
        if (miembros.isEmpty()) {
            System.out.println("el grupo " + nombreGrupo + " no tiene contactos");
            return;
        }
        System.out.println("contactos en " + nombreGrupo);
        for (String nombre : miembros) {
            // con el nombre buscamos el contacto completo en el map para imprimir todos sus datos
            System.out.println(contactos.get(nombre));
        }
    }

}
