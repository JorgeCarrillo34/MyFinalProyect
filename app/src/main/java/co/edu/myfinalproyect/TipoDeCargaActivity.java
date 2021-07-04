package co.edu.myfinalproyect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class TipoDeCargaActivity extends AppCompatActivity {

    ListView listaCarga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_de_carga);

        listaCarga = (ListView) findViewById(R.id.listViewId);

        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this,R.array.arrayCargas,
                android.R.layout.simple_list_item_1);

        listaCarga.setAdapter(adaptador);

        //lo va a mandar a la activity del tipo de carga que selecciono
        listaCarga.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position == 0){
                    Intent intent = new Intent(TipoDeCargaActivity.this, CargaGeneralMainActivity.class);
                    startActivity(intent);

                    Toast.makeText(parent.getContext(), "Seleccionaste " +parent.getItemAtPosition(position).toString(),Toast.LENGTH_SHORT).show();
                }else if (position==1){
                    Intent intent = new Intent(TipoDeCargaActivity.this, CargaGranelMainActivity.class);
                    startActivity(intent);

                    Toast.makeText(parent.getContext(), "Seleccionaste " +parent.getItemAtPosition(position).toString(),Toast.LENGTH_SHORT).show();
                }else if (position==2){
                    Intent intent = new Intent(TipoDeCargaActivity.this, CargaPerecederaMainActivity.class);
                    startActivity(intent);

                    Toast.makeText(parent.getContext(), "Seleccionaste " +parent.getItemAtPosition(position).toString(),Toast.LENGTH_SHORT).show();
                }else if (position==3){
                    Intent intent = new Intent(TipoDeCargaActivity.this, CargaFragilMainActivity.class);
                    startActivity(intent);

                    Toast.makeText(parent.getContext(), "Seleccionaste " +parent.getItemAtPosition(position).toString(),Toast.LENGTH_SHORT).show();
                }else if (position==4){
                    Intent intent = new Intent(TipoDeCargaActivity.this, CargaPeligrosaMainActivity.class);
                    startActivity(intent);

                    Toast.makeText(parent.getContext(), "Seleccionaste " +parent.getItemAtPosition(position).toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}