public class ClienteBD {
    private String nombre;
    private String telefono;
    private String mensaje;

    // atributo para la consulta
    private String saludo;
    private String ayuda;
    private String infochatbot;


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


    // getters and setters para las consultas

    public String getSaludo() {
        return saludo;
    }

    public void setSaludo(String saludo) {
        this.saludo = saludo;
    }

    public String getAyuda() {
        return ayuda;
    }

    public void setAyuda(String ayuda) {
        this.ayuda = ayuda;
    }

    public String getInfochatbot() {
        return infochatbot;
    }

    public void setInfochatbot(String infochatbot) {
        this.infochatbot = infochatbot;
    }
}
