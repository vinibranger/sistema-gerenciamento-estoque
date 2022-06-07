module br.com.vinicius.sistoque {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens br.com.vinicius.sistoque to javafx.fxml;
    exports br.com.vinicius.sistoque;
}
