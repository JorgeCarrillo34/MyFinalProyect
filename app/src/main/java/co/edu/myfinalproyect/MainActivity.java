package co.edu.myfinalproyect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import co.edu.myfinalproyect.utilidades.Utilidades;

public class MainActivity extends AppCompatActivity {

    EditText campoId, campoNombre,campoApellido, campoCorreo, campoFecha, campoContraseña;
    private int gender;
    private String sex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConexionSQLHelper conn= new ConexionSQLHelper(this);
        SQLiteDatabase db = conn.getWritableDatabase();
        //conn.onCreate(db);

        campoId=(EditText) findViewById(R.id.numeroDocumento);
        campoNombre=(EditText) findViewById(R.id.nombre);
        campoApellido=(EditText) findViewById(R.id.apellido);
        campoCorreo=(EditText) findViewById(R.id.correoElectronico);
        campoFecha=(EditText) findViewById(R.id.fecha);
        campoContraseña=(EditText) findViewById(R.id.contra);



    }

    public void onRadioButtonClicked(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()){
            case R.id.Hombre:
                if (checked){
                    gender=1;
                }
                break;
            case R.id.Mujer:
                if (checked){
                    gender=0;
                }
                break;
        }

        if (gender==0){
            sex="Mujer";
        }else{
            sex="Hombre";
        }
    }


    public void registroUsuario(View view){
        Spinner usuario = (Spinner)findViewById(R.id.spinnerRegistro);
        String selectedUser = String.valueOf(usuario.getSelectedItem());

        registrarUsuarios();

        if (selectedUser.equals("Conductor")){
            Intent intent = new Intent(this, MenuActivity.class);
            startActivity(intent);
        } else if(selectedUser.equals("Dueño De Carga")){
            Intent intent = new Intent(this, DuenoDeCargaMainActivity.class);
            startActivity(intent);
        } else{
            Intent intent = new Intent(this, PropietarioCamionActivity.class);
            startActivity(intent);
        }
    }

    private void registrarUsuarios() {
        try {

            ConexionSQLHelper conn = new ConexionSQLHelper(this);
            Spinner usuario = (Spinner) findViewById(R.id.spinnerRegistro);
            String selectedUser = String.valueOf(usuario.getSelectedItem());
            SQLiteDatabase db = conn.getWritableDatabase();
            long idResultante=0;

            ContentValues values = new ContentValues();
            values.put(Utilidades.CAMPO_ID, campoId.getText().toString());
            values.put(Utilidades.CAMPO_nombre, campoNombre.getText().toString());
            values.put(Utilidades.CAMPO_apelllido, campoApellido.getText().toString());
            values.put(Utilidades.CAMPO_correo, campoCorreo.getText().toString());
            values.put(Utilidades.CAMPO_Fecha, campoFecha.getText().toString());
            values.put(Utilidades.CAMPO_contraseña, campoContraseña.getText().toString());
            values.put(Utilidades.CAMPO_sexo, sex);

            if (selectedUser.equals("Conductor")) {
                idResultante = db.insert(Utilidades.TABLA_CONDUCTOR, Utilidades.CAMPO_ID, values);
                //Log.v("hola", " " + Utilidades.TABLA_CONDUCTOR );
            } else if (selectedUser.equals("Dueño De Carga")) {
                idResultante = db.insert(Utilidades.TABLA_DUENOCARGA, Utilidades.CAMPO_ID, values);
            } else {
                idResultante = db.insert(Utilidades.TABLA_DUENOCAMION, Utilidades.CAMPO_ID, values);
            }

            if (idResultante>0){
                Toast.makeText(getApplicationContext(), "Registro guardado", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
            }

            db.close();
        }catch (Exception ex){
            ex.toString();
        }
    }

    public void registro1(View view){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}