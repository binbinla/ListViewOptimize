package com.binbin.demo.listviewoptimize;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ArrayList<HashMap<String,Object>> mdatas = new ArrayList<>();
    MyAdapterSecond myAdapterSecond;

    static final int TYPE_ONE = 0;
    static final int TYPE_TWO = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i = 0;i < 100;i++){
            HashMap<String,Object> item = new HashMap<>();
            if(i % 2 == 0){
                item.put("type",TYPE_ONE);
                item.put("itemImage",R.mipmap.ic_launcher);
                item.put("itemContent","No."+i);
            }else{
                item.put("type",TYPE_TWO);
                item.put("itemTitle","Title"+i);
                item.put("itemContent","No."+i);
            }
            mdatas.add(item);
        }

        ListView listView = (ListView) findViewById(R.id.listview);
        myAdapterSecond = new MyAdapterSecond(this,mdatas);
        listView.setAdapter(myAdapterSecond);

    }
}
