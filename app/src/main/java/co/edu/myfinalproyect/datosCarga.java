package co.edu.myfinalproyect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class datosCarga extends AppCompatActivity {

    Button btnAceptar;
    Button btnRechazar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_carga);

        btnAceptar = findViewById(R.id.btnAceptarCarga);

        btnRechazar = findViewById(R.id.btnRechazar);

    }

    public void aceptaCarga(View view){
        Intent intent = new Intent(this, listasCamioneros.class);
        startActivity(intent);
    }

    public void rechazarCarga(View view){
        Intent intent = new Intent(this, PropietarioCamionActivity.class);
        startActivity(intent);
    }
}