package co.edu.myfinalproyect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CargaPeligrosaMainActivity extends AppCompatActivity {

    ListView cargaPeligrosa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carga_peligrosa_main);


        cargaPeligrosa = (ListView) findViewById(R.id.listViewCargaPeligrosa);

        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this,R.array.arrayCiudades,
                android.R.layout.simple_list_item_1);

        cargaPeligrosa.setAdapter(adaptador);

        cargaPeligrosa.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position == 0){
                    Intent intent = new Intent(CargaPeligrosaMainActivity.this, CiudadOrigenMainActivity.class);
                    startActivity(intent);
                }else if (position==1){
                    Intent intent = new Intent(CargaPeligrosaMainActivity.this, CiudadDestinoMainActivity.class);
                    startActivity(intent);
                }
            }
        });


    }
}