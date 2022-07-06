package br.ufrn.imd.service;

public interface SimilarityAnalysis {
    public double levDistance(String txt1, String txt2);

    public double jaroWinklerSimilarity(String txt1, String txt2);
}
