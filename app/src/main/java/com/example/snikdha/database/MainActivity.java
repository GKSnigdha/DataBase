package com.example.snikdha.database;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etName,etphone,etAge;
    Button btnAdd,btnRead,btnUpdate,btnDelete;
    SQLHelper sqlHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init_views();
        init_variable();
        init_functions();
        init_listener();
    }

    private void init_functions() {

    }

    private void init_variable() {
        sqlHelper = new SQLHelper(getApplicationContext());
    }

    private void init_views()
    {
        etName=(EditText)findViewById(R.id.et_name);
        etphone=(EditText)findViewById(R.id.et_phone);
        etAge=(EditText)findViewById(R.id.et_age);

        btnAdd=(Button)findViewById(R.id.btn_insert);
        btnRead=(Button)findViewById(R.id.btn_read);
        btnUpdate=(Button)findViewById(R.id.btn_update);
        btnDelete=(Button)findViewById(R.id.btn_delete);
    }

    private void init_listener() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString().trim();
                String phone = etphone.getText().toString().trim();
                String age = etAge.getText().toString().trim();
                ObjectForEmployee objectForEmployee = new ObjectForEmployee(name,phone,age);
               long inserted = sqlHelper.insertValue(objectForEmployee);
                if(inserted>0){
                    Toast.makeText(getApplicationContext(),"success",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_SHORT).show();
                }
            }
        });
       btnRead.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this,ViedData.class);
              startActivity(intent);
           }
       });
       btnDelete.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String phone = etphone.getText().toString().trim();
               int delete = sqlHelper.delete(phone);
               Toast.makeText(getApplicationContext(),delete+" ",Toast.LENGTH_SHORT).show();
           }
       });
       btnUpdate.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String name = etName.getText().toString().trim();
               String phone = etphone.getText().toString().trim();
               String age =etAge.getText().toString().trim();
               int update = sqlHelper.update(name, phone, age);
               Toast.makeText(getApplicationContext(),update+" ",Toast.LENGTH_SHORT).show();
           }
       });

    }
}
