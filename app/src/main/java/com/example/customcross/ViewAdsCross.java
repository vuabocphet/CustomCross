package com.example.customcross;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ViewAdsCross extends FrameLayout {

    private EvenAdsCross evenAdsCross;
    private boolean isShowTvInfoAds = false;

    public void setEvenAdsCross(EvenAdsCross evenAdsCross) {
        this.evenAdsCross = evenAdsCross;
    }

    private EvenAdsCross getEvenAdsCross() {
        return this.evenAdsCross == null ? new EvenAdsCross() {
            @Override
            public void onOpenInfoAds() {

            }

            @Override
            public void onOpenAdsGooglePlay() {

            }
        } : this.evenAdsCross;
    }


    @BindView(R.id.tv_ads_info)
    AppCompatTextView tvAdsInfo;

    @OnClick({R.id.iv_ads_info, R.id.bt_open_ads, R.id.tv_ads_info})
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.iv_ads_info:
            case R.id.tv_ads_info:
                if (this.isShowTvInfoAds) {
                    this.getEvenAdsCross().onOpenInfoAds();
                    this.isShowTvInfoAds = false;
                    this.tvAdsInfo.setVisibility(GONE);
                    return;
                }
                this.tvAdsInfo.setVisibility(VISIBLE);
                this.isShowTvInfoAds = true;
                return;
            case R.id.bt_open_ads:
                this.getEvenAdsCross().onOpenAdsGooglePlay();
        }

    }

    public ViewAdsCross(@NonNull Context context) {
        super(context);
        this.init();
    }

    public ViewAdsCross(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.init();
    }

    public ViewAdsCross(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.init();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    private void init() {
        View view = inflate(getContext(), R.layout.view_ads_cross, null);
        this.addView(view);
        ButterKnife.bind(this, view);
    }

    public interface EvenAdsCross {

        void onOpenInfoAds();

        void onOpenAdsGooglePlay();

    }
}
