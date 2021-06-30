package co.edu.myfinalproyect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

public class LoginActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void registro(View view){
        Spinner usuario = (Spinner)findViewById(R.id.spinner);
        String selectedUser = String.valueOf(usuario.getSelectedItem());

        if (selectedUser.equals("Conductor")){
            Intent intent = new Intent(this, MenuActivity.class);
            startActivity(intent);
        } else if(selectedUser.equals("Dueño De Carga")){
            Intent intent = new Intent(this, DuenoDeCargaMainActivity.class);
            startActivity(intent);
        } else{
            Intent intent = new Intent(this, PropietarioCamionActivity.class);
            startActivity(intent);
        }

    }

    public void registro1(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}