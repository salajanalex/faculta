package utils.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private List<Observer> observerList;

    public Subject() {
        observerList = new ArrayList<>();
    }

    public void register(Observer observer){
        if(observer == null){
            return;
        }
        if(!observerList.contains(observer)) {
            observerList.add(observer);
        }
    }

    public void unregister(Observer observer){
        observerList.remove(observer);
    }

    public void notifyObservers(){
        for (Observer observer:observerList) {
            observer.update();
        }
    }
}