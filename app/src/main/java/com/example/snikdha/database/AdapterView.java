package com.example.snikdha.database;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterView extends BaseAdapter {

   Context context;
   ArrayList<ObjectForData> arrayList;
   LayoutInflater inflater;
   TextView tvname,tvphone,tvage;

    public AdapterView(Context context, ArrayList<ObjectForData> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.adapterview,null);
        tvname = (TextView)view.findViewById(R.id.textView);
        tvphone = (TextView)view.findViewById(R.id.textView2);
        tvage = (TextView)view.findViewById(R.id.textView3);
        tvname.setText(arrayList.get(position).getName());
        tvphone.setText(arrayList.get(position).getPhone());
        tvage.setText(String.valueOf(arrayList.get(position).getAge()));
        return view;
    }
}
