package co.edu.myfinalproyect;

import  androidx.appcompat.app.AppCompatActivity;

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

                        String emailFrom = fromEt.toString();
                        String emailTo = toEt.toString();
                        String emailSubj = subEt.toString();
                        String emailBody = bodyEt.toString();
                        Log.v("Error ///////////" , emailFrom);
                        try {
                            GMailSender gMailSender = new GMailSender(emailFrom, emailPassword);
                            gMailSender.sendMail(emailFrom,emailTo,emailSubj,emailBody);
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }
}