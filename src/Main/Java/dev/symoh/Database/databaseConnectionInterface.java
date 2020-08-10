package dev.symoh.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface databaseConnectionInterface {

    public void connect() throws SQLException, ClassNotFoundException;
    public Connection getConnection() throws SQLException, ClassNotFoundException;
    public ResultSet executeQuery(PreparedStatement preparedStatement) throws SQLException;
    public Boolean executeUpdate(PreparedStatement preparedStatement) throws SQLException;
    public void close() throws SQLException;

}
