# Escopo do Projeto: Serviço de Imobiliária

## Objetivo

Desenvolver um sistema para gerenciamento de imobiliária, permitindo o cadastro e gerenciamento de imóveis, clientes, funcionários e fotos relacionadas aos imóveis. O sistema deve oferecer funcionalidades de CRUD (Create, Read, Update, Delete) para cada uma das entidades mencionadas.

Cliente: representa um cliente da imobiliária. Cada cliente pode ter um ou mais imóveis cadastrados.

Funcionario: representa um funcionário da imobiliária. Cada funcionário pode ter um ou mais imóveis cadastrados.

Imobiliaria: representa a imobiliária. A imobiliária possui uma lista de imóveis e uma lista de clientes.


## Estrutura do Projeto

O projeto será desenvolvido em Java. Abaixo estão listadas as principais classes e suas responsabilidades:

### Classes

#### `Imobiliaria`
- Atributos: nome, endereço, telefone, email, cnpj, listaImoveis, listaClientes.
- Métodos: cadastrarImovel(), cadastrarCliente(), removerImovel(), editarImovel(), listarImoveis(), buscarImovel(), etc.

#### `Imovel`
- Atributos: código, endereço, tipo, valor, área, descrição, disponivel, listaFotos.
- Métodos: cadastrarFoto(), removerFoto(), editarFoto(), listarFotos(), buscarFoto(), etc.

#### `Foto`
- Atributos: código, descrição, imagem.

#### `Cliente`
- Atributos: código, nome, endereço, telefone, email, cpf, listaImoveis.
- Métodos: cadastrarImovel(), removerImovel(), editarImovel(), listarImoveis(), buscarImovel(), etc.

#### `Funcionario`
- Atributos: código, nome, endereço, telefone, email, cpf.
- Métodos: cadastrarImovel(), cadastrarCliente(), removerImovel(), editarImovel(), listarImoveis(), buscarImovel(), etc.

### Banco de Dados

O projeto utilizará um banco de dados MySQL para persistir os dados. Uma conexão será estabelecida via JDBC, e o projeto incluirá scripts SQL para a criação das tabelas necessárias.



## Funcionalidades
1. Cadastrar Imóvel
2. Cadastrar Cliente
3. Cadastrar Funcionário
4. Cadastrar Foto
5. Remover Imóvel
6. Remover Cliente
7. Remover Funcionário
8. Remover Foto
9. Editar Imóvel
10. Editar Cliente
11. Editar Funcionário
12. Editar Foto
13. Listar Imóveis
14. Listar Clientes
15. Listar Funcionários
16. Listar Fotos
17. Buscar Imóvel
18. Buscar Cliente
19. Buscar Funcionário
20. Buscar Foto


## Restrições e Funcionalidades Não Incluídas

- Não será implementado o controle de ações realizadas no sistema (logging).
- Não será incluido a parte de gerenciamento por parte do locatário do imóvel.



## Repositório

https://github.com/AndersonVD/imobiliaria_poo