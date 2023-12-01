package imobiliaria;

import java.util.ArrayList;
import java.util.List;

import imobiliaria.database.*;

public class Imobiliaria {
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private String cnpj;
    private List<Imovel> listaImoveis;
    private List<Cliente> listaClientes;
    private List<Funcionario> listaFuncionarios;

    private BancoDeDados bancoDeDados;

    public Imobiliaria(String nome, String endereco, String telefone, String email, String cnpj,
            List<Imovel> listaImoveis, List<Cliente> listaClientes, BancoDeDados bancoDeDados) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.cnpj = cnpj;
        this.listaImoveis = new ArrayList<Imovel>();
        this.listaClientes = listaClientes;
        this.listaFuncionarios = new ArrayList<Funcionario>();
        this.bancoDeDados = bancoDeDados;
    }

    public Imobiliaria(String nome, String endereco, String telefone, String email, String cnpj,
            List<Imovel> listaImoveis, List<Cliente> listaClientes) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.cnpj = cnpj;
        this.listaFuncionarios = new ArrayList<Funcionario>();
        this.listaImoveis = new ArrayList<Imovel>();
        this.listaClientes = listaClientes;
    }

    public void cadastrarFuncionario(Funcionario funcionario) {
        bancoDeDados.cadastrarFuncionario(funcionario);
    }

    public void removerImobiliaria(String cnpj) {
        bancoDeDados.removerImobiliaria(cnpj);
    }

    public void cadastrasImobiliaria(Imobiliaria imobiliaria) {
        bancoDeDados.cadastrarImobiliaria(imobiliaria);
    }

    public List<Imobiliaria> listarImobiliarias() {
        return bancoDeDados.listarImobiliarias();
    }

    public void editarImobiliaria(Imobiliaria imobiliaria) {
        bancoDeDados.editarImobiliaria(imobiliaria);
    }

    public List<Funcionario> listarFuncionarios() {
        return bancoDeDados.listarFuncionarios();
    }

    public void editarFuncionario(Funcionario funcionario) {
        bancoDeDados.editarFuncionario(funcionario);
    }

    public void removerFuncionario(String cpf) {
        bancoDeDados.removerFuncionario(cpf);
    }

    public void cadastrarImovel(Imovel imovel) {
        bancoDeDados.cadastrarImovel(imovel);
    }

    public void cadastrarCliente(Cliente cliente) {
        bancoDeDados.cadastrarCliente(cliente);
    }

    public void removerImovel(String codigo) {
        bancoDeDados.removerImovel(codigo);
    }

    public void removerCliente(String cpf) {
        bancoDeDados.removerCliente(cpf);
    }

    public void editarImovel(Imovel imovel) {
        bancoDeDados.editarImovel(imovel);
    }

    public void editarCliente(Cliente cliente) {
        bancoDeDados.editarCliente(cliente);
    }

    public List<Cliente> listarClientes() {
        return bancoDeDados.listarClientes();
    }

    public List<Imovel> listarImoveis() {
        return bancoDeDados.listarImoveis();
    }

    public Imovel buscarImovel(String codigo) {
        return bancoDeDados.buscarImovel(codigo);
    }

    public Cliente buscarCliente(String cpf) {
        return bancoDeDados.buscarCliente(cpf);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public List<Imovel> getListaImoveis() {
        return listaImoveis;
    }

    public void setListaImoveis(List<Imovel> listaImoveis) {
        this.listaImoveis = listaImoveis;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public BancoDeDados getBancoDeDados() {
        return bancoDeDados;
    }

    public void setBancoDeDados(BancoDeDados bancoDeDados) {
        this.bancoDeDados = bancoDeDados;
    }

    public List<Funcionario> getListaFuncionarios() {
        return listaFuncionarios;
    }

    public void setListaFuncionarios(List<Funcionario> listaFuncionarios) {
        this.listaFuncionarios = listaFuncionarios;
    }
}
