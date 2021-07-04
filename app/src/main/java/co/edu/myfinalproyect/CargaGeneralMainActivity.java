package co.edu.myfinalproyect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class CargaGeneralMainActivity extends AppCompatActivity {

    ListView cargaGeneral;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carga_general_main);

        cargaGeneral = (ListView) findViewById(R.id.listViewCargaGeneral);

        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this,R.array.arrayCiudades,
                android.R.layout.simple_list_item_1);

        cargaGeneral.setAdapter(adaptador);

        cargaGeneral.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position == 0){
                    Intent intent = new Intent(CargaGeneralMainActivity.this, CiudadOrigenMainActivity.class);
                    startActivity(intent);
                }else if (position==1){
                    Intent intent = new Intent(CargaGeneralMainActivity.this, CiudadDestinoMainActivity.class);
                    startActivity(intent);
                }
            }
        });





    }
}