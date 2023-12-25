package ua.nure.sdb.entity;

import java.util.Locale;

public class Dish {
    private String id;
    private String name;
    private float price;
    private int weight;
    private String description;
    private int category;

    public static class Builder {
        private Dish newDish;

        public Builder() {
            newDish = new Dish();
        }
        public Builder withId(String id){
            newDish.id = id;
            return this;
        }

        public Builder withName(String name){
            newDish.name = name;
            return this;
        }

        public Builder withWeight(int weight){
            newDish.weight = weight;
            return this;
        }

        public Builder withPrice(float price){
            newDish.price = price;
            return this;
        }

        public Builder withDescription(String description){
            newDish.description = description;
            return this;
        }

        public Builder withCategory(int category){
            newDish.category = category;
            return this;
        }

        public Dish build(){
            return newDish;
        }

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }
}
