package co.edu.myfinalproyect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class pantallaAsignacionCarga extends AppCompatActivity {

    Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_asignacion_carga);

        btnVolver = findViewById(R.id.btnBack);

    }

    public void volverPantallaInicio(View view){
        Intent intent = new Intent(pantallaAsignacionCarga.this, PropietarioCamionActivity.class);
        startActivity(intent);
    }








}