package com.sample.huawei.crash;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread.UncaughtExceptionHandler defCrashHandler = Thread.getDefaultUncaughtExceptionHandler();
        Toast.makeText(getApplicationContext(), defCrashHandler.getClass().getName(), Toast.LENGTH_SHORT).show();

        findViewById(R.id.crash_world_npe_btn).setOnClickListener(view -> {
            throw new NullPointerException();
        });

        findViewById(R.id.crash_world_arithme_btn).setOnClickListener(view -> {
            throw new ArithmeticException();
        });
    }
}