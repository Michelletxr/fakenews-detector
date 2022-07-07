module com.example.fakenews_detector {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.opencsv;

    requires org.kordamp.bootstrapfx.core;
    requires org.apache.commons.text;

    opens br.ufrn.imd to javafx.fxml;
    exports br.ufrn.imd;
}