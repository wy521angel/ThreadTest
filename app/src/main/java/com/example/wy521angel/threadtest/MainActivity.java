package com.example.wy521angel.threadtest;

import android.app.IntentService;
import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    private String[] titles = {"AsyncTask的串行与并行", "IntentService的工作方式"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, titles);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        switch (position) {
            case 0:
                startActivity(new Intent(this, AsyncTaskActivity.class));
                break;
            case 1:
                startActivity(new Intent(this, IntentServiceActivity.class));
                break;
        }
    }
}
