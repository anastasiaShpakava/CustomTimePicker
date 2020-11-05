package com.company.customtimepicker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private CustomPagerAdapter customPagerAdapter;
    private PagerNavigationView pagerNavigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pagerNavigationView = findViewById(R.id.pager_navigation_view);
        customPagerAdapter = new CustomPagerAdapter(this);

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(customPagerAdapter);
        customPagerAdapter.setPagerNavigationView(pagerNavigationView);
    }
}