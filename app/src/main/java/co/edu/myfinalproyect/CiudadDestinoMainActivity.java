package co.edu.myfinalproyect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import co.edu.myfinalproyect.LoginActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class CiudadDestinoMainActivity extends AppCompatActivity {

    ListView ciudadDestino;

    EditText direc;
    String dato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciudad_destino_main);

        //direc = (EditText) findViewById(R.id.direccion);
        //dato = getIntent().getStringExtra("dato");

        /*ConexionSQLHelper conn = new ConexionSQLHelper(getApplicationContext());
        SQLiteDatabase db = conn.getWritableDatabase();

        db.execSQL("UPDATE DuenoCarga SET lugar = '"+direc.getText().toString() +"' where id like "+dato);*/


        ciudadDestino = (ListView) findViewById(R.id.listViewCiudadDestino);

        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this,R.array.arrayCiudadOrigen,
                android.R.layout.simple_list_item_1);


        ciudadDestino.setAdapter(adaptador);
        ciudadDestino.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 1){
                    Intent intent = new Intent(CiudadDestinoMainActivity.this, CargaGeneralMainActivity.class);
                    startActivity(intent);
                    Toast.makeText(parent.getContext(), "Seleccionaste ciudad destino" +parent.getItemAtPosition(position).toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public void enviarSolicitud (View view){
        Intent intent = new Intent(CiudadDestinoMainActivity.this, enviarSolicitudActivity.class);
        startActivity(intent);
    }
}

