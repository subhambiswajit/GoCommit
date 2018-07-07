package com.radicals.four.gocommit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TextAnalyzerActivity extends AppCompatActivity {
    public final static String analyze_string_key = "ANALYZE_KEY";
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
                Intent analyze_to_scheduler = new Intent(TextAnalyzerActivity.this, Scheduler.class);
                analyze_to_scheduler.putExtra(analyze_string_key, analyzing_string.getText());
                startActivity(analyze_to_scheduler);
            }
        });
    }
}
