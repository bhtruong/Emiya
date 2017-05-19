package emiya;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by brian on 2/12/17.
 */
class MySqlDatabase implements Database {

    public Connection getConnection() throws SQLException {
        String url = MySqlConfig.url;
        String user = MySqlConfig.user;
        String password = MySqlConfig.password;

        return DriverManager.getConnection(url, user, password);
    }
}
