package co.edu.myfinalproyect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DatoSolicitudCarga extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dato_solicitud_carga);
    }

    public void volverInicio (View view){
        Intent intent = new Intent(DatoSolicitudCarga.this, DuenoDeCargaMainActivity.class);
        startActivity(intent);
    }



}