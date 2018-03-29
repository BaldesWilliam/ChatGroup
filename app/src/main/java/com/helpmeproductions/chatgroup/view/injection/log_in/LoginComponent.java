package com.helpmeproductions.chatgroup.view.injection.log_in;

import com.helpmeproductions.chatgroup.view.activities.log_in.Login;

import dagger.Component;

/**
 * Created by rynel on 3/28/2018.
 */


@Component(modules = LoginModule.class)
public interface LoginComponent {
    void inject (Login login);
}
