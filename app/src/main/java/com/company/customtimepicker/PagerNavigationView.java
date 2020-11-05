package com.company.customtimepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.tabs.TabLayout;

public class PagerNavigationView extends LinearLayout {
    private OnClickListener onNextButtonClickListener;
    private ImageButton buttonToNextView;
    private TabLayout currentPositionIndicatorView;
    private int buttonWidth;
    private int calculatedScreenMiddle;

    public PagerNavigationView(@NonNull Context context) {
        super(context);
    }

    public PagerNavigationView(@NonNull final Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater mInflater = LayoutInflater.from(context);
        View v = mInflater.inflate(R.layout.pager_navigation, this, true);

        buttonToNextView = v.findViewById(R.id.nextOnboardingStepButtonB);

        ViewTreeObserver vto = buttonToNextView.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                buttonWidth = buttonToNextView.getWidth();
            }
        });

        currentPositionIndicatorView = v.findViewById(R.id.tab_layout);
        currentPositionIndicatorView.setTabGravity(TabLayout.GRAVITY_CENTER);

        currentPositionIndicatorView.addTab(currentPositionIndicatorView.newTab().setIcon(R.drawable.tab_indicator_selected));
        currentPositionIndicatorView.addTab(currentPositionIndicatorView.newTab().setIcon(R.drawable.tab_indicator_default));

        currentPositionIndicatorView.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                if (position == 1) {
                    Toast.makeText(context, "first", Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(context, "NOfirst", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


    public void setOnNextButtonClickListener(OnClickListener onNextButtonClickListener) {
        this.onNextButtonClickListener = onNextButtonClickListener;
        buttonToNextView.setOnClickListener(onNextButtonClickListener);
    }

    public int calculateScreenMiddle() {
        DisplayMetrics metrics = new DisplayMetrics();
        ((MainActivity) getContext()).getWindowManager().getDefaultDisplay().getRealMetrics(metrics);

        boolean isDisplayPortrait = getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT;
        int middleScreen = isDisplayPortrait ? metrics.widthPixels / 2 : metrics.heightPixels / 2;
        calculatedScreenMiddle = middleScreen - buttonWidth / 2;
        return calculatedScreenMiddle;
    }
//
//    public void onLastPageReached(int position) {
//        TranslateAnimation animationToMove = new TranslateAnimation(0, -calculateScreenMiddle(), 0, 0);
//        animationToMove.setDuration(3000);
//        animationToMove.setFillAfter(true);
//        TranslateAnimation animationToReturn = new TranslateAnimation(0, -calculateScreenMiddle(), 0, 0);
//        if (position == 1) {
//            buttonToNextView.startAnimation(animationToMove);
//        } else {
//            buttonToNextView.startAnimation(animationToReturn);
//        }
//    }

    public void onScrollToLastPagePercentage(int position, int movingDistanceForButton) {
        if (position == 1) {
            buttonToNextView.animate().translationXBy(movingDistanceForButton).start();
        } else {
            buttonToNextView.setTranslationX(-movingDistanceForButton);
        }
    }
}

