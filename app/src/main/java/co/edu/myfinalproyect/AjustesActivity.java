package co.edu.myfinalproyect;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AjustesActivity extends AppCompatActivity {

    Toolbar tool;
    Button ok;
    EditText nom,ape,corre,fech;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes);
        tool=findViewById(R.id.toolbar);
        setSupportActionBar(tool);
        ok = findViewById(R.id.button8);

        nom=findViewById(R.id.editText);
        ape=findViewById(R.id.editText2);
        corre=findViewById(R.id.editText3);
        fech=findViewById(R.id.editText4);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setDefaultDisplayHomeAsUpEnabled(true);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ok(v);
            }
        });
    }

    public void Ok(View view) {
        Toast.makeText(this, "Actualizado", Toast.LENGTH_SHORT).show();
        nom.setText("");
        ape.setText("");
        corre.setText("");
        fech.setText("");
    }
}