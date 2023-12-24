package ua.nure.sdb.entity;

import java.sql.Time;
import java.sql.Date;

public class Order {
    private long id;
    private int client;
    private Date date;
    private Time time;
    private int status;

    public Order() {
    }

    public Order(long id, int client, Date date, Time time, int status) {
        this.id = id;
        this.client = client;
        this.date = date;
        this.time = time;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getClient() {
        return client;
    }

    public void setClient(int client) {
        this.client = client;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
