package co.edu.myfinalproyect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class enviarSolicitudActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enviar_solicitud);
    }

    public void enviarSoliCarga (View view){
        Intent intent = new Intent(this, DuenoDeCargaMainActivity.class);
        startActivity(intent);
    }




}