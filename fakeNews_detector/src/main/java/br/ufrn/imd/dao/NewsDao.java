package br.ufrn.imd.dao;

import br.ufrn.imd.model.News;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NewsDao  {
    //padrão singleton
    private static NewsDao newsDao;
   ;
    private Map<Integer, News>  database;

    public static NewsDao getInstance(){
        if(newsDao == null){
            newsDao = new NewsDao();
        }
        return newsDao;
    }

    private NewsDao(){
        database = new HashMap<>();
    }

    public void saveNews(News news) {
        database.put(news.getId(),news);
    }

    public void listNews() {
        database.values().forEach( news -> System.out.println(news));
    }




    public void deleteNews(Integer id) {
        database.remove(id);
    }


    public void updateNews( Integer id, News news) {
            database.replace(id, news);
    }
}
