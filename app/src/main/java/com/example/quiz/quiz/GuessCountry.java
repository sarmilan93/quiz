package com.example.quiz.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class GuessCountry extends AppCompatActivity {

    private String json;
    private List<country> countryCode;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_country);

        spinner = findViewById(R.id.spinner);

        countryCode = new ArrayList<>();

        try {

            InputStream is = getResources().openRawResource(R.raw.countries);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

            JSONObject jsonObject = new JSONObject(json);
            Iterator<String> iterator = jsonObject.keys();

            while (iterator.hasNext()){

                String key = iterator.next();
                String value = jsonObject.getString(key);
//                Log.d("countries", "Key : " + key + " Value " + jsonObject.getString(key));
                countryCode.add(new country(key,value));

            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        ArrayAdapter<country> arrayAdapter = new ArrayAdapter<country>(this, android.R.layout.simple_spinner_dropdown_item, countryCode);
        spinner.setAdapter(arrayAdapter);

    }
}
