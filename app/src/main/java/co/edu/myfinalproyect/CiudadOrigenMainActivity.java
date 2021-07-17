package co.edu.myfinalproyect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class CiudadOrigenMainActivity extends AppCompatActivity {

    ListView ciudadorigen;
    String dato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciudad_origen_main);
        dato = getIntent().getStringExtra("dato");


       /* ConexionSQLHelper conn = new ConexionSQLHelper(getApplicationContext());
        SQLiteDatabase db = conn.getWritableDatabase();

        db.execSQL("UPDATE DuenoCarga SET lugar = '"+direc.getText().toString() +"' where id like "+dato);*/

        ciudadorigen = (ListView) findViewById(R.id.listViewCiudadorigen);

        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this,R.array.arrayCiudadOrigen,
                android.R.layout.simple_list_item_1);

        ciudadorigen.setAdapter(adaptador);


        ciudadorigen.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Intent intent = new Intent(CiudadOrigenMainActivity.this, CargaGeneralMainActivity.class);
                    startActivity(intent);
                    Toast.makeText(parent.getContext(), "Seleccionaste ciudad " +parent.getItemAtPosition(position).toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}