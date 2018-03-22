package repository;

import model.News;

import java.util.List;

public interface Repository {

     void addNews(News news);
     void removeNews(int id);
     List<News> getAllNews();

    // void updateNews(News oldNews, News newNews);
    // News getNewsById(Integer id);
}
