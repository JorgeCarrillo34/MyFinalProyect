package co.edu.myfinalproyect.utilidades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
    public static final String CAMPO_trabajo="trabajo";
    public static final String CAMPO_origen="origen";
    public static final String CAMPO_destino="destino";
    public static final String CAMPO_calle="calle";
    public static final String CAMPO_pais="pais";


    public static final String CREAR_TABLA_CONDUCTOR="CREATE TABLE "+TABLA_CONDUCTOR+
            " ("+CAMPO_ID+" INTEGER PRIMARY KEY, "+CAMPO_nombre+" TEXT, "+CAMPO_apelllido
            +" TEXT, "+CAMPO_correo+" TEXT, "+CAMPO_Fecha+" TEXT, "+CAMPO_contraseña+
            " TEXT, "+CAMPO_sexo+" TEXT, "+CAMPO_trabajo+" TEXT,  "+CAMPO_calle+" TEXT, "+CAMPO_pais+" TEXT )" ;
    public static final String CREAR_TABLA_DUENOCARGA="CREATE TABLE "+TABLA_DUENOCARGA+
            " ("+CAMPO_ID+" INTEGER PRIMARY KEY, "+CAMPO_nombre+" TEXT, "+CAMPO_apelllido+
            " TEXT, "+CAMPO_correo+" TEXT, "+CAMPO_Fecha+" TEXT, "+CAMPO_contraseña+
            " TEXT, "+CAMPO_sexo+" TEXT, "+CAMPO_trabajo+" TEXT," +CAMPO_origen+
            " TEXT,"+CAMPO_destino+" TEXT ) ";
    public static final String CREAR_TABLA_DUENOCAMION="CREATE TABLE "+TABLA_DUENOCAMION+
            " ("+CAMPO_ID+" INTEGER PRIMARY KEY, "+CAMPO_nombre+" TEXT, "+CAMPO_apelllido+
            " TEXT, "+CAMPO_correo+" TEXT, "+CAMPO_Fecha+" TEXT, "+CAMPO_contraseña+
            " TEXT, "+CAMPO_sexo+" TEXT, "+CAMPO_trabajo+" TEXT )";




}
