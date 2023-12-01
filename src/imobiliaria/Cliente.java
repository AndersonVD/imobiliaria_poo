package imobiliaria;

import java.util.List;

import imobiliaria.database.BancoDeDados;

public class Cliente {
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private String cpf;
    private List<Imovel> listaImoveis;
    private BancoDeDados bancoDeDados;

    public Cliente(String nome, String endereco, String telefone, String email, String cpf, List<Imovel> listaImoveis,
            BancoDeDados bancoDeDados) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
        this.listaImoveis = listaImoveis;
        this.bancoDeDados = bancoDeDados;
    }

    public Cliente(String nome, String endereco, String telefone, String email, String cpf, List<Imovel> listaImoveis) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
        this.listaImoveis = listaImoveis;
    }

    public void cadastrarImovel(Imovel imovel) {
        bancoDeDados.cadastrarImovel(imovel);
    }

    public void removerImovel(String codigo) {
        bancoDeDados.removerImovel(codigo);
    }

    public void editarImovel(Imovel imovel) {
        bancoDeDados.editarImovel(imovel);
    }

    public List<Imovel> listarImoveis() {
        return bancoDeDados.listarImoveis();
    }

    public Imovel buscarImovel(String codigo) {
        return bancoDeDados.buscarImovel(codigo);
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

    public List<Imovel> getListaImoveis() {
        return listaImoveis;
    }

    public void setListaImoveis(List<Imovel> listaImoveis) {
        this.listaImoveis = listaImoveis;
    }

    public BancoDeDados getBancoDeDados() {
        return bancoDeDados;
    }

    public void setBancoDeDados(BancoDeDados bancoDeDados) {
        this.bancoDeDados = bancoDeDados;
    }

    @Override
    public String toString() {
        return "Cliente [nome=" + nome + ", endereco=" + endereco + ", telefone=" + telefone + ", email=" + email
                + ", cpf=" + cpf + ", listaImoveis=" + listaImoveis + "]";
    }

}
