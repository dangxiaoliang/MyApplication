package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import adapter.MyListViewAdapter;

public class MainActivity extends AppCompatActivity {

    //    private int[] datas = new int[]{R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4, R.drawable.a5, R.drawable.a6, R.drawable.a7, R.drawable.a8,
//            R.drawable.a9, R.drawable.a10, R.drawable.a11, R.drawable.a12, R.drawable.a13};
    private String[] datas = Images.imageThumbUrls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(new MyListViewAdapter(this, datas));
    }
}
