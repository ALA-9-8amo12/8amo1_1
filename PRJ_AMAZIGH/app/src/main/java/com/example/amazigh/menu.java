package com.example.amazigh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class menu extends AppCompatActivity {
    private Button oefen;
    private Button spelen;
    private Button over;
    private Button Score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        oefen = findViewById(R.id.oefen);
        oefen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity_CategoryO();
            }
        });

        spelen = findViewById(R.id.Spelen);
        spelen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity_CategoryS();
            }
        });

        over = findViewById(R.id.over);
        over.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity_Over();
            }
        });

        spelen = findViewById(R.id.score);
        spelen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity_Score();
            }
        });
    }

    public void openActivity_CategoryO() {
        Intent intent = new Intent(getApplicationContext(), categoriesActivity.class);
        startActivity(intent);
    }

    public void openActivity_CategoryS() {
        Intent intent = new Intent(this, categoriesActivity.class);
        startActivity(intent);
    }

    public void openActivity_Over() {
        Intent intent = new Intent(this, over.class);
        startActivity(intent);
    }

    public void openActivity_Score() {
        Intent intent = new Intent(this, score.class);
        startActivity(intent);
    }



}
