package com.xyz.tourmate;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xyz.tourmate.activity.LoginActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Handler handler=new Handler();
        handler.postDelayed( new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent( MainActivity.this, LoginActivity.class );
                startActivity( intent );
            }
        }, 3000 );

    }
}
