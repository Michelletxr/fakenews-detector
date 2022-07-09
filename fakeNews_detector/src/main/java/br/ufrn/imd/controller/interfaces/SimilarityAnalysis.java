package br.ufrn.imd.controller.interfaces;

public interface SimilarityAnalysis {
    double levDistance(String txt1, String txt2);

    double jaroWinklerSimilarity(String txt1, String txt2);

    double testSimilarity(String text);
}
