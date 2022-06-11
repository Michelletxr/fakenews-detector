module com.example.fakenews_detector {
    requires javafx.controls;
    requires javafx.fxml;
            
                        requires org.kordamp.bootstrapfx.core;
            
    opens br.ufrn.imd to javafx.fxml;
    exports br.ufrn.imd;
}