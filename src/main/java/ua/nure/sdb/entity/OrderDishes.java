package ua.nure.sdb.entity;

public class OrderDishes {
    private int order;
    private int dish;
    private int amount;
    private int priority;

    public OrderDishes() {
    }

    public OrderDishes(int order, int dish, int amount, int priority) {
        this.order = order;
        this.dish = dish;
        this.amount = amount;
        this.priority = priority;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getDish() {
        return dish;
    }

    public void setDish(int dish) {
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
