package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class Pop extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.popwindow);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;

        getWindow().setLayout((int)(width*0.8),(int)(height*0.8));

        TextView tv=findViewById(R.id.justSomeText);
        tv.setText("7:30am  Downtown to SUNY Oswego");
        TextView tv1 = findViewById(R.id.justSomeText1);
        tv1.setText("10:30am SUNY Oswego to Downtown");
        TextView tv2 = findViewById(R.id.justSomeText2);
        tv2.setText("12pm  Downtown to SUNY Oswego");
        TextView tv3 = findViewById(R.id.justSomeText3);
        tv3.setText("3:50pm SUNY Oswego to Downtown");
//        String[] myArray = {"8:30am\nFrom:   SUNY Oswego\nTo: Downtown","10:30am\nFrom:  Downtown\nTo: SUNY Oswego"};
//        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.pop_window,myArray);
//        ListView listView = findViewById(R.id.list_view);
//        listView.setAdapter(adapter);
    }
}
