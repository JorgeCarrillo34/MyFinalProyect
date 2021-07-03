package co.edu.myfinalproyect.utilidades;

public class Utilidades {

    public static final String TABLA_CONDUCTOR="Conductor";
    public static final String TABLA_DUENOCARGA="DuenoCarga";
    public static final String TABLA_DUENOCAMION="DuenoCamion";
    public static final String CAMPO_ID="id";
    public static final String CAMPO_nombre="nombre";
    public static final String CAMPO_apelllido="apellido";
    public static final String CAMPO_correo="correo";
    public static final String CAMPO_contraseña="contraseña";
    public static final String CAMPO_Fecha="fecha";
    public static final String CAMPO_sexo="sexo";




    public static final String CREAR_TABLA_CONDUCTOR="CREATE TABLE "+TABLA_CONDUCTOR+
            " ("+CAMPO_ID+" INTEGER, "+CAMPO_nombre+" TEXT, "+CAMPO_apelllido
            +" TEXT, "+CAMPO_correo+" TEXT, "+CAMPO_Fecha+" TEXT, "+CAMPO_contraseña+" TEXT, "+CAMPO_sexo+" TEXT ) ";
    public static final String CREAR_TABLA_DUENOCARGA="CREATE TABLE "+TABLA_DUENOCARGA+
            " ("+CAMPO_ID+" INTEGER, "+CAMPO_nombre+" TEXT, "+CAMPO_apelllido+
            " TEXT, "+CAMPO_correo+" TEXT, "+CAMPO_Fecha+" TEXT, "+CAMPO_contraseña+" TEXT, "+CAMPO_sexo+" TEXT ) ";
    public static final String CREAR_TABLA_DUENOCAMION="CREATE TABLE "+TABLA_DUENOCAMION+
            " ("+CAMPO_ID+" INTEGER, "+CAMPO_nombre+" TEXT, "+CAMPO_apelllido+
            " TEXT, "+CAMPO_correo+" TEXT, "+CAMPO_Fecha+" TEXT, "+CAMPO_contraseña+" TEXT, "+CAMPO_sexo+" TEXT ) ";




}
