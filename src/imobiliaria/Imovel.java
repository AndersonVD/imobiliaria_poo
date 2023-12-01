package imobiliaria;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import imobiliaria.database.BancoDeDados;
import imobiliaria.database.MySQL;

public class Imovel {
    private String codigo;
    private String endereco;
    private String tipo;
    private String descricao;
    private double area;
    private double valor;
    private boolean disponivel;
    private List<Foto> listaFotos;
    private BancoDeDados bancoDeDados;

    public BancoDeDados getBancoDeDados() {
        return bancoDeDados;
    }

    public void setBancoDeDados(BancoDeDados bancoDeDados) {
        this.bancoDeDados = bancoDeDados;
    }

    public Imovel(String codigo, String endereco, String tipo, String descricao, double area, double valor,
            boolean disponivel, List<Foto> listaFotos) {
        this.codigo = codigo;
        this.endereco = endereco;
        this.tipo = tipo;
        this.descricao = descricao;
        this.area = area;
        this.valor = valor;
        this.disponivel = disponivel;
        this.listaFotos = listaFotos;
    }

    public Imovel(String codigo, String endereco, String tipo, String descricao, double area, double valor,
            boolean disponivel, List<Foto> listaFotos, BancoDeDados bancoDeDados) {
        this.codigo = codigo;
        this.endereco = endereco;
        this.tipo = tipo;
        this.descricao = descricao;
        this.area = area;
        this.valor = valor;
        this.disponivel = disponivel;
        this.listaFotos = listaFotos;
        this.bancoDeDados = bancoDeDados;
    }

    // Métodos
    public void cadastrarFoto() {
        MySQL bancoDeDados = new MySQL();
        try (Connection conn = bancoDeDados.getConnection(); Statement stmt = conn.createStatement()) {
            String sql = "INSERT INTO foto (codigo, endereco, tipo, descricao, area, valor, disponivel) VALUES ('"
                    + codigo + "', '" + endereco + "', '" + tipo + "', '" + descricao + "', '" + area + "', '" + valor
                    + "', '" + disponivel + "')";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void removerFoto() {
        MySQL bancoDeDados = new MySQL();
        try (Connection conn = bancoDeDados.getConnection(); Statement stmt = conn.createStatement()) {
            String sql = "DELETE FROM foto WHERE codigo = '" + codigo + "'";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void editarFoto() {
        MySQL bancoDeDados = new MySQL();
        try (Connection conn = bancoDeDados.getConnection(); Statement stmt = conn.createStatement()) {
            String sql = "UPDATE foto SET endereco = '" + endereco + "', tipo = '" + tipo + "', descricao = '"
                    + descricao + "', area = '" + area + "', valor = '" + valor + "', disponivel = '" + disponivel
                    + "' WHERE codigo = '" + codigo + "'";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void listarFotos() {
        MySQL bancoDeDados = new MySQL();
        try (Connection conn = bancoDeDados.getConnection(); Statement stmt = conn.createStatement()) {
            String sql = "SELECT * FROM foto";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public Foto buscarFoto() {
        MySQL bancoDeDados = new MySQL();
        try (Connection conn = bancoDeDados.getConnection(); Statement stmt = conn.createStatement()) {
            String sql = "SELECT * FROM foto WHERE codigo = '" + codigo + "'";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public List<Foto> getListaFotos() {
        return listaFotos;
    }

    public void setListaFotos(List<Foto> listaFotos) {
        this.listaFotos = listaFotos;
    }

    @Override
    public String toString() {
        return "Imovel [codigo=" + codigo + ", endereco=" + endereco + ", tipo=" + tipo + ", descricao=" + descricao
                + ", area=" + area + ", valor=" + valor + ", disponivel=" + disponivel + ", listaFotos=" + listaFotos
                + "]";
    }

}
