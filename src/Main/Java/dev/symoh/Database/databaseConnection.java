package dev.symoh.Database;

import java.sql.*;

public class databaseConnection implements databaseConnectionInterface {
    private String username;
    private String password;
    private String url;
    private Connection connection;

    public databaseConnection() throws SQLException {
        this.url="";
        this.username="";
        this.password="";
        this.connect();
    }

    @Override
    public void connect() throws SQLException {
        this.connection=this.getConnection();

    }

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }

    @Override
    public ResultSet executeQuery(PreparedStatement preparedStatement) throws SQLException {
        return preparedStatement.executeQuery();
    }

    @Override
    public Boolean executeUpdate(PreparedStatement preparedStatement) throws SQLException {
        /*int n;
        n=preparedStatement.executeUpdate();
        if(n>0){
          return true;
        }else {
            return false;
        }*/
        return preparedStatement.execute();
    }

    @Override
    public void close() throws SQLException {
        this.connection.close();
    }
}
