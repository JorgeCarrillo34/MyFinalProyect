package co.edu.myfinalproyect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import co.edu.myfinalproyect.LoginActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class CiudadDestinoMainActivity extends AppCompatActivity {

    ListView ciudadDestino;
    ConexionSQLHelper conn= new ConexionSQLHelper(this);
    SQLiteDatabase db = conn.getReadableDatabase();
    LoginActivity plan = new LoginActivity();
    EditText direc;
    String dato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciudad_destino_main);
        direc = (EditText) findViewById(R.id.direccion);
        dato = getIntent().getStringExtra("dato");

        ConexionSQLHelper conn = new ConexionSQLHelper(getApplicationContext());
        SQLiteDatabase db = conn.getWritableDatabase();

        db.execSQL("UPDATE DuenoCarga SET lugar = '"+direc.getText().toString() +"' where id like "+dato);


        ciudadDestino = (ListView) findViewById(R.id.listViewCiudadDestino);

        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this,R.array.arrayCiudadOrigen,
                android.R.layout.simple_list_item_1);

        ciudadDestino.setAdapter(adaptador);

    }


    public void enviarSolicitud (View view){
        Intent intent = new Intent(CiudadDestinoMainActivity.this, enviarSolicitudActivity.class);
        startActivity(intent);
    }
}

