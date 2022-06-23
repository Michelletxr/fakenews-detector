package br.ufrn.imd.dao;


/**
 * classe abstrata
 *  métodos para representar as funcionalidades  do banco de dados
 *
 * */
public abstract class DataBase {

    public abstract void saveNews();
    public abstract void deleteNews();
    public abstract void updateNews();
}
