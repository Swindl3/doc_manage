package com.example.f1r3z.myapplicationdocument;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.Image;
import android.provider.MediaStore;
import android.service.voice.VoiceInteractionSession;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.f1r3z.myapplicationdocument.adapter.adt_rv_cardview_doc;
import com.example.f1r3z.myapplicationdocument.adapter.adt_rv_cardview_group;

import javax.xml.transform.Result;

public class ListDocName extends AppCompatActivity {
    private Toolbar toolbar;
    private Button cmdCapture;
    private ImageView imgCover;

    private final int CAMERA_RESULT_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_doc_name);
        toolbar = (Toolbar) findViewById(R.id.tb);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("หน้าเอกสาร");

        cmdCapture = findViewById(R.id.cmdCapture);
        imgCover = findViewById(R.id.imgCover);

        RecyclerView rv = findViewById(R.id.recyclerviewDoc);
        rv.setHasFixedSize(true);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(ListDocName.this);
        rv.setLayoutManager(lm);
        RecyclerView.Adapter adt = new adt_rv_cardview_doc();
        rv.setAdapter(adt);

        cmdCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(ListDocName.this, Manifest.permission
                        .CAMERA) == PackageManager.PERMISSION_GRANTED) {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivityForResult(intent, CAMERA_RESULT_CODE);
                    }
                }
                else {
                    if (shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)) {
                        Toast.makeText(ListDocName.this, "ไม่สามารถใช้งานกล้องได้", Toast.LENGTH_LONG).show();
                    }
                    requestPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}
                            , CAMERA_RESULT_CODE);
                }

            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == RESULT_OK){
            if (requestCode == CAMERA_RESULT_CODE){
                Bundle bd  = data.getExtras();
                Bitmap bmp = (Bitmap) bd.get("data");
                imgCover.setImageBitmap(bmp);
            }
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults){
        if (requestCode == CAMERA_RESULT_CODE){
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED
                    && grantResults[1] == PackageManager.PERMISSION_GRANTED){
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (intent.resolveActivity(getPackageManager()) != null){
                    startActivityForResult(intent, CAMERA_RESULT_CODE);
                }
            }
            else {
                Toast.makeText(ListDocName.this, "ไม่สามารถใช้งานกล้องได้", Toast.LENGTH_LONG).show();
            }
        }
        else {
            super.onRequestPermissionsResult(requestCode,permissions,grantResults);
        }
    }
}

