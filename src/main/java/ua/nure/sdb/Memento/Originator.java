package ua.nure.sdb.Memento;

import ua.nure.sdb.entity.Dish;

public class Originator {
    private Dish state;

    public void setState(Dish state) {
        this.state = state;
    }

    public Dish getState() {
        return state;
    }

    public Memento saveState() {
        return new Memento(state);
    }

    public void restoreState(Memento memento) {
        if(memento == null){
            return;
        }
        this.state = memento.getState();
    }
}
