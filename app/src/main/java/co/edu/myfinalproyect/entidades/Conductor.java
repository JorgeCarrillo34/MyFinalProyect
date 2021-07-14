package co.edu.myfinalproyect.entidades;

public class Conductor {

    private int id;
    private String nombre;
    private String apellido;
    private String correo;
    private String contraseña;
    private String Fecha;
    private String sexo;
    private String trabajo;
    private String calle;
    private String pais;


    public Conductor(int id, String nombre, String apellido, String correo, String contraseña, String fecha, String sexo, String trabajo ) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contraseña = contraseña;
        this.Fecha = fecha;
        this.sexo=sexo;
        this.calle=calle;
        this.pais=pais;
        this.trabajo=trabajo;
    }

    public Conductor(String calle, String pais) {
        this.calle = calle;
        this.pais = pais;
    }

    public Conductor() {

    }

    public String getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(String trabajo) {
        this.trabajo = trabajo;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
