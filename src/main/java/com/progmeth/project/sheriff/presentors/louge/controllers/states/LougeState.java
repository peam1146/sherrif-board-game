package com.progmeth.project.sheriff.presentors.louge.controllers.states;

/**
 * Louge state
 */
public class LougeState {
    /**
     * server ip
     */
    private String serverIP;
    /**
     * user name
     */
    private String userName;

    /**
     * Constructor
     */
    public LougeState() {
        this.serverIP = "";
        this.userName = "";
    }

    /**
     * get server ip
     *
     * @return server ip
     */
    public String getServerIP() {
        return serverIP;
    }

    /**
     * set server ip
     *
     * @param serverIP server ip
     */
    public void setServerIP(String serverIP) {
        this.serverIP = serverIP;
    }

    /**
     * get username
     *
     * @return username
     */
    public String getUserName() {
        return userName;
    }

    /**
     * set username
     *
     * @param userName username
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
}
