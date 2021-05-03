package org.horizoncolumbus.hs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {

        Connection connection = null;

        String url = "jdbc:sqlite:Resources/student.db";
        

        try {
            connection = DriverManager.getConnection(url);
            System.out.println("Connection Success!");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }


        String sqlCreateCmd = "create table students " +
                "(id INTEGER, student_name TEXT, grade_level INTEGER, favorite_subject TEXT;";

        try {
            Statement statement = connection.createStatement();
            statement.execute(sqlCreateCmd);
            System.out.println("Table Creation Success!");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        String sqlInsertCommand = "insert into students values (1,\"Sabriye\", 11, \"Math\");";

        try {
            Statement statement = connection.createStatement();
            statement.execute(sqlCreateCmd);
            System.out.println("Data Inserted Successfully!");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }


        String sqlQueryCommand = "select * from student where grade_level = 11;";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQueryCommand);
            while(resultSet.next()){
                System.out.println(resultSet.getInt("Id") + "\t" +
                        resultSet.getString("student_name") + "\t" +
                        resultSet.getInt("grade_label"));
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}
