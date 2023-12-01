package imobiliaria;

import imobiliaria.database.BancoDeDados;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Inicializando o Banco de Dados
        BancoDeDados bancoDeDados = new BancoDeDados();

        // Criando instâncias das classes
        Imobiliaria imobiliaria = new Imobiliaria("Imobiliaria XYZ", "Rua Principal, 123", "1122334455",
                "contato@imobiliariaxyz.com", "1234567890001", null, null, bancoDeDados);
        Cliente cliente = new Cliente("Carlos Silva", "Rua Secundária, 456", "5566778899", "carlos.silva@email.com",
                "98765432100", new ArrayList<>(), bancoDeDados);
        Funcionario funcionario = new Funcionario("Func01", "Ana Santos", "Rua do Trabalho, 789", "9988776655",
                "ana.santos@imobiliariaxyz.com", "12345678901", bancoDeDados);
        Imovel imovel = new Imovel("Imov01", "Rua Principal, 123", "Casa", "Casa com 3 quartos, 2 banheiros e 1 vaga",
                100.00, 300000.00, true, new ArrayList<Foto>(), bancoDeDados);

        // Testando as funcionalidades da Imobiliaria
        System.out.println("Testando funcionalidades da Imobiliaria:");
        imobiliaria.cadastrasImobiliaria(imobiliaria);
        System.out.println("Imobiliárias cadastradas: " + imobiliaria.listarImobiliarias()); // Listar
        imobiliaria.setNome("Imobiliaria ABC"); // Editar
        imobiliaria.editarImobiliaria(imobiliaria); // Editar
        // imobiliaria.removerImobiliaria(imobiliaria.getCnpj()); // Remover
        // System.out.println("Imobiliárias após remoção: " +
        // imobiliaria.listarImobiliarias()); // Listar após remoção

        // Testando as funcionalidades do Imovel
        System.out.println("Testando funcionalidades do Imovel:");
        funcionario.cadastrarImovel(imovel); // Cadastrar
        System.out.println("Imóveis cadastrados: " + imobiliaria.listarImoveis()); // Listar
        imovel.setValor(350000.00); // Editar
        funcionario.editarImovel(imovel); // Editar
        // funcionario.removerImovel(imovel.getCodigo()); // Remover
        // System.out.println("Imóveis após remoção: " + imobiliaria.listarImoveis());
        // // Listar após remoção

        // Testando as funcionalidades do Cliente
        System.out.println("\nTestando funcionalidades do Cliente:");
        imobiliaria.cadastrarCliente(cliente); // Cadastrar
        System.out.println("Clientes cadastrados: " + imobiliaria.listarClientes()); // Listar
        cliente.setNome("Carlos Silva Junior"); // Editar
        imobiliaria.editarCliente(cliente); // Editar
        // imobiliaria.removerCliente(cliente.getCpf()); // Remover
        // System.out.println("Clientes após remoção: " + imobiliaria.listarClientes());
        // // Listar após remoção

        // Testando as funcionalidades do Funcionario
        System.out.println("\nTestando funcionalidades do Funcionario:");
        imobiliaria.cadastrarFuncionario(funcionario); // Cadastrar
        System.out.println("Funcionários cadastrados: " + imobiliaria.listarFuncionarios()); // Listar
        funcionario.setNome("Carlos Albertinho"); // Editar
        imobiliaria.editarFuncionario(funcionario); // Editar
        // imobiliaria.removerFuncionario(funcionario.getCpf()); // Remover
        // System.out.println("Funcionários após remoção: " +
        // imobiliaria.listarFuncionarios()); // Listar após remoção

    }
}
