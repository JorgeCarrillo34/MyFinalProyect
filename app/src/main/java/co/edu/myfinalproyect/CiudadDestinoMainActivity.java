package co.edu.myfinalproyect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import co.edu.myfinalproyect.LoginActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CiudadDestinoMainActivity extends AppCompatActivity {

    ListView ciudadDestino;
    ConexionSQLHelper conn= new ConexionSQLHelper(this);
    SQLiteDatabase db = conn.getReadableDatabase();
    LoginActivity plan = new LoginActivity();
    private int id = plan.getId1();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciudad_destino_main);

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

