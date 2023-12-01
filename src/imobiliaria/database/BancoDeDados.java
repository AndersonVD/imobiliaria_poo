package imobiliaria.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import imobiliaria.Cliente;
import imobiliaria.Foto;
import imobiliaria.Funcionario;
import imobiliaria.Imobiliaria;
import imobiliaria.Imovel;

public class BancoDeDados {

    private List<Cliente> listaClientes = new ArrayList<Cliente>();
    private List<Imovel> listaImoveis = new ArrayList<Imovel>();

    public void cadastrarImovel(Imovel imovel) {
        MySQL bancoDeDados = new MySQL();
        try (var connection = bancoDeDados.getConnection()) {
            var sql = "INSERT INTO imovel (codigo, endereco, tipo, descricao, area, valor, disponivel) VALUES (?, ?, ?, ?, ?, ?, ?)";
            var preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, imovel.getCodigo());
            preparedStatement.setString(2, imovel.getEndereco());
            preparedStatement.setString(3, imovel.getTipo());
            preparedStatement.setString(4, imovel.getDescricao());
            preparedStatement.setDouble(5, imovel.getArea());
            preparedStatement.setDouble(6, imovel.getValor());
            preparedStatement.setBoolean(7, imovel.isDisponivel());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Imobiliaria> listarImobiliarias() {
        MySQL bancoDeDados = new MySQL();
        List<Imobiliaria> listaImobiliarias = new ArrayList<Imobiliaria>();
        try (Connection conn = bancoDeDados.getConnection(); Statement stmt = conn.createStatement()) {
            String sql = "SELECT * FROM imobiliaria";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String cnpj = rs.getString("cnpj");
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");
                String telefone = rs.getString("telefone");
                String email = rs.getString("email");
                Imobiliaria imobiliaria = new Imobiliaria(cnpj, nome, endereco, telefone, email, listaImoveis,
                        listaClientes);
                listaImobiliarias.add(imobiliaria);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listaImobiliarias;
    }

    public void editarImobiliaria(Imobiliaria imobiliaria) {
        MySQL bancoDeDados = new MySQL();
        try (var connection = bancoDeDados.getConnection()) {
            var sql = "UPDATE imobiliaria SET nome = ?, endereco = ?, telefone = ?, email = ? WHERE cnpj = ?";
            var preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, imobiliaria.getNome());
            preparedStatement.setString(2, imobiliaria.getEndereco());
            preparedStatement.setString(3, imobiliaria.getTelefone());
            preparedStatement.setString(4, imobiliaria.getEmail());
            preparedStatement.setString(5, imobiliaria.getCnpj());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void removerImovel(String codigo) {
        MySQL bancoDeDados = new MySQL();
        try (Connection conn = bancoDeDados.getConnection(); Statement stmt = conn.createStatement()) {
            String sql = "DELETE FROM imovel WHERE codigo = '" + codigo + "'";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void cadastrarCliente(Cliente cliente) {
        MySQL bancoDeDados = new MySQL();
        try (Connection conn = bancoDeDados.getConnection(); Statement stmt = conn.createStatement()) {
            String sql = "INSERT INTO cliente (nome, endereco, telefone, email, cpf) VALUES ('"
                    + cliente.getNome() + "', '" + cliente.getEndereco() + "', '"
                    + cliente.getTelefone() + "', '" + cliente.getEmail() + "', '" + cliente.getCpf() + "')";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void removerCliente(String cpf) {
        MySQL bancoDeDados = new MySQL();
        try (Connection conn = bancoDeDados.getConnection(); Statement stmt = conn.createStatement()) {
            String sql = "DELETE FROM cliente WHERE cpf = '" + cpf + "'";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void editarImovel(Imovel imovel) {
        MySQL bancoDeDados = new MySQL();
        try (Connection conn = bancoDeDados.getConnection(); Statement stmt = conn.createStatement()) {
            String sql = "UPDATE imovel SET endereco = '" + imovel.getEndereco() + "', tipo = '" + imovel.getTipo()
                    + "', descricao = '" + imovel.getDescricao() + "', area = '" + imovel.getArea() + "', valor = '"
                    + imovel.getValor() + "', disponivel = '" + imovel.isDisponivel() + "' WHERE codigo = '"
                    + imovel.getCodigo() + "'";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void editarCliente(Cliente cliente) {
        MySQL bancoDeDados = new MySQL();
        try (Connection conn = bancoDeDados.getConnection(); Statement stmt = conn.createStatement()) {
            String sql = "UPDATE cliente SET nome = '" + cliente.getNome() + "', endereco = '" + cliente.getEndereco()
                    + "', telefone = '" + cliente.getTelefone() + "', email = '" + cliente.getEmail() + "', cpf = '"
                    + cliente.getCpf() + "' WHERE cpf = '" + cliente.getCpf() + "'";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Cliente> listarClientes() {
        MySQL bancoDeDados = new MySQL();
        try (Connection conn = bancoDeDados.getConnection(); Statement stmt = conn.createStatement()) {
            String sql = "SELECT * FROM cliente";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String cpf = rs.getString("cpf");
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");
                String telefone = rs.getString("telefone");
                String email = rs.getString("email");
                Cliente cliente = new Cliente(cpf, nome, endereco, telefone, email, null);
                listaClientes.add(cliente);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listaClientes;
    }

    public List<Imovel> listarImoveis() {
        MySQL bancoDeDados = new MySQL();
        try (Connection conn = bancoDeDados.getConnection(); Statement stmt = conn.createStatement()) {
            String sql = "SELECT * FROM imovel";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String codigo = rs.getString("codigo");
                String endereco = rs.getString("endereco");
                String tipo = rs.getString("tipo");
                String descricao = rs.getString("descricao");
                double area = rs.getDouble("area");
                double valor = rs.getDouble("valor");
                boolean disponivel = rs.getBoolean("disponivel");
                // Foto foto = new Foto(codigo, descricao, descricao);
                List<Foto> listaFotos = new ArrayList<Foto>();
                Imovel imovel = new Imovel(codigo, endereco, tipo, descricao, area, valor, disponivel, listaFotos);
                listaImoveis.add(imovel);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listaImoveis;
    }

    public Imovel buscarImovel(String codigo) {
        MySQL bancoDeDados = new MySQL();
        Imovel imovel = null;
        try (Connection conn = bancoDeDados.getConnection(); Statement stmt = conn.createStatement()) {
            String sql = "SELECT * FROM imovel WHERE codigo = '" + codigo + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String endereco = rs.getString("endereco");
                String tipo = rs.getString("tipo");
                String descricao = rs.getString("descricao");
                double area = rs.getDouble("area");
                double valor = rs.getDouble("valor");
                boolean disponivel = rs.getBoolean("disponivel");
                // Foto foto = new Foto(codigo, descricao, descricao);
                List<Foto> listaFotos = new ArrayList<Foto>();
                imovel = new Imovel(codigo, endereco, tipo, descricao, area, valor, disponivel, listaFotos);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return imovel;
    }

    public Cliente buscarCliente(String cpf) {
        MySQL bancoDeDados = new MySQL();
        Cliente cliente = null;
        try (Connection conn = bancoDeDados.getConnection(); Statement stmt = conn.createStatement()) {
            String sql = "SELECT * FROM cliente WHERE cpf = '" + cpf + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");
                String telefone = rs.getString("telefone");
                String email = rs.getString("email");
                cliente = new Cliente(cpf, nome, endereco, telefone, email, listaImoveis);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cliente;
    }

    public void cadastrarFuncionario(Funcionario funcionario) {
        MySQL bancoDeDados = new MySQL();
        try (var connection = bancoDeDados.getConnection()) {
            var sql = "INSERT INTO funcionario (cpf, nome, endereco, telefone, email) VALUES (?, ?, ?, ?, ?)";
            var preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, funcionario.getCpf());
            preparedStatement.setString(2, funcionario.getNome());
            preparedStatement.setString(3, funcionario.getEndereco());
            preparedStatement.setString(4, funcionario.getTelefone());
            preparedStatement.setString(5, funcionario.getEmail());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void cadastrarImobiliaria(Imobiliaria imobiliaria) {
        MySQL bancoDeDados = new MySQL();
        try (var connection = bancoDeDados.getConnection()) {
            var sql = "INSERT INTO imobiliaria (cnpj, nome, endereco, telefone, email) VALUES (?, ?, ?, ?, ?)";
            var preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, imobiliaria.getCnpj());
            preparedStatement.setString(2, imobiliaria.getNome());
            preparedStatement.setString(3, imobiliaria.getEndereco());
            preparedStatement.setString(4, imobiliaria.getTelefone());
            preparedStatement.setString(5, imobiliaria.getEmail());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void removerImobiliaria(String cnpj) {
        MySQL bancoDeDados = new MySQL();
        try (Connection conn = bancoDeDados.getConnection(); Statement stmt = conn.createStatement()) {
            String sql = "DELETE FROM imobiliaria WHERE cnpj = '" + cnpj + "'";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void removerFuncionario(String cpf) {
        MySQL bancoDeDados = new MySQL();
        try (Connection conn = bancoDeDados.getConnection(); Statement stmt = conn.createStatement()) {
            String sql = "DELETE FROM funcionario WHERE cpf = '" + cpf + "'";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Funcionario> listarFuncionarios() {
        MySQL bancoDeDados = new MySQL();
        List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
        try (Connection conn = bancoDeDados.getConnection(); Statement stmt = conn.createStatement()) {
            String sql = "SELECT * FROM funcionario";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String cpf = rs.getString("cpf");
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");
                String telefone = rs.getString("telefone");
                String email = rs.getString("email");
                Funcionario funcionario = new Funcionario(cpf, nome, endereco, telefone, email, email);
                listaFuncionarios.add(funcionario);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listaFuncionarios;
    }

    public void editarFuncionario(Funcionario funcionario) {
        MySQL bancoDeDados = new MySQL();
        try (Connection conn = bancoDeDados.getConnection(); Statement stmt = conn.createStatement()) {
            String sql = "UPDATE funcionario SET nome = '" + funcionario.getNome() + "', endereco = '"
                    + funcionario.getEndereco() + "', telefone = '" + funcionario.getTelefone() + "', email = '"
                    + funcionario.getEmail() + "' WHERE cpf = '" + funcionario.getCpf() + "'";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}