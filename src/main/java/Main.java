
import main.java.ConnectJDBC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        ConnectJDBC connectionJDBC=new ConnectJDBC();


        String queryCreatingTable="CREATE TABLE if not exists users (id int PRIMARY KEY NOT NULL AUTO_INCREMENT,username VARCHAR(64) NOT NULL, password varchar(50) NOT NULL)";
        String queryInsert="insert into users (username, password ) values (?, ?)";
        String query="select * from users";
        try {
/*
            //Выполнение запростов с помощью Statement
            Statement statement = connectionJDBC.getConnection().createStatement();
              statement.executeUpdate(queryCreatingTable);
              statement.executeUpdate(queryInsert);
            ResultSet resultSet=statement.executeQuery(query);
            while (resultSet.next()){    //полученный результат записываем в класс User
                User user=new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                System.out.println(user);
            }*/


            // Выполнение запростов с помощью PreparedStatement
            PreparedStatement preparedInsert=connectionJDBC.getConnection().prepareStatement(queryInsert);
            preparedInsert.setString(1,"VLena");
            preparedInsert.setString(2,"122");
            preparedInsert.executeUpdate();

            PreparedStatement preparedStatement=connectionJDBC.getConnection().prepareStatement(query);
            ResultSet resultSet=preparedStatement.executeQuery(query);  //получаем даные с базы
            while (resultSet.next()){    //полученный результат записываем в класс User
                User user=new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                System.out.println(user);
            }
            resultSet.close();
            preparedStatement.close();
            connectionJDBC.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
