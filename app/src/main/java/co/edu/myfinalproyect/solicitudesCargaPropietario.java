package co.edu.myfinalproyect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class solicitudesCargaPropietario extends AppCompatActivity {

    ListView listaCargas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitudes_carga_propietario);

        listaCargas = (ListView) findViewById(R.id.listaCargasSoli);

        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this,R.array.arraySolicitudesCarga,
                android.R.layout.simple_list_item_1);

        listaCargas.setAdapter(adaptador);

        listaCargas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position == 0){
                    Intent intent = new Intent(solicitudesCargaPropietario.this, datosCarga.class);
                    startActivity(intent);
                }
            }
        });








    }
}