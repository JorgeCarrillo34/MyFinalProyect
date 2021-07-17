   package co.edu.myfinalproyect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    Toolbar toolbar;
    String dato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        dato = getIntent().getStringExtra("dato");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id==R.id.opcion1){
            Toast.makeText(this, "FUTURAS ACTUALIZACIONES", Toast.LENGTH_SHORT).show();
        }else if(id==R.id.opcion2){
            Intent intent2 = new Intent(this, AjustesActivity.class);
            startActivity(intent2);
        }else if(id==R.id.opcion3){
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }

        return true;
    }

    public void onSendMaps0(View view){


        Uri.Builder builder=new Uri.Builder();
        builder.scheme("https")
                .authority("www.google.com")
                .appendPath("maps")
                .appendPath("dir")
                .appendPath("")
                .appendQueryParameter("api","1")
                .appendQueryParameter("destination",6.234172 + "," + -75.586135);
        String url= builder.build().toString();
        Log.d("Directions", url);
        Intent intent= new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    public void onSendMaps(View v){
        /// DOS PUNTOS EN MAPS
        Uri uri=Uri.parse("geo:");
        Intent intent= new Intent(Intent.ACTION_VIEW,uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }

    public void Email(View c){
        Intent intent = new Intent(getApplicationContext(), EmailActivity.class);
        startActivity(intent);
    }

    public void onSendMaps1(View v){
        Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
        intent.putExtra("dato",dato);
        startActivity(intent);
    }

}