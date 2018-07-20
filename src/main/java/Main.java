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

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println(id+" "+username+" "+password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
