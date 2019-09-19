package com.example.student.city;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ed1, ed2, ed3;
    Button b1;
    String c1, c2, c3;
    SQLiteDatabase CITYDB = null;
    String tablename = "CITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = findViewById(R.id.txt1);
        ed2 = findViewById(R.id.txt2);
        ed3 = findViewById(R.id.txt3);


    }

    public void cdb(View view) {
        try {

            CITYDB = this.openOrCreateDatabase("CITYDB", MODE_PRIVATE, null);
            CITYDB.execSQL("CREATE TABLE " + tablename + "(CITY VARCHAR,ZIP INT(7),DIST VARCHAR);");
            Toast.makeText(getApplicationContext(), "DATABASE AND TABLE CREATED", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }

    }

    public void DBinsert(View view) {
        try {
            CITYDB = this.openOrCreateDatabase("CITYDB", MODE_PRIVATE, null);
            String ct = ed1.getText().toString();
            int zp = Integer.parseInt(ed2.getText().toString());
            String dct = ed3.getText().toString();
            CITYDB.execSQL("Insert into " + tablename + "(CITY,ZIP,DIST)" + "values ('" + ct + "'," + zp + ",'" + dct + "');");
            Toast.makeText(getApplicationContext(), "Record Inserted", Toast.LENGTH_LONG).show();
            ed1.setText(" ");
            ed2.setText(" ");
            ed3.setText(" ");


        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();

        }
    }
    public void DBview(View view) {
        Intent i=new Intent(getApplicationContext(),ViewActivity.class);
        startActivity(i);
        }


    public void DBserach(View view) {
Intent i=new Intent(getApplicationContext(),search.class);
startActivity(i);
    }

    public void DBupdate(View view) {
        Intent i=new Intent(getApplicationContext(),UpdateActivity.class);
        startActivity(i);
    }
}
