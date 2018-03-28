package com.helpmeproductions.chatgroup.view.activities.chat_room;


public class ChatRoomPresenter implements ChatRoomContract.Presenter{
    private ChatRoomContract.View view;

    @Override
    public void addView(ChatRoomContract.View view) {
        this.view = view;
    }

    @Override
    public void removeView() {
        this.view = null;
    }
}
