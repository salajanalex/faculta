package ui;

import model.News;
import repository.NewsRepository;

import java.util.ArrayList;
import java.util.List;

public class Main {
    /**
     * getInstance apeleaza singur "new" dar doar 1 data pt oricati clienti(controllers)
     */
    static NewsRepository newsRepository = NewsRepository.getInstance();

    public static void main(String[] args) {

        //News news = new News(3,"Cnad", "atunci cand dansezi");

        //newsRepository.addNews(news);
        newsRepository.removeNews(2);
        List<News> newsList = new ArrayList<>();
        newsList=newsRepository.getAllNews();
        for (News newss:newsList) {
            System.out.println(newss.toString());
        }
    }
}
