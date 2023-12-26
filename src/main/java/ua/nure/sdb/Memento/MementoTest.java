package ua.nure.sdb.Memento;

import ua.nure.sdb.entity.Dish;

import java.util.ArrayList;
import java.util.List;

public class MementoTest {
    public static void main(String[] args){
        List<Dish> dishes = new ArrayList<Dish>(){};
        dishes.add(new Dish.Builder()
                .withId(124)
                .withName("Soup")
                .withPrice(153.35f)
                .build());
        Originator orig = new  Originator();
        orig.setState(dishes.get(0));
        Caretaker ct = new Caretaker();
        ct.addMemento(orig.saveState());
        dishes.get(0).setPrice(152.99f);
        orig.setState(dishes.get(0));
        ct.addMemento(orig.saveState());
        orig.restoreState(ct.previous());
        dishes.set(0, orig.getState());
        System.out.println("Current price: " + dishes.get(0).getPrice());
        orig.restoreState(ct.previous());
        dishes.set(0, orig.getState());
        System.out.println("Previous price: " + dishes.get(0).getPrice());
        System.out.println("Deleting the dish");
        dishes.remove(0);
        orig.restoreState(ct.previous());
        System.out.println("If we didn't get a mistake then the restore operation wasn't performed");
    }
}