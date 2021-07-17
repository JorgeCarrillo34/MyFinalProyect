package co.edu.myfinalproyect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import co.edu.myfinalproyect.entidades.Conductor;

public class PropietarioCamionActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private String dato;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_propietario_camion);

        toolbar=findViewById(R.id.toolbarPropietario);
        setSupportActionBar(toolbar);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setDefaultDisplayHomeAsUpEnabled(true);

        dato = getIntent().getStringExtra("dato");
    }
    public void onSendMaps1(View v){
        Intent intent2 = new Intent(this, UbicacionActivity.class);
        intent2.putExtra("dato",dato);
        startActivity(intent2);
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
            Intent intent3 = new Intent(this, solicitudesCargaPropietario.class);
            startActivity(intent3);
            Toast.makeText(this, "Conoce tus solicitudes de carga", Toast.LENGTH_SHORT).show();
        }else if(id==R.id.opcion2){
            Intent intent2 = new Intent(this, AjustesActivity.class);
            startActivity(intent2);
        }else if(id==R.id.opcion3){
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }

        return true;
    }


    public void solicitud(View view) {
        Intent intent = new Intent(this, solicitudesCargaPropietario.class);
        startActivity(intent);
    }
}