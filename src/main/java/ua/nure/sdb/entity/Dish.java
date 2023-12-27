package ua.nure.sdb.entity;

public class Dish {
    private long id;
    private String name;
    private float price;
    private int weight;
    private String description;
    private int category;

    public Dish() {}
    public Dish(long id, String name, float price, int weight, String description, int category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.description = description;
        this.category = category;
    }

    public static class Builder {
        private long id;
        private String name;
        private float price;
        private int weight;
        private String description;
        private int category;

        public Builder withId(long id){
            this.id = id;
            return this;
        }

        public Builder withName(String name){
            this.name = name;
            return this;
        }

        public Builder withWeight(int weight){
            this.weight = weight;
            return this;
        }

        public Builder withPrice(float price){
            this.price = price;
            return this;
        }

        public Builder withDescription(String description){
            this.description = description;
            return this;
        }

        public Builder withCategory(int category){
            this.category = category;
            return this;
        }

        public Dish build(){
            return(new Dish(id, name, price, weight, description, category));
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
