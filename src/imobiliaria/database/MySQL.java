package imobiliaria.database;

import java.sql.*;

public class MySQL {

    // Conexão com o banco de dados MySQL
    private static final String URL = "jdbc:mysql://localhost:3306/imobiliaria";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    // Consultas SQL

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
