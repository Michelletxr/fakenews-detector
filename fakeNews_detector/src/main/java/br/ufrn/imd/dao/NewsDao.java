package br.ufrn.imd.dao;

import br.ufrn.imd.model.News;

import java.util.*;
/*
* Esta classe implementa o padrão dao
* Persistencia dos dados
* */
public class NewsDao  {
    //padrão singleton
    private static NewsDao newsDao;

    //map para guardar os valores lidos no dataset
    private Map<Integer, News>  database;

    //variavel que representa o dado enviado pelo usuario
    private News dataUser;

    //metodo para definir uma instancia da classe NewsDao
    public static NewsDao getInstance(){
        if(newsDao == null){
            newsDao = new NewsDao();
        }
        return newsDao;
    }

    //metodo construtor da classe NewsDao
    private NewsDao(){
        //inicializa a variavel database
        database = new HashMap<>();
    }

    //metodo para salvar os dados no database
    public void saveNewsDataBase(News news) {


        System.out.println("salvando no banco: " + news.getId());
        database.put(news.getId(),news);
    }

    //metodo para salvar o dado enviado pelo usuário

    public void saveNewsUser(News news) {
       dataUser = news;
    }

    //metodo para acessar o dado enviado pelo usuário
    public News getDataUser(){
        return dataUser;
    }

    //metodo para listar as noticias presentes no database

    public void listNews() {
        database.values().forEach( news -> System.out.println(news.getText_format()));
    }

    //metodo para retornar todas as noticias presentes no database

    public List<News> findAllNews(){
        Collection<News> values = database.values();
        return new ArrayList<News>(values);
    }

    //metodo para retornar uma noticia pelo seu id
    public  News finNewsById(Integer id){
        return database.get(id);
    }

    //método para deletar uma noticia recebendo como referencia seu id
    public void deleteNews(Integer id) {
        database.remove(id);
    }

    //método para atualizar uma noticia recebendo como referencia seu id
    public void updateNews( Integer id, News news) {
            database.replace(id, news);
    }
}
