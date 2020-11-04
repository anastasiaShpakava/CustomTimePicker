package com.company.customtimepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MinuteAdapter  extends BaseAdapter {
    private LayoutInflater lInflater;
    private String[] minutesValueList;
    Context context;

    public MinuteAdapter(Context context, String[] minutesValueList) {
        lInflater = LayoutInflater.from(context);
        this.minutesValueList = minutesValueList;
        this.context=context;
    }

    @Override
    public int getCount() {
        return minutesValueList.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {

        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.row, parent, false);
        }
        TextView textMinutes = view.findViewById(R.id.textRow);
        textMinutes.setText(minutesValueList[position]);

        RelativeLayout.LayoutParams textViewLayoutParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        textViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_END);
        textViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        textMinutes.setLayoutParams(textViewLayoutParams);
        return view;
    }
}
