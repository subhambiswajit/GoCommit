package com.radicals.four.gocommit;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Reminders extends  Activity {
    private ListView listView;
    private CustomListAdapter listAdapter;
    ArrayList<CommitmentData> Reminders = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminders);
//        Reminders = CommitmentData.GetSampleData();
        Intent intent = getIntent();
        String[] inbox_messages_array = intent.getExtras().get(TextAnalyzerActivity.sms_inbox_key).toString().split("\n");
        for (int i = 0; i< inbox_messages_array.length; i++)
        {
            CommitmentData data = new CommitmentData(inbox_messages_array[i], "today");
            Reminders.add(data);
        }
        listView = (ListView) findViewById(R.id.remider_list);
        listAdapter = new CustomListAdapter(this, Reminders);
        listView.setAdapter(listAdapter);
    }
}
