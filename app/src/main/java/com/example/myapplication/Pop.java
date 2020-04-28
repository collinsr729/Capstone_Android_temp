package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;
import com.google.android.libraries.places.api.Places;

import java.util.Arrays;

public class Pop extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.popwindow);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;

        getWindow().setLayout((int) (width * 0.8), (int) (height * 0.8));
        Intent incomingIntent = getIntent();
        String incomingString = incomingIntent.getStringExtra("buttonPressed");
        String dayOfWeek = incomingString.substring(0, incomingString.indexOf("\n"));
        incomingString = incomingString.substring(incomingString.indexOf("\n") + 1);
        TextView topBar = findViewById(R.id.topLabel);
        topBar.setText(dayOfWeek);
        String[] inpText = incomingString.split("\\n");//tv0.getText().toString().split("\\n");
        if (inpText.length > 0) {
            TextView tv = findViewById(R.id.justSomeText);
            tv.setText(inpText[0]);
            if (inpText.length > 1) {
                TextView tv1 = findViewById(R.id.justSomeText1);
                tv1.setText(inpText[1]);
                if (inpText.length > 2) {
                    TextView tv2 = findViewById(R.id.justSomeText2);
                    tv2.setText(inpText[2]);
                    if (inpText.length > 3) {
                        TextView tv3 = findViewById(R.id.justSomeText3);
                        tv3.setText(inpText[3]);
                    }
                }
            }
        }
        ImageButton button = findViewById(R.id.justSomeText_edit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Pop.this, Pop2.class);
                TextView tv = findViewById(R.id.justSomeText);
                i.putExtra("extra","Original:  \n"+tv.getText());
                startActivity(i);
            }
        });
        ImageButton button1 = findViewById(R.id.justSomeText1_edit);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Pop.this, Pop2.class);
                TextView tv = findViewById(R.id.justSomeText1);
                i.putExtra("extra","Original:  "+tv.getText());
                startActivity(i);
            }
        });
        ImageButton button2 = findViewById(R.id.justSomeText2_edit);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Pop.this, Pop2.class);
                TextView tv = findViewById(R.id.justSomeText2);
                i.putExtra("extra","Original:  "+tv.getText());
                startActivity(i);
            }
        });
        ImageButton button3 = findViewById(R.id.justSomeText3_edit);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Pop.this, Pop2.class);
                TextView tv = findViewById(R.id.justSomeText3);
                i.putExtra("extra","Original:  "+tv.getText());
                startActivity(i);
            }
        });



//        String[] myArray = {"8:30am\nFrom:   SUNY Oswego\nTo: Downtown","10:30am\nFrom:  Downtown\nTo: SUNY Oswego"};
//        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.pop_window,myArray);
//        ListView listView = findViewById(R.id.list_view);
//        listView.setAdapter(adapter);
    }
}

