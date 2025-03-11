package br.com.haraujo.persistence.config;


import lombok.NoArgsConstructor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class ConnectionConfig {

    public static Connection getConnection() throws SQLException {
        var url = "jdbc:mysql://localhost:3307/board";
        var user = "root";
        var password = "rootpassword";
        var connection = DriverManager.getConnection(url, user, password);
        connection.setAutoCommit(false);
        return connection;
    }
}
