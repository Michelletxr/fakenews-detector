package br.ufrn.imd.controller;

import br.ufrn.imd.service.PreProcessing;
import br.ufrn.imd.service.SimilarityAnalysis;
/*
*
* classe responsável por manipular os dados
*
* pre-processar os dados (tratamento)
* executar os algoritmos de comparação (análise)
*
*
* */
public class ManipuleData implements PreProcessing, SimilarityAnalysis{

    @Override
    public double levDistance() {
        return 0;
    }

    @Override
    public double trigramAlgorithm() {
        return 0;
    }
}
