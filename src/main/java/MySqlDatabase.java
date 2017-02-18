import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by brian on 2/12/17.
 */
class MySqlDatabase implements IDatabase {

    public Connection getConnection() throws SQLException {
        String url = MySqlConfig.URL;
        String user = MySqlConfig.User;
        String password = MySqlConfig.Password;

        return DriverManager.getConnection(url, user, password);
    }
}
