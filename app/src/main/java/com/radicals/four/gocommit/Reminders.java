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
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Reminders extends  Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminders);
        ListView reminders = findViewById(R.id.remider_list);
        ArrayList<CommitmentData> values = new ArrayList<CommitmentData>();
        values = CommitmentData.GetSampleData();
        ArrayAdapter<CommitmentData> adapter = new ArrayAdapter<CommitmentData>(this,android.R.layout.simple_list_item_1, values);
        reminders.setAdapter(adapter);
    }
}
