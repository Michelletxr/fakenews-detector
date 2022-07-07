package br.ufrn.imd.controller;

import br.ufrn.imd.controller.interfaces.PreProcessing;
import br.ufrn.imd.controller.interfaces.SimilarityAnalysis;
import br.ufrn.imd.model.News;
import org.apache.commons.text.similarity.JaroWinklerSimilarity;
import org.apache.commons.text.similarity.LevenshteinDistance;
import br.ufrn.imd.dao.NewsDao;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.parseInt;

/*
*
* classe responsável por manipular os dados
*
* pre-processar os dados (tratamento)
* executar os algoritmos de comparação (análise)
*
*
* */
public abstract class ManipuleData implements SimilarityAnalysis, PreProcessing {

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
        System.out.println("TEXTO ORIGINAL:" + originalText);
        String text = originalText.replaceAll("[.,]","  ");
        String[] strArr =text.toLowerCase().replaceAll("[\\p{InCombiningDiacriticalMarks}!?*()]", "").split("\\s");//Splitting using whitespace
        ArrayList<String> listStrings = new ArrayList<String>(Arrays.asList(strArr));
        listStrings.removeIf(str-> str.length()<=3);
        String text1 = Normalizer.normalize( String.join(" ", listStrings), Normalizer.Form.NFD);

        System.out.println("TEXTO MODIFICADO: " +  text1);

        return String.join(" ", listStrings);
    }

       protected News buildDataToNews(List<String> data){
            News fakenews = new News();
            fakenews.setId(parseInt(data.get(0)));
            fakenews.setText_original(data.get(1));
            fakenews.setLink(data.get(2));
            String[] data1 = fakenews.getText_original().split(" ");
            fakenews.setText_format(cleanString(fakenews.getText_original()));
            return fakenews;

        }

        public abstract void saveData();
}
