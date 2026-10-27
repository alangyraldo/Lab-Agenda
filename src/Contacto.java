public class Contacto {

    // atributos privados que s epuedan cambiar mediante gettter y settars
    private String nombre;// van a ser la clave en el map de la agenda
    private String telefono;
    private String email;

    // creamos el constructor
    public Contacto(String nombre, String telefono, String email){
        this.nombre = nombre; // generamos los atributos y su parametro
        this.telefono = telefono;
        this.email = email;

    }

    // getters para devolver el valor del atributo


    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    //setter para setear el valor del atributo recibito
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //tostring va a definir como se ve el contanto cuando se imprime
    @Override
    public String toString(){
        //y vamos a generar el formato que solicitan
        return nombre + "telefono " + telefono + " email " + email;

    }







}
