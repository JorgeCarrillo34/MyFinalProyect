package co.edu.myfinalproyect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CiudadOrigenMainActivity extends AppCompatActivity {

    ListView ciudadorigen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciudad_origen_main);

        ciudadorigen = (ListView) findViewById(R.id.listViewCiudadorigen);

        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this,R.array.arrayCiudadOrigen,
                android.R.layout.simple_list_item_1);

        ciudadorigen.setAdapter(adaptador);

    }
}