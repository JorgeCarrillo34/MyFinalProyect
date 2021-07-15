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
import android.widget.Toolbar;

import co.edu.myfinalproyect.entidades.Conductor;
import co.edu.myfinalproyect.entidades.DuenoCamion;
import co.edu.myfinalproyect.entidades.DuenoCarga;
import co.edu.myfinalproyect.utilidades.Utilidades;

public class MainActivity extends AppCompatActivity {

    EditText campoId, campoNombre,campoApellido, campoCorreo, campoFecha, campoContraseña,confi;
    Spinner trabajo;
    private int gender;
    private String sex, selectedUser;


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
        confi=(EditText) findViewById(R.id.contraConfirm);

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

        trabajo=(Spinner)findViewById(R.id.spinnerRegistro);
        selectedUser = trabajo.getSelectedItem().toString();
        Log.v("Trabajo////", selectedUser);
        registrarUsuarios();
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);

    }

    private void registrarUsuarios() {
        try {

            ConexionSQLHelper conn = new ConexionSQLHelper(this);
            SQLiteDatabase db = conn.getWritableDatabase();
            long idResultante=0;
            trabajo=(Spinner)findViewById(R.id.spinnerRegistro);
            selectedUser = trabajo.getSelectedItem().toString();

            if (campoId.getText().toString().equals("") || campoNombre.getText().toString().equals("") || campoApellido.getText().toString().equals("")
            || campoCorreo.getText().toString().equals("") || campoFecha.getText().toString().equals("") || campoContraseña.getText().toString().equals("")
            || sex.equals("") || selectedUser.equals("") || confi.equals("")){
                Toast.makeText(getApplicationContext(), "Debe ingresar datos", Toast.LENGTH_LONG).show();
            } else if(campoContraseña.getText().toString().equals(confi.getText().toString())){


                ContentValues values = new ContentValues();
                values.put(Utilidades.CAMPO_ID, campoId.getText().toString());
                values.put(Utilidades.CAMPO_nombre, campoNombre.getText().toString());
                values.put(Utilidades.CAMPO_apelllido, campoApellido.getText().toString());
                values.put(Utilidades.CAMPO_correo, campoCorreo.getText().toString());
                values.put(Utilidades.CAMPO_Fecha, campoFecha.getText().toString());
                values.put(Utilidades.CAMPO_contraseña, campoContraseña.getText().toString());
                values.put(Utilidades.CAMPO_sexo, sex);
                values.put(Utilidades.CAMPO_trabajo, selectedUser);

                if (selectedUser.equals("Conductor")) {
                    idResultante = db.insert(Utilidades.TABLA_CONDUCTOR, Utilidades.CAMPO_ID, values);
                    Conductor cond = new Conductor(campoId.getId(),campoNombre.getText().toString(),campoApellido.getText().toString(),
                            campoCorreo.getText().toString(),campoFecha.getText().toString(),campoContraseña.getText().toString(),sex,selectedUser);
                } else if (selectedUser.equals("Dueño De Carga")) {
                    idResultante = db.insert(Utilidades.TABLA_DUENOCARGA, Utilidades.CAMPO_ID, values);
                    DuenoCarga duenCar = new DuenoCarga(campoId.getId(),campoNombre.getText().toString(),campoApellido.getText().toString(),
                            campoCorreo.getText().toString(),campoFecha.getText().toString(),campoContraseña.getText().toString(),sex,selectedUser);
                } else {
                    idResultante = db.insert(Utilidades.TABLA_DUENOCAMION, Utilidades.CAMPO_ID, values);
                    DuenoCamion duenCam = new DuenoCamion(campoId.getId(),campoNombre.getText().toString(),campoApellido.getText().toString(),
                            campoCorreo.getText().toString(),campoFecha.getText().toString(),campoContraseña.getText().toString(),sex,selectedUser);
                }

                if (idResultante > 0) {
                    Toast.makeText(getApplicationContext(), "Registro guardado", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                }
            }else {
                Toast.makeText(getApplicationContext(), "Las contraseñas deben coincidir", Toast.LENGTH_LONG).show();
                Log.v("Contraseña", " " + campoContraseña.getText().toString());
                Log.v("Confirmar Contraseña", " " + confi);
            }
            db.close();

            campoId.setText("");
            campoContraseña.setText("");
            campoFecha.setText("");
            campoCorreo.setText("");
            campoApellido.setText("");
            campoNombre.setText("");
            confi.setText("");
        }catch (Exception ex){
            ex.toString();
        }
    }

    public void registro1(View view){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}