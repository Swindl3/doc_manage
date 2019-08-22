package com.example.f1r3z.myapplicationdocument;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import cz.msebera.android.httpclient.Header;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RegisterActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tb);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("หน้าลงทะเบียน");

        Button buttonRegistersucc = (Button)findViewById(R.id.btn_registersucc);
        final TextView tv = findViewById(R.id.tv);
        final EditText et1 = findViewById(R.id.regis_firstname);
        final EditText et2 = findViewById(R.id.regis_lastname);
        final EditText et3 = findViewById(R.id.regis_email);
        final EditText et4 = findViewById(R.id.regis_username);

        buttonRegistersucc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                AsyncHttpClient client  = new AsyncHttpClient();
                client.get("http://www.mocky.io/v2/5d5eba5f2f0000315a92fc23", new JsonHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                        super.onSuccess(statusCode, headers, response);
                        try {
                            et1.setText(response.getString("fname"));
                            et2.setText(response.getString("lname"));
                            et4.setText(response.getString("username"));
                            et3.setText(response.getString("email"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });


    }
}
