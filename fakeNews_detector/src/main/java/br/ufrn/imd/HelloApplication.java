package br.ufrn.imd;

import br.ufrn.imd.controller.ImportDataCsv;
import br.ufrn.imd.controller.NewsController;
import com.opencsv.exceptions.CsvException;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        ImportDataCsv load = new ImportDataCsv();
        try {
            load.loadCSVData();
        }catch (CsvException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        NewsController controller = new NewsController();
        controller.testSimilarity();

        //dao = NewsDao.getInstance();
       // dao.listNews();

       /* FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
       // stage.show();*/
    }

    public static void main(String[] args) {
        launch();
    }
}