package co.edu.myfinalproyect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ComponentActivity;

import co.edu.myfinalproyect.LoginActivity.*;
import android.Manifest;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.security.KeyPairGenerator;
import java.util.List;
import java.util.Locale;

import co.edu.myfinalproyect.entidades.Conductor;
import co.edu.myfinalproyect.utilidades.Utilidades;

public class MapsActivity extends AppCompatActivity {

    private Button bt_locatio;
    private TextView textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11;
    private FusedLocationProviderClient fusedLocationProviderClient;
    LoginActivity plan;
    private String dato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        bt_locatio = findViewById(R.id.bt_location);
        textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5);
        textView6 = findViewById(R.id.textView6);
        textView7 = findViewById(R.id.textView7);
        textView8 = findViewById(R.id.textView8);
        textView9 = findViewById(R.id.textView9);
        textView10 = findViewById(R.id.textView10);
        textView11 = findViewById(R.id.textView11);
        dato = getIntent().getStringExtra("dato");
        Log.v("ID DATOO////////",dato+" EXITO");
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        bt_locatio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getLocacion();
                //Log.v("ID ONCLICK////////",dato+" EXITO");
            }
        });
    }

    public void getLocacion() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.

        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {
                Location location = task.getResult();
                if (location != null) {
                    Geocoder geocoder = new Geocoder(getApplicationContext(), Locale.getDefault());
                    try {
                        ConexionSQLHelper conn = new ConexionSQLHelper(getApplicationContext());
                        SQLiteDatabase db = conn.getWritableDatabase();

                        List <Address> address = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                        textView5.setText(address.get(0).getLatitude() + "");
                        textView7.setText(address.get(0).getLongitude() + "");
                        textView9.setText(address.get(0).getCountryName() + "");
                        textView11.setText(address.get(0).getAddressLine(0) + "");
                        Log.v("ID ubicacion///",dato+"");
                        ///// COMO GUARDAR ESTO EN LA BD CON EL ID
                        db.execSQL("UPDATE Conductor SET latitud = '"+address.get(0).getLatitude()+"', longitud = '"+address.get(0).getLongitude()+"' where id like "+dato);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        }else{
            ActivityCompat.requestPermissions(MapsActivity.this ,new String[] {Manifest.permission.ACCESS_FINE_LOCATION},44);
        }

    }

    public void onSendMaps0(View view) {
        ConexionSQLHelper conn = new ConexionSQLHelper(getApplicationContext());
        SQLiteDatabase db = conn.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * from Conductor where id like "+dato,null);
        String lati="";
        String longi="";
        if (cursor.moveToFirst()){
            do {
         lati = cursor.getString(cursor.getColumnIndex("latitud"));
         longi = cursor.getString(cursor.getColumnIndex("longitud"));
            }while(cursor.moveToNext());
        }
        db.execSQL("UPDATE DuenoCamion SET latitud = '"+lati+"', longitud = '"+longi+"' where id like "+15);//falta de logica
        db.execSQL("UPDATE DuenoCarga SET latitud = '"+lati+"', longitud = '"+longi+"' where id like "+15);

        Uri uri=Uri.parse("geo:"+ lati +","+ longi);
        Intent intent= new Intent(Intent.ACTION_VIEW,uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);



/*
        Uri.Builder builder=new Uri.Builder();
        builder.scheme("https")
                .authority("www.google.com")
                .appendPath("maps")
                .appendPath("dir")
                .appendPath("")
                .appendQueryParameter("api","1")
                .appendQueryParameter("destination",lati + "," + longi);
        String url= builder.build().toString();
        Log.d("Directions", url);
        Intent intent= new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);*/
    }
}