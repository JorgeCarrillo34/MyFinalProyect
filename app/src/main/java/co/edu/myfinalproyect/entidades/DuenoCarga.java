package co.edu.myfinalproyect.entidades;

public class DuenoCarga {

    private int id;
    private String nombre;
    private String apellido;
    private String correo;
    private String contraseña;
    private String Fecha;
    String sexo;
    private String trabajo;

    public DuenoCarga(int id, String nombre, String apellido, String correo, String contraseña, String fecha, String sexo, String trabajo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contraseña = contraseña;
        this.Fecha = fecha;
        this.sexo = sexo;
        this.trabajo = trabajo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }
}
