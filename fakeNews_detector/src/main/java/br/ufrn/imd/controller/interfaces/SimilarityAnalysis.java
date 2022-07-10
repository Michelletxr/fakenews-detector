package br.ufrn.imd.controller.interfaces;

/*
 * esta interface define os metodos para similariedade dos dados
 * */
public interface SimilarityAnalysis {

    //implementação do algoritmo Distância Levenshtein
    double levDistance(String txt1, String txt2);

    //implementação do algoritmo Jaro-Winkler
    double jaroWinklerSimilarity(String txt1, String txt2);

    //metodo para testar a similariedade do texto com os dados do dataset
    //retorna o valor referente a porcentagem de similariedade
    double testSimilarity(String text);
}
