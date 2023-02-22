package mshantadze.solvd_laba_university.dao.connectionpool;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.LinkedList;

public class ConnectionPool implements IConnectionPool {
    // private static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);

    // setting up credentials for connecting to the database
    private static Properties props = new Properties();
    private static String url;
    private static String userName;
    private static String password;


    // setting up lists for holding connections
    private static final int MAX_POOL_SIZE = 20;
    private static List<Connection> connectionPool = new LinkedList<>();
    private static List<Connection> usedConnections = new LinkedList<>();
    private static ConnectionPool poolInstance = null;
    
    // constructor
    private ConnectionPool() {
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	
            FileInputStream propFilePath = new FileInputStream("src/main/resources/mysql.properties");
            props.load(propFilePath);

            url = props.getProperty("url");
            userName = props.getProperty("userName");
            password = props.getProperty("password");

            for (int i = 0; i < MAX_POOL_SIZE; i++) {
                connectionPool.add(createConnection());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
        	System.out.println(e.getMessage());
		}
    }
    
    // function for getting or creating pool instance
    public static ConnectionPool startPool() {
    	return poolInstance == null ? new ConnectionPool() : poolInstance;
    }

    // function for getting a connection
    public Connection getConnection() {
        Connection connection = connectionPool.remove(connectionPool.size() - 1);
        usedConnections.add(connection);
        return connection;
    }

    // function for releasing a connection
    public static boolean releaseConnection(Connection connection) {
        connectionPool.add(connection);
        return usedConnections.remove(connection);
    }

        
    // function for creating new connections
    private static Connection createConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, userName, password);
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }

        return connection;
    }
}
