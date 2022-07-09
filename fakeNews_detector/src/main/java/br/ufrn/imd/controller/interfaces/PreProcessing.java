package br.ufrn.imd.controller.interfaces;

import br.ufrn.imd.model.News;

import java.util.List;

public interface PreProcessing {
    String cleanString(String originalText);
    News buildDataToNews(List<String> data);
}
