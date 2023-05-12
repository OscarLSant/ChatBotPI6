public class ClienteBD {
    private String nombre;
    private String telefono;
    private String mensaje;
    /*private ConexionBD conexion;

    public ClienteBD() {
        conexion = new ConexionBD();
    }*/

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setTelefono(String telefono){
        this.telefono = telefono;
    }

    public void setMensaje(String mensaje){
        this.mensaje = mensaje;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getMensaje() {
        return mensaje;
    }
}
