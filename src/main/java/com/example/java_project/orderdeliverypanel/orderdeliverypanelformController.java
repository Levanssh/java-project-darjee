package com.example.java_project.orderdeliverypanel;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import com.example.java_project.DatabaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class orderdeliverypanelformController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ListView<String> ODPbilllist;

    @FXML
    private Button ODPbtndeliveredall;

    @FXML
    private Button ODPbtndofindorders;

    @FXML
    private ListView<String> ODPitemlist;

    @FXML
    private ListView<String> ODPorderidlist;

    @FXML
    private ListView<String> ODPstatuslist;

    @FXML
    private TextField ODPtotalbill;

    @FXML
    private TextField ODPtxtmobile;

    @FXML
    void doDeliveredAll(ActionEvent event) {

    }

    PreparedStatement stmt;
    @FXML
    void doFindOrders(ActionEvent event) {

        try
        {
            Statement stmt= con.createStatement();
            String query="select * from measurements where mobile='"+ODPtxtmobile.getText()+"'"+";";
            ResultSet rs= stmt.executeQuery(query);


            ODPbilllist.getItems().clear();
            ODPitemlist.getItems().clear();
            ODPstatuslist.getItems().clear();
            ODPorderidlist.getItems().clear();
            while(rs.next())
            {
                Integer status= rs.getInt("status");
                Integer bill= rs.getInt("bill");
                Integer orderid= rs.getInt("orderid");
                String dress= rs.getString("dress");

//                LocalDate local=dodel.getValue();
//                java.sql.Date date=java.sql.Date.valueOf(local);
//                stmt.setDate(5, date);

//                System.out.println();
//                System.out.println("==================");
//                System.out.println("orderid: "+ orderid);
//                System.out.println("dress: "+ dress);
//                System.out.println("Delivery Date: "+ dodel);

                ODPorderidlist.getItems().add(String.valueOf(orderid));
                ODPstatuslist.getItems().add(String.valueOf(status));
                ODPitemlist.getItems().add(dress);
                ODPbilllist.getItems().add(String.valueOf(bill));

                System.out.println(orderid);
                System.out.println(bill);
                System.out.println(dress);
                System.out.println(status);

//
            }

        }
        catch(Exception exp)
        {
            exp.printStackTrace();
        }


    }

    Connection con;
    @FXML
    void initialize() {
        assert ODPbilllist != null : "fx:id=\"ODPbilllist\" was not injected: check your FXML file 'orderdeliverypanelformView.fxml'.";
        assert ODPbtndeliveredall != null : "fx:id=\"ODPbtndeliveredall\" was not injected: check your FXML file 'orderdeliverypanelformView.fxml'.";
        assert ODPbtndofindorders != null : "fx:id=\"ODPbtndofindorders\" was not injected: check your FXML file 'orderdeliverypanelformView.fxml'.";
        assert ODPitemlist != null : "fx:id=\"ODPitemlist\" was not injected: check your FXML file 'orderdeliverypanelformView.fxml'.";
        assert ODPorderidlist != null : "fx:id=\"ODPorderidlist\" was not injected: check your FXML file 'orderdeliverypanelformView.fxml'.";
        assert ODPstatuslist != null : "fx:id=\"ODPstatuslist\" was not injected: check your FXML file 'orderdeliverypanelformView.fxml'.";
        assert ODPtotalbill != null : "fx:id=\"ODPtotalbill\" was not injected: check your FXML file 'orderdeliverypanelformView.fxml'.";
        assert ODPtxtmobile != null : "fx:id=\"ODPtxtmobile\" was not injected: check your FXML file 'orderdeliverypanelformView.fxml'.";


        con = DatabaseConnection.doConnect();
        if(con==null)
            System.out.println("Connection Did not Established");
        else
            System.out.println("Connection Done");

    }

}
