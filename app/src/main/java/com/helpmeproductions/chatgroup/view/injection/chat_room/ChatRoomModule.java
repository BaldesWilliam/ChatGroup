package com.helpmeproductions.chatgroup.view.injection.chat_room;

import com.helpmeproductions.chatgroup.view.activities.chat_room.ChatRoomPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class ChatRoomModule {
    @Provides
    public ChatRoomPresenter chatRoomPresenterProvider(){
        return new ChatRoomPresenter();
    }

}
