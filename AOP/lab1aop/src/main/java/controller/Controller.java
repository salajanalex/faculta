package controller;

import model.News;
import repository.NewsRepository;

import java.util.logging.Logger;

public class Controller {

    private NewsRepository newsRepository = NewsRepository.getInstance();

    public static final Logger LOGGER = Logger.getLogger(Controller.class.getName());

    public Controller(){
    }

    public NewsRepository getNewsRepository() {
        return newsRepository;
    }

    public void addNews(String title, String content){
        int id = 0;
        for (News news : newsRepository.getAllNews()){
            if (news.getId()>id) {
                id = news.getId();
            }
        }
        id++;

        newsRepository.addNews(new News(id, title, content));
    }

    public void removeNews(int id) {
        newsRepository.removeNews(id);
    }

//    public void subscribe(Observer observer){
//        newsRepository.register(observer);
//    }
//
//    public void unSubscribe(Observer observer){
//        newsRepository.unregister(observer);
//    }

}
