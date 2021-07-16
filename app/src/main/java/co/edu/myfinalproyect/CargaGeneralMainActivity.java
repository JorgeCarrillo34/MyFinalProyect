package co.edu.myfinalproyect;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class CargaGeneralMainActivity extends AppCompatActivity {

    ListView cargaGeneral;
    Toolbar toolbar;
    Button botonEnviar;
    String dato;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carga_general_main);
        toolbar=findViewById(R.id.toolbar);
        botonEnviar=findViewById(R.id.btnEnviarSolicitud);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDefaultDisplayHomeAsUpEnabled(true);
        dato = getIntent().getStringExtra("dato");

        cargaGeneral = (ListView) findViewById(R.id.listViewCargaGeneral);

        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this,R.array.arrayCiudades,
                android.R.layout.simple_list_item_1);

        cargaGeneral.setAdapter(adaptador);

        cargaGeneral.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position == 0){
                    Intent intent = new Intent(CargaGeneralMainActivity.this, CiudadOrigenMainActivity.class);
                    intent.putExtra("dato",dato+"");
                    startActivity(intent);
                }else if (position==1){
                    Intent intent = new Intent(CargaGeneralMainActivity.this, CiudadDestinoMainActivity.class);
                    intent.putExtra("dato",dato+"");
                    startActivity(intent);
                }
            }
        });
    }

    public void enviarSolicitud (View view){
        Intent intent = new Intent(CargaGeneralMainActivity.this, DatoSolicitudCarga.class);
        startActivity(intent);
    }





}