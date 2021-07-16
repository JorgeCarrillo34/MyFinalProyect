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
import android.widget.ListView;

public class CargaGranelMainActivity extends AppCompatActivity {

    ListView cargaGranel;
    Toolbar toolbar;
    String dato;
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carga_granel_main);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDefaultDisplayHomeAsUpEnabled(true);
        dato = getIntent().getStringExtra("dato");

        cargaGranel = (ListView) findViewById(R.id.listViewCargaGranel);

        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this,R.array.arrayCiudades,
                android.R.layout.simple_list_item_1);

        cargaGranel.setAdapter(adaptador);

        cargaGranel.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position == 0){
                    Intent intent = new Intent(CargaGranelMainActivity.this, CiudadOrigenMainActivity.class);
                    intent.putExtra("dato",dato+"");
                    startActivity(intent);
                }else if (position==1){
                    Intent intent = new Intent(CargaGranelMainActivity.this, CiudadDestinoMainActivity.class);
                    intent.putExtra("dato",dato+"");
                    startActivity(intent);
                }
            }
        });

    }
}