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

public class CargaPeligrosaMainActivity extends AppCompatActivity {

    ListView cargaPeligrosa;
    Toolbar toolbar;
    String dato;
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carga_peligrosa_main);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDefaultDisplayHomeAsUpEnabled(true);
        dato = getIntent().getStringExtra("dato");

        cargaPeligrosa = (ListView) findViewById(R.id.listViewCargaPeligrosa);

        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this,R.array.arrayCiudades,
                android.R.layout.simple_list_item_1);

        cargaPeligrosa.setAdapter(adaptador);

        cargaPeligrosa.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position == 0){
                    Intent intent = new Intent(CargaPeligrosaMainActivity.this, CiudadOrigenMainActivity.class);
                    intent.putExtra("dato",dato+"");
                    startActivity(intent);
                }else if (position==1){
                    Intent intent = new Intent(CargaPeligrosaMainActivity.this, CiudadDestinoMainActivity.class);
                    intent.putExtra("dato",dato+"");
                    startActivity(intent);
                }
            }
        });


    }
}