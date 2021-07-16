package co.edu.myfinalproyect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import co.edu.myfinalproyect.entidades.Conductor;

public class UbicacionActivity extends AppCompatActivity {

    TextView campoPais, campoCalle;
    LoginActivity plan = new LoginActivity();
    private String trab=plan.getSelectedUser();
    private String dato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubicacion);
        campoPais=findViewById(R.id.textView2);
        campoCalle=findViewById(R.id.textView1);

        dato = getIntent().getStringExtra("dato");
    }

    public void Onsend(View view) {
        ConexionSQLHelper conn = new ConexionSQLHelper(getApplicationContext());
        SQLiteDatabase db = conn.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * from DuenoCarga where id like "+15,null);
        String lati="";
        String longi="";
        if (cursor.moveToFirst()){
            do {
                lati = cursor.getString(cursor.getColumnIndex("latitud"));
                longi = cursor.getString(cursor.getColumnIndex("longitud"));
            }while(cursor.moveToNext());
        }
        Uri uri=Uri.parse("geo:"+ lati +","+ longi);
        Intent intent= new Intent(Intent.ACTION_VIEW,uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }


}