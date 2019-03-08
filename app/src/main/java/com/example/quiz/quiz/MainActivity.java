package com.example.quiz.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button guessCountry, guessHint, guessFlag, advanced;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        guessCountry = findViewById(R.id.button1);
        guessHint = findViewById(R.id.button2);
        guessFlag = findViewById(R.id.button3);
        advanced = findViewById(R.id.button4);

        guessCountry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GuessCountry.class);
                startActivity(intent);
            }
        });

    }
}
