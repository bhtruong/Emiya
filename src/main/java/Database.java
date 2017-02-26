import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by brian on 2/12/17.
 */
abstract class Database {
    abstract Connection getConnection() throws SQLException;
}
