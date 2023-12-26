package ua.nure.sdb.Memento;

import java.util.ArrayList;
import java.util.List;

public class Caretaker {
    private List<Memento> mementoList = new ArrayList();
    private int index = 0;

    public Memento previous() {

        return (index > 0)?this.mementoList.get(--index):null;

    }
    public Memento next() {

        return (index < this.mementoList.size())?this.mementoList.get(++index):null;

    }

    public void addMemento(Memento memento) {
        if(index < this.mementoList.size())
        {
            for(int i = index; i < this.mementoList.size(); i++)
                this.mementoList.remove(i);
        }
        this.mementoList.add(memento);
        index++;
    }
}
