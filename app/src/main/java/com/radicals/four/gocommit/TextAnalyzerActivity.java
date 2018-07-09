package com.radicals.four.gocommit;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TextAnalyzerActivity extends AppCompatActivity {
    public final static String sms_inbox_key = "INBOX_KEY";
    public final static String sms_sent_key = "SENT_KEY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_analyzer);
        onClickAnalyzer();
    }

    public void onClickAnalyzer() {
        Button analyzer_button = findViewById(R.id.text_analyzer_button);
        analyzer_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText analyzing_string = findViewById(R.id.analyzing_edit_text);
                Intent analyze_to_scheduler_intent = new Intent(TextAnalyzerActivity.this, Reminders.class);
                analyze_to_scheduler_intent.putExtra(sms_inbox_key,grabInboxMessage(sms_type.INBOX));
                analyze_to_scheduler_intent.putExtra(sms_sent_key,grabInboxMessage(sms_type.SENT));
                startActivity(analyze_to_scheduler_intent);
            }
        });
    }

    public String grabInboxMessage(sms_type type) {
        String sms_path = "content://sms/inbox";
        if (type == sms_type.SENT)
            sms_path = "content://sms/sent";
        Uri uriSMSURI = Uri.parse(sms_path);
        Cursor cur = getContentResolver().query(uriSMSURI, null, null, null,null);
        String sms = "";
        while(cur.moveToNext())
        {
            sms += "From :" + cur.getString(cur.getColumnIndex("address")) + " : " + cur.getString(cur.getColumnIndex("body"))+"\n";
        }
        return sms;
    }

    public enum sms_type {
        INBOX,
        SENT
    }
}
