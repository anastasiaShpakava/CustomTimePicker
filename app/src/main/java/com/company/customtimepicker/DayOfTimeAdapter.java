package com.company.customtimepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class DayOfTimeAdapter extends BaseAdapter {
    private LayoutInflater lInflater;
    private String[] dayOfTimeValueList;

    public DayOfTimeAdapter(Context context, String[] dayOfTimeValueList) {
        lInflater = LayoutInflater.from(context);
        this.dayOfTimeValueList = dayOfTimeValueList;
    }

    @Override
    public int getCount() {
        return dayOfTimeValueList.length;
    }

    @Override
    public Object getItem(int position) {
        return dayOfTimeValueList[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.row, parent, false);
        }
        TextView textDayOfTime = view.findViewById(R.id.textRow);
        textDayOfTime.setText(dayOfTimeValueList[position]);

        RelativeLayout.LayoutParams textViewLayoutParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        textViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_END);
        textViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        textDayOfTime.setLayoutParams(textViewLayoutParams);

        return view;
    }

}
