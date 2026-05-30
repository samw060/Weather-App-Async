module com.sam.weather.weatherapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.net.http;
    requires com.google.gson;

    opens com.sam.weather.weatherapp to javafx.fxml;
    exports com.sam.weather.weatherapp;
}