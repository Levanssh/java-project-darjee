package com.example.java_project;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    public static Connection doConnect()
    {
        Connection con= null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost/javaproject","root","kabaddi@2511");
        }
        catch(Exception exp)
        {
            System.out.println(exp.fillInStackTrace().toString());
        }

        return con;

    }

    public static void main(String args[])
    {
        if(doConnect()==null)
        {
            System.out.println("Sorry");
        }
        else
        {
            System.out.println("Badhaai");
        }
    }

}
