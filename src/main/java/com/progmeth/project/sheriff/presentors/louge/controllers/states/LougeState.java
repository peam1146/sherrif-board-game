package com.progmeth.project.sheriff.presentors.louge.controllers.states;

public class LougeState {
    private String serverIP;
    private String userName;
    public LougeState() {
        this.serverIP = "";
        this.userName = "";
    }

    public String getServerIP() {
        return serverIP;
    }
    public void setServerIP(String serverIP) {
        this.serverIP = serverIP;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
}
