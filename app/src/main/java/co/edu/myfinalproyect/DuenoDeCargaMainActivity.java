package co.edu.myfinalproyect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DuenoDeCargaMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dueno_de_carga_main);
    }

    //lo devuelve a la pantalla login en caso de que de cerrar sesion
    public void registro1(View view){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    //llevarlo a la pantalla para seleccionar el formulario de solicitud de una carga
    public void solicitudCarga(View view){
        Intent intent = new Intent(this, TipoDeCargaActivity.class);
        startActivity(intent);
    }

}