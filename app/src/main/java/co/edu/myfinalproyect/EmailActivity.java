package co.edu.myfinalproyect;

import  androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EmailActivity extends AppCompatActivity {

    private static String emailPassword="Kikecarrillo34";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        Button btnjava =(Button)findViewById(R.id.butJava);
        btnjava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        EditText fromEt = (EditText) findViewById(R.id.box1);
                        EditText toEt = (EditText) findViewById(R.id.box2);
                        EditText subEt = (EditText) findViewById(R.id.box3);
                        EditText bodyEt = (EditText) findViewById(R.id.box4);

                        String emailFrom = fromEt.getText().toString();
                        String emailTo = toEt.getText().toString();
                        String emailSubj = subEt.getText().toString();
                        String emailBody = bodyEt.getText().toString();
                        Log.v("TO ///////////" , emailFrom);

                        try {
                            GMailSender gMailSender = new GMailSender(emailFrom, emailPassword);
                            gMailSender.sendMail(emailSubj,emailBody,emailFrom,emailTo);
                        }catch (Exception e){
                            e.printStackTrace();
                            Log.v("Error ///////////" , e.getMessage());
                        }
                    }
                }).start();
            }
        });
    }
}