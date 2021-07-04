package co.edu.myfinalproyect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CargaPerecederaMainActivity extends AppCompatActivity {

    ListView cargaPerecedera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carga_perecedera_main);

        cargaPerecedera = (ListView) findViewById(R.id.listViewCargaPerecedera);

        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this,R.array.arrayCiudades,
                android.R.layout.simple_list_item_1);

        cargaPerecedera.setAdapter(adaptador);

        cargaPerecedera.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position == 0){
                    Intent intent = new Intent(CargaPerecederaMainActivity.this, CiudadOrigenMainActivity.class);
                    startActivity(intent);
                }else if (position==1){
                    Intent intent = new Intent(CargaPerecederaMainActivity.this, CiudadDestinoMainActivity.class);
                    startActivity(intent);
                }
            }
        });


    }
}