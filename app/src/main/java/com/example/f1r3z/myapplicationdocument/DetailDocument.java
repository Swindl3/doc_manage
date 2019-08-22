package com.example.f1r3z.myapplicationdocument;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailDocument extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_document);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tb);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("หน้าเอกสาร");


        Intent intent = this.getIntent();
        int CurrentCover = intent.getExtras().getInt("selectedCover");
        String CurrentTitle = intent.getExtras().getString("selectedTitle");

        ImageView imgCurrentCover = findViewById(R.id.imgCurrentCover);
        imgCurrentCover.setImageResource(CurrentCover);
        TextView tvCurrentTitle = findViewById(R.id.tvCurrentTitle);
        tvCurrentTitle.setText(CurrentTitle);
    }
}
