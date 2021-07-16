package co.edu.myfinalproyect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import co.edu.myfinalproyect.*;
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

import co.edu.myfinalproyect.entidades.Conductor;
import co.edu.myfinalproyect.entidades.DuenoCamion;
import co.edu.myfinalproyect.entidades.DuenoCarga;

public class LoginActivity extends AppCompatActivity {

    Button btnlogin;

    private int id1;
    private Spinner trabajo;
    private String selectedUser;

    MapsActivity map;
    //NO LLEVA EL ID

    public String getSelectedUser() {
        return selectedUser;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnlogin = (Button) findViewById(R.id.buttonLogin);

    }

    public void registro(View view) {

        /**
        Spinner usuario = (Spinner) findViewById(R.id.spinner);
        String selectedUser = String.valueOf(usuario.getSelectedItem());
        **/

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
                    trabajo=(Spinner)findViewById(R.id.spinner);
                    selectedUser = trabajo.getSelectedItem().toString();
                        if (selectedUser.equals("Dueño De Carga")){
                            selectedUser = "DuenoCarga";
                        }else if(selectedUser.equals("Dueño De Camion")){
                            selectedUser = "DuenoCamion";
                        }

                    Log.v("TRABAJO///",selectedUser);
                    Cursor cursor = conn.getData(id2, selectedUser);

                    if (cursor.moveToFirst()){
                        do {
                            int contra = cursor.getColumnIndex("contraseña"); //index de la columna contraseña
                            String con1=cursor.getString(contra);//deme el dato de esa columna
                            Log.v("CONTRASEÑA///",con1);
                            int NumTrabajo = cursor.getColumnIndex("trabajo");
                            String trab = cursor.getString(NumTrabajo);

                            if(con1.equals(pass.getText().toString())) { //si la contra de la bd es igual a la que ingreso el user

                                id1 = Integer.parseInt(id.getText().toString());

                                Log.v("ID///",id1+"");
                                Log.v("Id despues", id.getText().toString());
                                if (selectedUser.equals("Conductor")) {
                                    Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                                    intent.putExtra("dato",id1+"");
                                    startActivity(intent);
                                } else if (selectedUser.equals("DuenoCarga")) {
                                    Intent intent = new Intent(getApplicationContext(), DuenoDeCargaMainActivity.class);
                                    intent.putExtra("dato",id1+"");
                                    startActivity(intent);
                                } else if (selectedUser.equals("DuenoCamion")){
                                    Intent intent = new Intent(getApplicationContext(), PropietarioCamionActivity.class);
                                    intent.putExtra("dato",id1+"");
                                    startActivity(intent);
                                }
                                cursor.close();
                            }else {
                                Toast.makeText(getApplicationContext(), "Contraseña, id incorrecto o usuario incorrecto", Toast.LENGTH_LONG).show();
                            }
                            id.setText("");
                            pass.setText("");
                        }while(cursor.moveToNext());
                    }

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