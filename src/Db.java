import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Db {

    protected Connection _conn;

    protected Db CreateConnection() throws SQLException
    {
        Properties properties = new Properties();
        properties.setProperty("user", "java");
        properties.setProperty("password", "password");
        properties.setProperty("useSSL", "false");
        properties.setProperty("autoReconnect", "true");

        this._conn = DriverManager.getConnection("jdbc:mysql://localhost/events", properties);
        return this;
    }

    protected void CloseConnection() throws SQLException
    {
        this._conn.close();
    }
}
