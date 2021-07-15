package co.edu.myfinalproyect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button btnlogin;

    private int id1;


    public LoginActivity() {
    }

    public int getId1() {
        return id1;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnlogin = (Button) findViewById(R.id.buttonLogin);

    }


    public void registro(View view) {

        btnlogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                EditText id = (EditText) findViewById(R.id.edit_id);
                EditText pass = (EditText) findViewById(R.id.edit_Password);
                Log.v("Id antes",id.getText().toString());
                //Log.v("Id antes2","" + id.getId());
                int id2 = Integer.parseInt(id.getText().toString());
                try {
                    ConexionSQLHelper conn= new ConexionSQLHelper(getApplicationContext());
                    SQLiteDatabase db = conn.getReadableDatabase();
                    Cursor cursor = conn.getData(id2);
                    int contra = cursor.getColumnIndex("contraseña"); //index de la columna contraseña
                    String con1=cursor.getString(contra);//deme el dato de esa columna

                    if (cursor.moveToFirst()==false) {
                        Toast.makeText(getApplicationContext(), "No se encuentran datos, registrate", Toast.LENGTH_LONG).show();
                    }else if(con1.equals(pass.getText().toString())){ //si la contra de la bd es igual a la que ingreso el user
                        int NumTrabajo = cursor.getColumnIndex("trabajo");
                        String trab=cursor.getString(NumTrabajo);
                        id1=id.getId();
                        Log.v("Id despues",id.getText().toString());
                        if (trab.equals("Conductor")){
                            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                            startActivity(intent);
                        } else if(trab.equals("Dueño de Carga")){
                            Intent intent = new Intent(getApplicationContext(), DuenoDeCargaMainActivity.class);
                            startActivity(intent);
                        } else{
                            Intent intent = new Intent(getApplicationContext(), PropietarioCamionActivity.class);
                            startActivity(intent);
                        }
                        cursor.close();
                    }else {
                        Toast.makeText(getApplicationContext(), "Contraseña o id incorrecto", Toast.LENGTH_LONG).show();
                    }
                    id.setText("");
                    pass.setText("");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void registro1(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}