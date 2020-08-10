package dev.symoh.Database;

import java.sql.*;

public class databaseConnection implements databaseConnectionInterface {
    private String username;
    private String password;
    private String url;
    private Connection connection;

    public databaseConnection() throws SQLException, ClassNotFoundException {
        this.url="jdbc:mysql://localhost:3306/mySchool";
        this.username="root";
        this.password="cr!pt0n";
        this.connect();
    }

    @Override
    public void connect() throws SQLException, ClassNotFoundException {
        this.connection=this.getConnection();

    }

    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        //register driver
        Class.forName("com.mysql.jdbc.Driver");
        //get connection
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
