package co.edu.myfinalproyect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class DuenoDeCargaMainActivity extends AppCompatActivity {

    Toolbar toolbar;
    String dato;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dueno_de_carga_main);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setDefaultDisplayHomeAsUpEnabled(true);

        dato = getIntent().getStringExtra("dato");
    }

    public void onSendMaps1(View v){
        Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id==R.id.opcion1){
            Toast.makeText(this, "FUTURAS ACTUALIZACIONES", Toast.LENGTH_SHORT).show();
        }else if(id==R.id.opcion2){
            Intent intent2 = new Intent(this, AjustesActivity.class);
            startActivity(intent2);
        }else if(id==R.id.opcion3){
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }

        return true;
    }

    //llevarlo a la pantalla para seleccionar el formulario de solicitud de una carga
    public void solicitudCarga(View view){
        Intent intent = new Intent(this, TipoDeCargaActivity.class);
        intent.putExtra("dato",dato+"");
        startActivity(intent);
    }

    public void onSendMaps12(View view) {
        Intent intent = new Intent(getApplicationContext(), UbicacionActivity.class);
        startActivity(intent);
    }
}