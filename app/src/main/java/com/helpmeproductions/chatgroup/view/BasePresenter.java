package com.helpmeproductions.chatgroup.view;



public interface BasePresenter<V extends BasePresenter> {
    void addView(V view);
    void removeView();
}
