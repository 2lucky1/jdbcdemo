package org.itstep;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Application {

    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/academy" +
            "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "";

    private static final String CREATE_STUDENT = "DROP TABLE IF EXISTS student;" +
            "CREATE TABLE IF NOT EXISTS student" +
            "(" +
            "   id INT PRIMARY KEY AUTO_INCREMENT," +
            "   first_name VARCHAR(255) NOT NULL," +
            "   last_name VARCHAR(255) NOT NULL," +
            "   age INT," +
            "   email VARCHAR(255) NOT NULL," +
            "   FOREIGN KEY (id_group) REFERENCES group(id)" +
            ");";


    private static final String CREATE_GROUP = "DROP TABLE IF EXISTS `group`;" +
            "(" +
            "   id INT PRIMARY KEY AUTO_INCREMENT," +
            "   name VARCHAR(255) NOT NULL" +
            ");";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(CONNECTION_STRING, USER, PASS)) {
            Statement stmt = conn.createStatement();
            stmt.execute(CREATE_STUDENT);
            System.out.println("Connected");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
