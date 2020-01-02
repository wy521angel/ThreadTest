package com.example.wy521angel.threadtest;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AsyncTaskActivity extends AppCompatActivity implements View.OnClickListener {

    private static String TAG = "AsyncTaskActivity";
    private Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asynctask);
        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(this);

        btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btn1) {
            new MyAsyncTask("AsyncTask#1").execute("");
            new MyAsyncTask("AsyncTask#2").execute("");
            new MyAsyncTask("AsyncTask#3").execute("");
            new MyAsyncTask("AsyncTask#4").execute("");
            new MyAsyncTask("AsyncTask#5").execute("");
        }

        if (v == btn2) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                new MyAsyncTask("AsyncTask#1").executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "");
                new MyAsyncTask("AsyncTask#2").executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "");
                new MyAsyncTask("AsyncTask#3").executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "");
                new MyAsyncTask("AsyncTask#4").executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "");
                new MyAsyncTask("AsyncTask#5").executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "");
            }
        }
    }


    private static class MyAsyncTask extends AsyncTask<String, Integer, String> {

        private String mName = "AsyncTask";

        public MyAsyncTask(String name) {
            super();
            this.mName = name;
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return mName;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Log.e(TAG, s + "execute finish at" + df.format(new Date()));
        }
    }
}
















