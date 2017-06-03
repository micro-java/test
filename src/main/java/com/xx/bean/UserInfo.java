package com.xx.bean;

/**
 * Created by richard on 2017/6/3.
 */
public class UserInfo {
    private int userId;
    private String userName;
    private String userPhoneNumber;
    private String userNote;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserNote() {
        return userNote;
    }

    public void setUserNote(String userNote) {
        this.userNote = userNote;
    }
    @Override
    public String toString(){
        return "UserInfo ID: "+userId+" userName: "+userName+" userPhoneNumber: "+userPhoneNumber+" userNote: "+userNote;
    }
}
