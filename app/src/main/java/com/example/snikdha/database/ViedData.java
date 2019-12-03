package com.example.snikdha.database;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ViedData extends AppCompatActivity {
    ListView listView;
    SQLHelper sqlHelper;
    ArrayList<ObjectForData> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vied_data);
        listView = (ListView)findViewById(R.id.ListShow);
        sqlHelper = new SQLHelper(getApplicationContext());
        arrayList= new ArrayList<>();


        Cursor cursor = sqlHelper.read();
        Toast.makeText(getApplicationContext(),"Number of rows: " + cursor.getCount(),Toast.LENGTH_SHORT).show();
        cursor.moveToFirst();
        for(int i=0;i<cursor.getCount();i++){
            String name = cursor.getString(0);
            String phone=  cursor.getString(1);
            int age =  cursor.getInt(2);

            ObjectForData objectForData = new ObjectForData(name,phone,age);
            arrayList.add(objectForData);
            cursor.moveToNext();
        }

        AdapterView adapterView = new AdapterView(getApplicationContext(),arrayList);
        listView.setAdapter(adapterView);
        adapterView.notifyDataSetChanged();
    }
    }

