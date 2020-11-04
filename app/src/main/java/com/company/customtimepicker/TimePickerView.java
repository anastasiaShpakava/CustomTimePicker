package com.company.customtimepicker;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

public class TimePickerView extends FrameLayout {

    private String[] minutesList = getResources().getStringArray(R.array.minutes);
    private String[] dayOfTimeList = getResources().getStringArray(R.array.dayOfTime);
    private String[] hoursList = getResources().getStringArray(R.array.hours);
    private ListView hoursListView;
    private ListView minutesListView;
    private ListView dayOfTimeListView;
    private HourAdapter hourAdapter;
    private MinuteAdapter minuteAdapter;
    private DayOfTimeAdapter dayOfTimeAdapter;

    public TimePickerView(final Context context) {
        super(context);
        inflate(context, R.layout.time_picker_layout, this);

        minutesListView = findViewById(R.id.minutes_list);
        minuteAdapter = new MinuteAdapter(context, minutesList);
        minutesListView.setAdapter(minuteAdapter);

        hoursListView = findViewById(R.id.hours_list);
        hourAdapter = new HourAdapter(context, hoursList);
        hoursListView.setAdapter(hourAdapter);

        dayOfTimeListView = findViewById(R.id.day_of_time_list);
        dayOfTimeAdapter = new DayOfTimeAdapter(context, dayOfTimeList);
        dayOfTimeListView.setAdapter(dayOfTimeAdapter);

        hoursListView.setOnScrollListener(scrollListener);
        minutesListView.setOnScrollListener(scrollListener);
        dayOfTimeListView.setOnScrollListener(scrollListener);
    }

    @Override
    public void setOnScrollChangeListener(OnScrollChangeListener l) {
    }

    AbsListView.OnScrollListener scrollListener = new AbsListView.OnScrollListener() {

        @Override
        public void onScrollStateChanged(final AbsListView view, int scrollState) {
            if (scrollState == SCROLL_STATE_IDLE) {
                View childView = view.getChildAt(0);
                Rect rect = new Rect(0, 0, childView.getWidth(), childView.getHeight());
                view.getChildVisibleRect(childView, rect, null);
                int position = view.getFirstVisiblePosition();
                if (rect.height() < (childView.getHeight() / 2)) {
                    position++;
                }
                final int finalPosition = position;
                view.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        view.smoothScrollToPositionFromTop(finalPosition, 0, 350);
                    }
                }, 1);
            }
        }

        @Override
        public void onScroll(final AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            for (int i = 0; i < view.getChildCount(); i++) {
                View childView = view.getChildAt(i);
                if (i == 1) {
                    childView.setBackgroundResource(R.drawable.selected_color);
                    ((TextView) childView.findViewById(R.id.textRow)).setTextColor(getResources().getColor(R.color.white));
                } else {
                    childView.setBackgroundResource(R.drawable.no_selected_color);
                    ((TextView) childView.findViewById(R.id.textRow)).setTextColor(getResources().getColor(R.color.grey));
                }
            }
        }
    };

}
