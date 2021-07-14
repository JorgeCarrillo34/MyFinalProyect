package co.edu.myfinalproyect;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import co.edu.myfinalproyect.entidades.Conductor;

public class UbicacionActivity extends AppCompatActivity {

    TextView campoPais, campoCalle;
    LoginActivity plan = new LoginActivity();
    private int id = plan.getId1();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubicacion);
        campoPais=findViewById(R.id.textView2);
        campoCalle=findViewById(R.id.textView1);
    }

    public void Onsend(View view) {
        ConexionSQLHelper conn = new ConexionSQLHelper(this);
        SQLiteDatabase db = conn.getWritableDatabase();
        db.execSQL("SELECT calle FROM Conductor where id =" +id);
    }
}