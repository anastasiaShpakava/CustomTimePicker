package com.company.customtimepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class HourAdapter extends BaseAdapter {
    private LayoutInflater lInflater;
    private String[] hoursValueList;

    public HourAdapter(Context context, String[] hoursValueList) {
        lInflater = LayoutInflater.from(context);
        this.hoursValueList = hoursValueList;
    }

    @Override
    public int getCount() {
        return hoursValueList.length;
    }

    @Override
    public Object getItem(int position) {
        return hoursValueList[position];
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

        TextView textHours = view.findViewById(R.id.textRow);
        textHours.setText(hoursValueList[position]);

        RelativeLayout.LayoutParams textViewLayoutParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        textViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_END);
        textViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        textHours.setLayoutParams(textViewLayoutParams);

        return view;
    }

}
