package ru.vlad.utils;

import java.util.Date;

public class Command {
    private String result;
    private Date date;
    private String key;
    private int countRequests;

    public Command(String result, String key) {
        this.key = key;
        this.result = result;
        date = new Date();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String command) {
        this.result = command;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getCountRequests() {
        return countRequests;
    }

    public void incrementCounterRequests() {
        ++countRequests;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
