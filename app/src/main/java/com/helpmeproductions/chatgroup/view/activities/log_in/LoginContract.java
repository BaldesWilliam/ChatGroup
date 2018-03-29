package com.helpmeproductions.chatgroup.view.activities.log_in;

import android.content.Context;

import com.helpmeproductions.chatgroup.view.BasePresenter;
import com.helpmeproductions.chatgroup.view.BaseView;

/**
 * Created by rynel on 3/28/2018.
 */


public interface LoginContract {
    interface View extends BaseView{

    }
    interface Presenter extends BasePresenter<View>{
        void createUserId(String email, String password, Context context);
        void signIn(String email, String password, Context context);
    }
}
