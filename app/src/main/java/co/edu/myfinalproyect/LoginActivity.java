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
    ConexionSQLHelper conn= new ConexionSQLHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnlogin = (Button) findViewById(R.id.buttonLogin);

    }


    public void registro(View view) {
        Spinner usuario = (Spinner) findViewById(R.id.spinner);
        String selectedUser = String.valueOf(usuario.getSelectedItem());

        btnlogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText id = (EditText) findViewById(R.id.edit_id);
                EditText pass = (EditText) findViewById(R.id.edit_Password);
                try {
                    SQLiteDatabase db = conn.getReadableDatabase();
                    Cursor cursor = conn.consultarUsuPas(db, id.getText().toString(), pass.getText().toString());
                    if (cursor.getCount() > 0) {
                        Toast.makeText(getApplicationContext(), "Si se encuentra", Toast.LENGTH_LONG).show();

                        /*
                        if ((db.execSQL("Select trabajo from db_transporte where id = " +id+ "  AND trabajo = 'Conductor' ")).equals("Conductor")){
                            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                            startActivity(intent);

                        } else if(selectedUser.equals("Dueño De Carga")){
                            Intent intent = new Intent(getApplicationContext(), DuenoDeCargaMainActivity.class);
                            startActivity(intent);
                        } else{
                            Intent intent = new Intent(getApplicationContext(), PropietarioCamionActivity.class);
                            startActivity(intent);
                        }
                        */
                    } else {
                        Log.v("//////////////", " " + cursor.getCount());
                        Toast.makeText(getApplicationContext(), "Usuario o contraseña incorrecta", Toast.LENGTH_LONG).show();
                    }
                    id.setText("");
                    pass.setText("");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        if (selectedUser.equals("Conductor")) {
            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
            startActivity(intent);

        } else if (selectedUser.equals("Dueño De Carga")) {
            Intent intent = new Intent(getApplicationContext(), DuenoDeCargaMainActivity.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(getApplicationContext(), PropietarioCamionActivity.class);
            startActivity(intent);

        }
    }

    public void registro1(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}