package com.example.myapplication;

import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.StringReader;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtView = findViewById(R.id.signin);
        TextView username = findViewById(R.id.username);
        TextView password = findViewById(R.id.password);
        Button loginBtn = findViewById(R.id.logninbtn);
        TextView forgotPass = findViewById(R.id.forgotpass);
        TextView register = findViewById(R.id.register);

        String NGROK = "https://66a0-188-27-180-79.ngrok-free.app";
        String url = NGROK + "/api/v1/person";
        String myString = new String("Failed");
        MediaType JSON_MEDIA_TYPE = MediaType.get("application/json; charset=utf-8");
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!username.getText().toString().isEmpty() && !password.getText().toString().isEmpty()){

//                    Intent intent = new Intent(MainActivity.this, MapsActivity.class);
//                    startActivity(intent);
                    JSONObject jsonObject = new JSONObject();
                    try {
                        jsonObject.put("username", username.getText().toString());
                        jsonObject.put("pass", password.getText().toString());

                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                    RequestBody body = RequestBody.create(jsonObject.toString() , JSON_MEDIA_TYPE);
                    OkHttpClient client = new OkHttpClient();

                    Request request = new Request.Builder()
                            .url(url)
                            .post(body)
                            .build();

                    client.newCall(request).enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            e.printStackTrace();
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            if (response.isSuccessful()) {
                                final String myResponse = response.body().string();

                                MainActivity.this.runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        txtView.setText(myResponse);
                                    }
                                });
                            }
                        }
                    });

                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });


    }





}