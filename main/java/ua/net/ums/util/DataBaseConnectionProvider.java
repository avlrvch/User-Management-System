package ua.net.ums.util;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

@Startup
@Singleton
public class DataBaseConnectionProvider {

    private Connection connection;
    private static final String URL = "jdbc:mysql://localhost:3306/pms";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    @PostConstruct
    public void doInit(){
        Driver driver = null;
        try {
            driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            System.out.println("Can't connect to DB");
        }
    }

    @PreDestroy
    public void doExit(){
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Can't close DB connection");
            }
        }

    }
}
