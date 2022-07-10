package br.ufrn.imd.controller;
import br.ufrn.imd.dao.NewsDao;
import br.ufrn.imd.model.News;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


/*
* Classe responsável por ler e salvar os dados do dataset
*
* */
public class ImportDataCsv extends ManipuleData {

    //array que irá receber as linhas de dados do dataset
    private List<String[]> lines = new ArrayList<>();


    //path do arquvo csv com o dados
    static final String PATH_FILE = "fakeNews_detector/src/main/resources/dataset/boatos.csv";

    //método para ler os dados do arquivo csv
    public void loadCSVData() throws IOException, CsvException {

        Reader reader = Files.newBufferedReader(Paths.get(PATH_FILE));
        CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();

        List<String[]> news= csvReader.readAll();
        for (String[] fakenews : news){
            saveData(this.buildDataToNews(List.of(fakenews)));
        }

    }

    //implementação do método abstrato herdado da classe ManipuleData
    @Override
    //salva no "banco de dados"
    public void saveData(News news){
        this.dao = NewsDao.getInstance();
        this.dao.saveNewsDataBase(news);
    }
}
