package br.ufrn.imd.dao;

import br.ufrn.imd.model.News;

import java.util.*;

public class NewsDao  {
    //padrão singleton
    private static NewsDao newsDao;
    private Map<Integer, News>  database;

    private News dataUser; //dado enviado pelo usuario

    public static NewsDao getInstance(){
        if(newsDao == null){
            newsDao = new NewsDao();
        }
        return newsDao;
    }

    private NewsDao(){
        database = new HashMap<>();
    }

    public void saveNewsDataBase(News news) {


        System.out.println("salvando no banco: " + news.getId());
        database.put(news.getId(),news);
    }

    public void saveNewsUser(News news) {
       dataUser = news;
    }

    public News getDataUser(){
        return dataUser;
    }

    public void listNews() {
        database.values().forEach( news -> System.out.println(news.getText_format()));
    }

    public List<News> findAllNews(){
        Collection<News> values = database.values();
        return new ArrayList<News>(values);
    }

    public  News finNewsById(Integer id){
        return database.get(id);
    }

    public void deleteNews(Integer id) {
        database.remove(id);
    }

    public void updateNews( Integer id, News news) {
            database.replace(id, news);
    }
}
