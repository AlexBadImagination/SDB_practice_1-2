package ua.nure.sdb.entity;

import java.sql.Time;
import java.sql.Date;

public class Order {
    private String id;
    private int client;
    private Date date;
    private Time time;
    private int status;

    public static class Builder {
        private Order newOrder;

        public Builder() {
            newOrder = new Order();
        }

        public Builder withId(String id) {
            newOrder.id = id;
            return this;
        }

        public Builder withClient(int client) {
            newOrder.client = client;
            return this;
        }

        public Builder withTime(Time time) {
            newOrder.time = time;
            return this;
        }

        public Builder withDate(Date date) {
            newOrder.date = date;
            return this;
        }

        public Builder withStatus(int status) {
            newOrder.status = status;
            return this;
        }

        public Order build() {
            return newOrder;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
