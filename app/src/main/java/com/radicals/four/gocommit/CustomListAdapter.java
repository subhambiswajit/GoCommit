package com.radicals.four.gocommit;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class CustomListAdapter extends BaseAdapter {
    public ArrayList<Reminders> listReminders;
    private Context context;
    public CustomListAdapter(Context context,ArrayList<Reminders> listReminders) {
        this.context = context;
        this.listReminders = listReminders;
    }
    @Override
    public int getCount() {
        return listReminders.size();
    }

    @Override
    public Reminders getItem(int position) {
        return listReminders.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
