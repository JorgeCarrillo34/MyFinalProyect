package co.edu.myfinalproyect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class listasCamioneros extends AppCompatActivity {

    ListView listaCamioneros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas_camioneros);

        listaCamioneros = (ListView) findViewById(R.id.listaCamioneros);

        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this,R.array.arrayCamioneros,
                android.R.layout.simple_list_item_1);

        listaCamioneros.setAdapter(adaptador);

        listaCamioneros.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position == 0){
                    Intent intent = new Intent(listasCamioneros.this, pantallaAsignacionCarga.class);
                    startActivity(intent);
                }else if (position==1){
                    Intent intent = new Intent(listasCamioneros.this, pantallaAsignacionCarga.class);
                    startActivity(intent);
                }
            }
        });



    }
}