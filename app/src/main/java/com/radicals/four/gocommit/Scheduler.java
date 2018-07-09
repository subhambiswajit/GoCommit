package com.radicals.four.gocommit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ScrollView;
import android.widget.TextView;

public class Scheduler extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheduler);
        Intent intent = getIntent();
        TextView scheduler_text_view = findViewById(R.id.analyzing_textView);
        String inbox_messages = intent.getExtras().getString(TextAnalyzerActivity.sms_inbox_key);
        String sent_messages = intent.getExtras().getString(TextAnalyzerActivity.sms_sent_key);
        scheduler_text_view.setText(inbox_messages + sent_messages);
        scheduler_text_view.setMovementMethod(new ScrollingMovementMethod());
    }
}
