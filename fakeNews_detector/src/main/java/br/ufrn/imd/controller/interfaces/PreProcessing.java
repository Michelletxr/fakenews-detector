package br.ufrn.imd.controller.interfaces;

import br.ufrn.imd.model.News;

import java.util.List;

/*
* esta interface define os metodos para pre-processamento dos dados
* */
public interface PreProcessing {

    //define o tratamento da string
    //retirada de acentos, colocar as palavras em minuscula, ordenar textos....
    String cleanString(String originalText);

    //transforma um dado abstrato em um objeto do tipo News
    News buildDataToNews(List<String> data);
}
