package emiya;

import javax.inject.Inject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by brian on 2/12/17.
 */
class MySqlDatabase implements Database {
    private DatabaseCredentials credentials;

    @Inject
    MySqlDatabase(DatabaseCredentials databaseCredentials) {
        this.credentials = databaseCredentials;
    }

    public Connection getConnection() throws SQLException {
        String url = credentials.url;
        String user = credentials.user;
        String password = credentials.password;

        return DriverManager.getConnection(url, user, password);
    }
}
