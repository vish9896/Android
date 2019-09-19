package com.example.student.city;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ViewActivity extends AppCompatActivity {
ListView l1;
    SQLiteDatabase CITYDB = null;
    String tablename = "CITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        l1=findViewById(R.id.ltview);
try {
    CITYDB = this.openOrCreateDatabase("CITYDB", MODE_PRIVATE, null);
    Cursor c = CITYDB.rawQuery("Select * from CITY", null);
    String Data[] = new String[c.getCount() + 1];
    int i = 1;
    String h1 = c.getColumnName(0);
    String h2 = c.getColumnName(1);
    String h3 = c.getColumnName(2);
    if (c != null) {
        Data[0] = h1 + "\t \t \t \t" + h2 + "\t \t \t \t" + h3;
        c.moveToFirst();
        do {
            String ct = c.getString(0);
            int z = c.getInt(1);
            String dt = c.getString(2);
            Data[i] = ct + " " + z + " " + dt;
            i++;
        } while (c.moveToNext());
        ArrayAdapter<String> apt = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, Data);
        l1.setAdapter(apt);
    } else {

    }
}
catch (Exception e)
{
    Toast.makeText(getApplicationContext(),e.getMessage(), Toast.LENGTH_SHORT).show();
}
    }

}
