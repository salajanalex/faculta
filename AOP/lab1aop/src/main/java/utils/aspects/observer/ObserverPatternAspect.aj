package utils.aspects.observer;

import controller.Controller;
import repository.NewsRepository;
import ui.Reader;

import java.util.ArrayList;
import java.util.List;

/**
 * cine implementeaza subject si observer
 */
public aspect ObserverPatternAspect {
    declare parents: NewsRepository implements Subject;
    declare parents: Reader implements Observer;

    /**
     * implementare Subject
     * @param o
     */
    private List<Observer> Subject.observers = new ArrayList<>();

    public void Subject.addObserver(Observer o){
        observers.add(o);
    }

    public void Subject.removeObserver(Observer o){
        observers.remove(o);
    }

    public void Subject.notifyObservers(){
        for (Observer o : observers){
            o.update();
        }
    }

    /**
     * pt @ChangeState
     */
    pointcut observed(NewsRepository newsRepository): @annotation(ChangeState) && this(newsRepository);

    /**
     * La creerea Reader-ului il inregistram ca Observer
     */
    after (Reader reader, Controller controller): initialization(ui.Reader.new(*))
            && this(reader) && args(controller){
        controller.getNewsRepository().addObserver(reader);
    }

    /**
     * la fiecare apelare de metoda cu @ChangeState -> notifyObserver
     */
    after (NewsRepository repo) returning: observed(repo){
        repo.notifyObservers();
    }

    /**
     * Implementare Observer
     */
    public void Reader.update(){
        refreshList();
    }

}
