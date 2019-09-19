package com.example.student.city;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class search extends AppCompatActivity {
    EditText ed1;

    ListView lv;
    SQLiteDatabase CITYDB = null;
    String tablename = "CITY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ed1=findViewById(R.id.edi1);
        lv=findViewById(R.id.lv1);


    }

    public void Serach(View view) {
        try
        {
            String sr=ed1.getText().toString();
            CITYDB=this.openOrCreateDatabase("CITYDB",MODE_PRIVATE,null);
            Cursor c=CITYDB.rawQuery("Select * from CITY Where CITY=?", new String[]{sr});
            String Data[]=new String[c.getCount()];
            int i=0;
            String h1 = c.getColumnName(0);
            String h2 = c.getColumnName(1);
            String h3 = c.getColumnName(2);
            if(c!=null)
            {
                int c1=c.getColumnIndex("CITY");
                int c2=c.getColumnIndex("ZIP");
                int c3=c.getColumnIndex("DIST");
             c.moveToFirst();
             do{
                 String ct = c.getString(c1);
                 int z = c.getInt(c2);
                 String dt = c.getString(c3);
                 Data[i] = ct + " " + z + " " + dt;
                 i++;
             }while (c.moveToNext());
                ArrayAdapter<String> apt = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, Data);
                lv.setAdapter(apt);
            }

        }
        catch(Exception e)
        {
            Toast.makeText(this,e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
