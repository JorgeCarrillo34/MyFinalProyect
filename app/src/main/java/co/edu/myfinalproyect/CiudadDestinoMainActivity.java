package co.edu.myfinalproyect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CiudadDestinoMainActivity extends AppCompatActivity {

    ListView ciudadDestino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciudad_destino_main);

        ciudadDestino = (ListView) findViewById(R.id.listViewCiudadDestino);

        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this,R.array.arrayCiudadOrigen,
                android.R.layout.simple_list_item_1);

        ciudadDestino.setAdapter(adaptador);


    }
}

