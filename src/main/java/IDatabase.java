import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by brian on 2/12/17.
 */
interface IDatabase {
    Connection getConnection() throws SQLException;
}
