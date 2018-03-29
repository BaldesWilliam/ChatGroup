package com.helpmeproductions.chatgroup.view.injection.log_in;

import com.helpmeproductions.chatgroup.view.activities.log_in.LoginPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by rynel on 3/28/2018.
 */

@Module
public class LoginModule {
    @Provides
    public LoginPresenter loginPresenter(){
        return new LoginPresenter();
    }
}
