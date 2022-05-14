package com.example.t024_insertquotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button BtnSuccess , BtnInspiration , BtnMotivation ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BtnSuccess = findViewById(R.id.BtnSuccess);
        BtnMotivation = findViewById(R.id.BtnMotivation);
        BtnInspiration = findViewById(R.id.BtnInspiration);

        BtnSuccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String QUOTE_CAT = "Success";
                String QUOTE_CAT_NO = "1" ;
                Intent intent = new Intent(MainActivity.this , InsertActivity.class);
                intent.putExtra("QUOTE_CAT_KEY" , QUOTE_CAT);
                startActivity(intent);
            }
        });

        BtnInspiration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String QUOTE_CAT = "Inspiration";
                String QUOTE_CAT_NO = "2" ;
                Intent intent = new Intent(MainActivity.this , InsertActivity.class);
                intent.putExtra("QUOTE_CAT_KEY" , QUOTE_CAT);
                startActivity(intent);
            }
        });

        BtnMotivation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String QUOTE_CAT = "Motivation";
                String QUOTE_CAT_NO = "3" ;
                Intent intent = new Intent(MainActivity.this , InsertActivity.class);
                intent.putExtra("QUOTE_CAT_KEY" , QUOTE_CAT);
                intent.putExtra("QUOTE_CAT_NO_KEY" , QUOTE_CAT_NO);
                startActivity(intent);
            }
        });


    }
}