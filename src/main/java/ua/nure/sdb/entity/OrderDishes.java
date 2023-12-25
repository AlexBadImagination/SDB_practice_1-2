package ua.nure.sdb.entity;

import java.sql.Date;
import java.sql.Time;

public class OrderDishes {
    private String order;
    private String dish;
    private int amount;
    private int priority;

    public static class Builder {
        private OrderDishes newOrderDishes;

        public Builder() {
            newOrderDishes = new OrderDishes();
        }

        public Builder withOrder(String order) {
            newOrderDishes.order = order;
            return this;
        }

        public Builder withDish(String dish) {
            newOrderDishes.dish = dish;
            return this;
        }

        public Builder withAmount(int amount) {
            newOrderDishes.amount = amount;
            return this;
        }

        public Builder withPriority(int priority) {
            newOrderDishes.priority = priority;
            return this;
        }

        public OrderDishes build() {
            return newOrderDishes;
        }
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getDish() {
        return dish;
    }

    public void setDish(String dish) {
        this.dish = dish;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
