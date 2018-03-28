package com.helpmeproductions.chatgroup.view.activities.chat_room;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.helpmeproductions.chatgroup.R;
import com.helpmeproductions.chatgroup.view.injection.chat_room.DaggerChatRoomComponent;

import javax.inject.Inject;

public class ChatRoom extends AppCompatActivity implements ChatRoomContract.View{

    @Inject ChatRoomPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_room);
        DaggerChatRoomComponent.create().inject(this);
        presenter.addView(this);

    }

    @Override
    public void showMessage(String msg) {

    }
}
