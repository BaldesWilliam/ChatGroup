package com.helpmeproductions.chatgroup.view;



public interface BasePresenter<V extends BaseView> {
    void addView(V view);
    void removeView();
}
