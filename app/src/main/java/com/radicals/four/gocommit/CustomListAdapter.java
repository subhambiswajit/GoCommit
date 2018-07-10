package com.radicals.four.gocommit;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.CalendarContract;
import android.provider.CalendarContract.Events;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import static android.support.v4.content.ContextCompat.startActivity;

public class CustomListAdapter extends BaseAdapter {
    public ArrayList<CommitmentData> listReminders;
    private Context context;
    public CustomListAdapter(Context context,ArrayList<CommitmentData> listReminders) {
        this.context = context;
        this.listReminders = listReminders;
    }
    @Override
    public int getCount() {
        return listReminders.size();
    }

    @Override
    public CommitmentData getItem(int position) {
        return listReminders.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        final ListViewHolder listViewHolder;
        if(convertView == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.reminder_layout_chunk,parent, false);
            listViewHolder = new ListViewHolder();
            listViewHolder.TaskName = row.findViewById(R.id.reminder_textView_task);
            listViewHolder.Time = row.findViewById(R.id.reminder_textView_when);
            listViewHolder.TaskNameField = row.findViewById(R.id.remider_layout_task);
            listViewHolder.TimeField = row.findViewById(R.id.reminder_text_when);
            listViewHolder.CreateReminder = row.findViewById(R.id.SetReminderButton);
            row.setTag(listViewHolder);
        }
        else {
            row = convertView;
            listViewHolder = (ListViewHolder) row.getTag();
        }

        final CommitmentData reminders = getItem(position);
        listViewHolder.TaskNameField.setText(reminders.TaskName);
        listViewHolder.TimeField.setText(reminders.Time);
        listViewHolder.CreateReminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createEvent(reminders);
            }
        });
        return row;
    }

    public void createEvent (CommitmentData reminder) {
        final ContentValues event = new ContentValues();
        event.put(Events.CALENDAR_ID, 1);
        event.put(Events.TITLE, reminder.TaskName);
        event.put(Events.DESCRIPTION, reminder.TaskName);
        event.put(Events.EVENT_LOCATION, "This event is auto created by goCommit");
        event.put(Events.DTSTART, System.currentTimeMillis());
        event.put(Events.DTEND, System.currentTimeMillis() + 1800*1000);
        event.put(Events.ALL_DAY, 0);   // 0 for false, 1 for true
        event.put(Events.HAS_ALARM, 1); // 0 for false, 1 for true
        String timeZone = TimeZone.getDefault().getID();
        event.put(Events.EVENT_TIMEZONE, timeZone);
        Uri baseUri;
        if (Build.VERSION.SDK_INT >= 8) {
            baseUri = Uri.parse("content://com.android.calendar/events");
        } else {
            baseUri = Uri.parse("content://calendar/events");
        }
        context.getContentResolver().insert(baseUri, event);
        Toast.makeText(context,"The Reminder for event"+ reminder.TaskName + "is created", Toast.LENGTH_LONG ).show();
    }
}
