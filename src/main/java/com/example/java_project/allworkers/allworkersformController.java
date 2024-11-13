package com.example.java_project.allworkers;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

import com.example.java_project.DatabaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;

public class allworkersformController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button AWbtnallworkers;

    @FXML
    private ComboBox<String> AWsplzcombo;

    @FXML
    private TableView<String> AWtblallworkers;

    @FXML
    void AWshowWorkers(ActionEvent event) {

    }

    Connection con;
    @FXML
    void initialize() {
        assert AWbtnallworkers != null : "fx:id=\"AWbtnallworkers\" was not injected: check your FXML file 'allworkersformView.fxml'.";
        assert AWsplzcombo != null : "fx:id=\"AWsplzcombo\" was not injected: check your FXML file 'allworkersformView.fxml'.";
        assert AWtblallworkers != null : "fx:id=\"AWtblallworkers\" was not injected: check your FXML file 'allworkersformView.fxml'.";


        con = DatabaseConnection.doConnect();
        if(con==null)
            System.out.println("Connection Did not Established");
        else
            System.out.println("Connection Done");
}

}