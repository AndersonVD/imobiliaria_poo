package imobiliaria;

import java.util.List;

import imobiliaria.database.BancoDeDados;

public class Funcionario {
    private String codigo;
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private String cpf;
    private BancoDeDados bancoDeDados;

    public Funcionario(String codigo, String nome, String endereco, String telefone, String email, String cpf,
            BancoDeDados bancoDeDados) {
        this.codigo = codigo;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
        this.bancoDeDados = bancoDeDados;
    }

    public Funcionario(String codigo, String nome, String endereco, String telefone, String email, String cpf) {
        this.codigo = codigo;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
    }

    // Métodos
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

    public List<Imovel> listarImoveis() {
        return bancoDeDados.listarImoveis();
    }

    public List<Cliente> listarClientes() {
        return bancoDeDados.listarClientes();
    }

    public Imovel buscarImovel(String codigo) {
        return bancoDeDados.buscarImovel(codigo);
    }

    public Cliente buscarCliente(String cpf) {
        return bancoDeDados.buscarCliente(cpf);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public BancoDeDados getBancoDeDados() {
        return bancoDeDados;
    }

    public void setBancoDeDados(BancoDeDados bancoDeDados) {
        this.bancoDeDados = bancoDeDados;
    }

}
