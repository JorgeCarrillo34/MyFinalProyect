package co.edu.myfinalproyect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class CargaFragilMainActivity extends AppCompatActivity {

    ListView cargaFragil;
    Toolbar toolbar;
    String dato;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carga_fragil_main);

        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDefaultDisplayHomeAsUpEnabled(true);
        dato = getIntent().getStringExtra("dato");

        cargaFragil = (ListView) findViewById(R.id.listViewCargaFragil);

        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this,R.array.arrayCiudades,
                android.R.layout.simple_list_item_1);

        cargaFragil.setAdapter(adaptador);

        cargaFragil.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position == 0){
                    Intent intent = new Intent(CargaFragilMainActivity.this, CiudadOrigenMainActivity.class);
                    intent.putExtra("dato",dato+"");
                    startActivity(intent);
                }else if (position==1){
                    Intent intent = new Intent(CargaFragilMainActivity.this, CiudadDestinoMainActivity.class);
                    intent.putExtra("dato",dato+"");
                    startActivity(intent);
                }
            }
        });

    }
}