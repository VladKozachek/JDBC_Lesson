package main.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectJDBC {
    private String URL ="jdbc:mysql://localhost:3306/mydbtest?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private String USERNAME ="root";
    private String PASSWORD ="root";
    private String CLASSFORNAME ="com.mysql.cj.jdbc.Driver"; //можно найти в интернете, для SQL будет такая  ссылка
    private Connection connection;

    public ConnectJDBC() {
        try {
            Class.forName(CLASSFORNAME);
            connection= DriverManager.getConnection(URL,USERNAME,PASSWORD);
            System.out.println("Подключение успешно установлено!");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Connection getConnection() {
        return connection;
    }
}
