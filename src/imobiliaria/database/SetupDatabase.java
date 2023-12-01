package imobiliaria.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SetupDatabase {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/imobiliaria";
        String user = "root";
        String password = "root";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            if (conn == null) {
                System.out.println("Falha ao conectar ao banco de dados.");
                return;
            }

            // Tabelas e seus respectivos comandos SQL de criação
            String[] tabelas = {
                    "CREATE TABLE IF NOT EXISTS Imobiliaria (cnpj VARCHAR(20) PRIMARY KEY, nome VARCHAR(100), endereco VARCHAR(200), telefone VARCHAR(20), email VARCHAR(100))",
                    "CREATE TABLE IF NOT EXISTS Imovel (codigo VARCHAR(20) PRIMARY KEY, endereco VARCHAR(200), tipo VARCHAR(50), valor DOUBLE, area DOUBLE, descricao TEXT, disponivel VARCHAR(20), cnpjImobiliaria VARCHAR(20), FOREIGN KEY (cnpjImobiliaria) REFERENCES Imobiliaria(cnpj))",
                    "CREATE TABLE IF NOT EXISTS Foto (codigo VARCHAR(20) PRIMARY KEY, descricao VARCHAR(200), imagem TEXT, codigoImovel VARCHAR(20), FOREIGN KEY (codigoImovel) REFERENCES Imovel(codigo))",
                    "CREATE TABLE IF NOT EXISTS Cliente (cpf VARCHAR(20) PRIMARY KEY, nome VARCHAR(100), endereco VARCHAR(200), telefone VARCHAR(20), email VARCHAR(100))",
                    "CREATE TABLE IF NOT EXISTS Funcionario (cpf VARCHAR(20) PRIMARY KEY, nome VARCHAR(100), endereco VARCHAR(200), telefone VARCHAR(20), email VARCHAR(100))"
            };

            try (Statement stmt = conn.createStatement()) {
                for (String sql : tabelas) {
                    stmt.execute(sql);
                }
                System.out.println("Configuração do banco de dados concluída com sucesso.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao configurar o banco de dados: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
