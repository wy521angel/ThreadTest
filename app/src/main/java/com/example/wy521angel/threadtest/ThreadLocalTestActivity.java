package com.example.wy521angel.threadtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class ThreadLocalTestActivity extends AppCompatActivity {

    private static String TAG = "ThreadLocalTest";
    private ThreadLocal<Boolean> mBooleanThreadLocal = new ThreadLocal<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_threadlocal_test);

        findViewById(R.id.test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBooleanThreadLocal.set(true);
                Log.d(TAG, "[Thread#main]mBooleanThreadLocal=" + mBooleanThreadLocal.get());

                new Thread("Thread#1") {
                    @Override
                    public void run() {
                        mBooleanThreadLocal.set(false);
                        Log.d(TAG, "[Thread#1]mBooleanThreadLocal=" + mBooleanThreadLocal.get());
                    }
                }.start();

                new Thread("Thread#2") {
                    @Override
                    public void run() {
                        Log.d(TAG, "[Thread#2]mBooleanThreadLocal=" + mBooleanThreadLocal.get());
                    }
                }.start();
            }
        });

    }
}