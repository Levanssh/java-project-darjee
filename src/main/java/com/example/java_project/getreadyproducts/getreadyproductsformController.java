package com.example.java_project.getreadyproducts;

import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.example.java_project.DatabaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

public class getreadyproductsformController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button GRPbtnrecieved;

    @FXML
    private Button GRPbtnsearch;

    @FXML
    private ComboBox<String> GRPcomboworkers;

    @FXML
    private ListView<String> GRPlistdod;

    @FXML
    private ListView<String> GRPlistorders;

    @FXML
    private ListView<String> GRPlistproducts;

    PreparedStatement stmt;
    @FXML
    void doSearch(ActionEvent event) {

        try
        {
            Statement stmt= con.createStatement();
            String query="select * from measurements where worker='"+GRPcomboworkers.getSelectionModel().getSelectedItem().toString()+"'"+";";
            ResultSet rs= stmt.executeQuery(query);


            GRPlistorders.getItems().clear();
            GRPlistproducts.getItems().clear();
            GRPlistdod.getItems().clear();
            while(rs.next())
            {
                Integer orderid= rs.getInt("orderid");
                String dress= rs.getString("dress");
                Date dodel= rs.getDate("dodel");

//                LocalDate local=dodel.getValue();
//                java.sql.Date date=java.sql.Date.valueOf(local);
//                stmt.setDate(5, date);

                System.out.println();
                System.out.println("==================");
                System.out.println("orderid: "+ orderid);
                System.out.println("dress: "+ dress);
                System.out.println("Delivery Date: "+ dodel);

                GRPlistorders.getItems().add(String.valueOf(orderid));
                GRPlistproducts.getItems().add(dress);
                GRPlistdod.getItems().add(String.valueOf(dodel));
//
            }

        }
        catch(Exception exp)
        {
            exp.printStackTrace();
        }

    }

    @FXML
    void doRecieveAll(ActionEvent event) {

    }

    Connection con;
    @FXML
    void initialize() {
        assert GRPbtnrecieved != null : "fx:id=\"GRPbtnrecieved\" was not injected: check your FXML file 'getreadyproductsformView.fxml'.";
        assert GRPcomboworkers != null : "fx:id=\"GRPcomboworkers\" was not injected: check your FXML file 'getreadyproductsformView.fxml'.";
        assert GRPlistdod != null : "fx:id=\"GRPlistdod\" was not injected: check your FXML file 'getreadyproductsformView.fxml'.";
        assert GRPlistorders != null : "fx:id=\"GRPlistorders\" was not injected: check your FXML file 'getreadyproductsformView.fxml'.";
        assert GRPlistproducts != null : "fx:id=\"GRPlistproducts\" was not injected: check your FXML file 'getreadyproductsformView.fxml'.";


        con = DatabaseConnection.doConnect();
        if(con==null)
            System.out.println("Connection Did not Established");
        else
            System.out.println("Connection Done");

        yesYes();

    }

    void yesYes()
    {
        String cate[]={"pappu","mohanlal","happy"};
        GRPcomboworkers.getItems().addAll(cate);
//        comboItems.getSelectionModel().select(0);
    }

}
