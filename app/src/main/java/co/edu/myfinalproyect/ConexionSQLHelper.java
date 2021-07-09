package co.edu.myfinalproyect;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import co.edu.myfinalproyect.utilidades.Utilidades;


public class ConexionSQLHelper extends SQLiteOpenHelper{

    public static final int DATABASE_V=9;
    public static final String DATABASE_N="db_transporte";

    public ConexionSQLHelper(@Nullable Context context) {
        super(context, DATABASE_N, null, DATABASE_V);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utilidades.CREAR_TABLA_CONDUCTOR);
        db.execSQL(Utilidades.CREAR_TABLA_DUENOCARGA);
        db.execSQL(Utilidades.CREAR_TABLA_DUENOCAMION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Conductor ");
        db.execSQL("DROP TABLE IF EXISTS DuenoCamion ");
        db.execSQL("DROP TABLE IF EXISTS DuenoCarga ");
        onCreate(db);
    }
    
    public Cursor consultarUsuPas (SQLiteDatabase db, String usu, String pass) throws SQLException{
        Cursor mcursor=null;
        mcursor = db.query(DATABASE_N,new String[]{"id","contraseña"},
                "id like '" +usu+ "' " + "and contraseña like '" +pass+ "'", null,null,null,null,null);
        return mcursor;
    }
}
