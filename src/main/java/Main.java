import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        ConnectJDBC connectionJDBC=new ConnectJDBC();

        String quwery="select * from users";
        try {
            Statement statement = connectionJDBC.getConnection().createStatement();
            ResultSet resultSet=statement.executeQuery(quwery);
            int id;
            while (resultSet.next()){
                id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println(id+" "+username+" "+password);
            }
            resultSet.close();
            statement.close();
            connectionJDBC.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
