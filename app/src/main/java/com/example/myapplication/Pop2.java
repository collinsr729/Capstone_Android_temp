package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import javax.xml.datatype.Duration;

public class Pop2 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pop_window);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;

        getWindow().setLayout((int) (width * 0.7), (int) (height * 0.7));

        Toast.makeText(Pop2.this,"Please enter all data, \nnot just change one part",Toast.LENGTH_SHORT);

        final String[] fromLocation = new String[1];
        final String[] fromLocationAddress = new String[1];
        final String[] toLocation = new String[1];
        final String[] toLocationAddress = new String[1];
        final Spinner hourSpinner = findViewById(R.id.hour_spinner);
        final Spinner minSpinner = findViewById(R.id.minute_spinner);
        final Spinner ampmSpinner = findViewById(R.id.am_pm_spinner);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Pop2.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.hour_options));
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        hourSpinner.setAdapter(arrayAdapter);
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(Pop2.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.minute_options));
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        minSpinner.setAdapter(arrayAdapter2);
        ArrayAdapter<String> arrayAdapter3 = new ArrayAdapter<String>(Pop2.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.am_pm_options));
        arrayAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ampmSpinner.setAdapter(arrayAdapter3);

        ////////////////////////////HELP I DIDN'T FINISH////////////////////////////////////////////////
        Button confirmButton = findViewById(R.id.confirmButton);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //exit activity, send data back
                //if()
                String time = (String) hourSpinner.getSelectedItem()
                +"  "+(String) minSpinner.getSelectedItem()
                +" "+(String)ampmSpinner.getSelectedItem();
                //return or upload time+selectedLocation1+selectedLocation2
            }
        });
        ///////////////////////////////////HELP I DIDN'T FINISH/////////////////////////////////////////

        Intent intent = getIntent();
        String extra = intent.getStringExtra("extra");

        final TextView textView = findViewById(R.id.schedule_temp);
        textView.setText(extra);

        final String TAG = "placeautocomplete";

        // Initialize Places.
        Places.initialize(getApplicationContext(), "API_KEY");//////////////////API KEY HERE?????
        // Create a new Places client instance.
        PlacesClient placesClient = Places.createClient(this);

        // Initialize the AutocompleteSupportFragment.
        AutocompleteSupportFragment autocompleteFragment = (AutocompleteSupportFragment)
                getSupportFragmentManager().findFragmentById(R.id.autocomplete_fragment);

        // Specify the types of place data to return.
        autocompleteFragment.setPlaceFields(Arrays.asList(Place.Field.ID, Place.Field.NAME));

        // Set up a PlaceSelectionListener to handle the response.
        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                // TODO: Get info about the selected place.
                textView.setText(place.getName() + "," + place.getId());
                Log.i(TAG, "From: " + place.getName() + ", " + place.getId());
                fromLocation[0] = place.getName();
                fromLocationAddress[0] = place.getAddress();
            }

            @Override
            public void onError(Status status) {
                // TODO: Handle the error.
                Log.i(TAG, "An error occurred: " + status);
            }
        });
        AutocompleteSupportFragment autocompleteFragment2 = (AutocompleteSupportFragment)
                getSupportFragmentManager().findFragmentById(R.id.autocomplete_fragment_2);

        // Specify the types of place data to return.
        autocompleteFragment2.setPlaceFields(Arrays.asList(Place.Field.ID, Place.Field.NAME));

        // Set up a PlaceSelectionListener to handle the response.
        autocompleteFragment2.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                // TODO: Get info about the selected place.
                textView.setText(place.getName() + "," + place.getId());
                Log.i(TAG, "Place: " + place.getName() + ", " + place.getId());
                toLocation[0] = place.getName();
                toLocationAddress[0] = place.getAddress();
            }

            @Override
            public void onError(Status status) {
                // TODO: Handle the error.
                Log.i(TAG, "An error occurred: " + status);
            }
        });

        Toast.makeText(super.getBaseContext(),"Please enter all data, \nnot just change one part",Toast.LENGTH_SHORT);
    }
}
