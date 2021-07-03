package co.edu.myfinalproyect;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import co.edu.myfinalproyect.utilidades.Utilidades;


public class ConexionSQLHelper extends SQLiteOpenHelper{

    public static final int DATABASE_V=7;
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
}
