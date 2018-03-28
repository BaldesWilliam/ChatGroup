package com.helpmeproductions.chatgroup.model;


import java.util.ArrayList;
import java.util.List;

public class Message {
    private User user;
    private String msg;
    private String date;
    private Boolean containsLink;
    private List<String> links;

    public Message(User user, String msg, String date) {
        this.user = user;
        this.msg = msg;
        this.date = date;
        this.containsLink = checkForLink(msg);
        if(containsLink){
            links = new ArrayList<>();
            for (String s : msg.split("\\s")){
                if(s.endsWith(".com")){
                    links.add(s);
                }
            }
        }
    }


    private Boolean checkForLink(String msg) {
        for (String s : msg.split("\\s")){
            if(s.endsWith(".com")){
                return true;
            }
        }
        return false;
    }

    public User getUser() {
        return user;
    }

    public String getMsg() {
        return msg;
    }

    public String getDate() {
        return date;
    }

    public Boolean getContainsLink() {
        return containsLink;
    }

    public List<String> getLinks() {
        return links;
    }

    public String postMessage(){
        return date + ": ["+ user.getName() + "]:" + msg;
    }


}
