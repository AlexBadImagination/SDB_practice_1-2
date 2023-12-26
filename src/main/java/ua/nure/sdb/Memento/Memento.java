package ua.nure.sdb.Memento;

import ua.nure.sdb.entity.Dish;

public class Memento {
    private final Dish state;

    public Memento(Dish state) {
        this.state = clone(state);
    }

    private Dish clone(Dish state) {
        Dish dish = new Dish.Builder()
                .withId(state.getId())
                .withName(state.getName())
                .withPrice(state.getPrice())
                .withWeight(state.getWeight())
                .withDescription(state.getDescription())
                .withCategory(state.getCategory())
                .build();
        return dish;
    }

    public Dish getState() {
        return state;
    }
}
