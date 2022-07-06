package br.ufrn.imd.controller;

import br.ufrn.imd.model.news.News;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;


public class ImportDataCsv {


    private Scanner input;
    private List<String[]> lines = new ArrayList<>();
    private ManipuleData manipule = new ManipuleData();

    static final String PATH_FILE = "/home/michelle/semestre/projeto_final/fakeNews_detector/src/main/java/br/ufrn/imd/controller/boatos.csv";

    public void readCSV() throws IOException, CsvException {

        Reader reader = Files.newBufferedReader(Paths.get(PATH_FILE));
        CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();

        List<String[]> news= csvReader.readAll();
        for (String[] fakenews : news){
            buildDataToNews(List.of(fakenews)).getText_original();
        }

    }

    private News buildDataToNews(List<String> data){
        News fakenews = new News();
        fakenews.setId(parseInt(data.get(0)));
        fakenews.setText_original(data.get(1));
        fakenews.setLink(data.get(2));
        String[] data1 = fakenews.getText_original().split(" ");
        System.out.println(manipule.cleanString(fakenews.getText_original()));
        //fakenews.setTimestamp(ZonedDateTime.parse(data.get(3)));
        return fakenews;

    }



}
