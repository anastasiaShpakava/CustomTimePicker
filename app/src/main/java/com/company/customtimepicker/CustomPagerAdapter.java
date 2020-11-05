package com.company.customtimepicker;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import org.jetbrains.annotations.NotNull;

public class CustomPagerAdapter extends PagerAdapter {
    private Context context;
    private View.OnClickListener onNextButtonClickListener;
    private ViewPager viewPager;
    private PagerNavigationView pagerNavigationView;

    public CustomPagerAdapter(Context context) {
        this.context = context;
        viewPager = ((MainActivity) context).findViewById(R.id.viewPager);

        onNextButtonClickListener = new View.OnClickListener() {
            public void onClick(View v) {
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
            }
        };

        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                positionOffsetPixels = (int) (pagerNavigationView.calculateScreenMiddle() * positionOffset);
                pagerNavigationView.onScrollToLastPagePercentage(position, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                 //  pagerNavigationView.onLastPageReached(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    public void setPagerNavigationView(PagerNavigationView pagerNavigationView) {
        this.pagerNavigationView = pagerNavigationView;
        pagerNavigationView.setOnNextButtonClickListener(onNextButtonClickListener);
    }

    @NotNull
    @Override
    public Object instantiateItem(@NotNull final ViewGroup container, int position) {

        //    pagerNavigationView.getCurrentPositionIndicatorView().setupWithViewPager(viewPager);

        final TimePickerView timePickerView = new TimePickerView(context);
        View view = null;
        switch (position) {
            case 0:
                view = timePickerView;
                break;
            case 1:
                view = SecondCustomView.getView(context, container);
                break;
        }
        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public boolean isViewFromObject(@NotNull View view, @NotNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
