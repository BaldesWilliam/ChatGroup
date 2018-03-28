package com.helpmeproductions.chatgroup.view.injection.chat_room;

import com.helpmeproductions.chatgroup.view.activities.chat_room.ChatRoom;

import dagger.Component;

@Component(modules = ChatRoomModule.class)
public interface ChatRoomComponent {
    void inject(ChatRoom chatRoom);
}
