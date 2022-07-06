package br.ufrn.imd.controller;

import br.ufrn.imd.service.PreProcessing;
import br.ufrn.imd.service.SimilarityAnalysis;
import org.apache.commons.text.similarity.JaroWinklerSimilarity;
import org.apache.commons.text.similarity.LevenshteinDistance;
import br.ufrn.imd.dao.NewsDao;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    public double levDistance(String txt1, String txt2) {
        int greaterStr=Integer.max(txt1.length(),txt2.length());

        LevenshteinDistance levenshteinDistance=new LevenshteinDistance();
        int distance=levenshteinDistance.apply(txt1,txt2);

        double normalizedIndex=(greaterStr-distance)/greaterStr;

        return normalizedIndex;
    }

    @Override
    public double jaroWinklerSimilarity(String txt1, String txt2) {

        JaroWinklerSimilarity jaroWinklerSimilarity=new JaroWinklerSimilarity();

        return jaroWinklerSimilarity.apply(txt1,txt2);
    }

    private NewsDao dao;

    @Override
    public String cleanString(String originalText) {
        System.out.println(originalText);
        String[] strArr = originalText.split(" ");//Splitting using whitespace
        ArrayList<String> listStrings = new ArrayList<String>(Arrays.asList(strArr));
        listStrings.removeIf(str-> str.length()<=3);

        String text1 = Normalizer.normalize( String.join(" ", listStrings), Normalizer.Form.NFD)
                .replaceAll("[\\p{InCombiningDiacriticalMarks}!,?]", "")
                .toLowerCase();


        String text2 = text1.replaceAll("[\\\\p{.}]", " ");
        System.out.println(text2);

        return String.join(" ", listStrings);
    }
}
