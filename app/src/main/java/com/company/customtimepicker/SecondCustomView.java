package com.company.customtimepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SecondCustomView extends View {

    public SecondCustomView(Context context) {
        super(context);
    }
    public static View getView(Context context, ViewGroup collection) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context
                .LAYOUT_INFLATER_SERVICE);
        return inflater.inflate(R.layout.onboarding_flow, collection, false);
    }
}

