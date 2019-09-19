package com.example.student.city;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {
    EditText e1,e2,e3;

    SQLiteDatabase CITYDB = null;
    String tablename = "CITY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        e1=findViewById(R.id.editText2);
        e2=findViewById(R.id.editText3);
        e3=findViewById(R.id.editText4);

    }

    public void up(View view) {
        try {

        String ct=e1.getText().toString();
        int c2=Integer.parseInt(e1.getText().toString());
        String c3=e3.getText().toString();
            CITYDB = this.openOrCreateDatabase("CITYDB", MODE_PRIVATE, null);
            CITYDB.execSQL("Update CITY set ZIP="+c2+",DIST='"+c3+"' where CITY='"+ct+"'");
            Toast.makeText(this, "Record Updated", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }
}
