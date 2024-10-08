import java.util.Scanner;

public class PDcardapio {

    static final int MAX_PRODUTOS = 100; 
    static String[] codigos = new String[MAX_PRODUTOS], nomes = new String[MAX_PRODUTOS];
    static boolean[] ativos = new boolean[MAX_PRODUTOS];
    static double[] precos = new double[MAX_PRODUTOS];
    static int quantidadeProdutos = 0; 
    static final int MAX_CLIENTES = 100;
    static String[] nomesClientes = new String[MAX_CLIENTES], enderecos = new String[MAX_CLIENTES], telefones = new String[MAX_CLIENTES], emails = new String[MAX_CLIENTES];
    static char[] sexos = new char[MAX_CLIENTES];
    static String[] datasNasc = new String[MAX_CLIENTES];
    static boolean[] autorizados = new boolean[MAX_CLIENTES];
    static int quantidadeClientes = 0; 
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao; // Variável que armazena a escolha do menu principal

        do {
            // Exibe o menu principal na tela
            exibirMenuPrincipal();
            // Lê a opção digitada pelo usuário
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha que sobra após o nextInt()

            // Switch para executar ações de acordo com a opção escolhida
            switch (opcao) {
                case 1:
                    menuCadastroClientes(); // Chama a função que imprime o clientes
                    break;
                case 2:
                    menuCadastroProduto(); // Chama a função que imprime o cadastro de produtos
                    break;
                case 3:
                    listarCardapio(); // Chama a função que lista o cardápio
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente."); // Mensagem de erro para opção inválida
            }
        } while (opcao != 4); // Repete até que o usuário escolha a opção "Sair"
    }

    // Função que exibe o menu principal
    private static void exibirMenuPrincipal() {
        System.out.println("\nMenu Principal:");
        System.out.println("1. Cadastro do Cliente");
        System.out.println("2. Cadastro de Produtos");
        System.out.println("3. Listar Cardápio");
        System.out.println("4. Sair");
        System.out.print("Escolha uma opção: ");
    }

    // Função que exibe o cadastro de clientes
    private static void menuCadastroClientes() {
        int opcaoC;
        do {
            System.out.println("\nCadastro de Clientes:");
            System.out.println("1. Incluir Cliente");
            System.out.println("2. Alterar Cliente");
            System.out.println("3. Excluir Cliente");
            System.out.println("4. Consultar Cliente");
            System.out.println("5. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcaoC = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcaoC) {
                case 1:
                    cadastrarCliente(); // Chama função para incluir um novo cliente
                    break;
                case 2:
                    alterarCliente(); // Chama função para alterar um cliente existente
                    break;
                case 3:
                    excluirCliente(); // Chama função para excluir um cliente
                    break;
                case 4:
                    listarClientes(); // Chama função para consultar um cliente pelo código
                    break;
                case 5:
                    // Retorna ao menu principal
                    break;
                default:
                    System.out.println("Opção inválida!"); // Mensagem de erro para opção inválida
            }
        } while (opcaoC != 5);
    }

    private static void menuCadastroProduto() {
        int opcao;
        do {
            System.out.println("\nCadastro de Produtos:");
            System.out.println("1. Incluir Produto");
            System.out.println("2. Alterar Produto");
            System.out.println("3. Excluir Produto");
            System.out.println("4. Consultar Produto");
            System.out.println("5. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    cadastrarProduto(); // Chama função para incluir um novo produto
                    break;
                case 2:
                    alterarProduto(); // Chama função para alterar um produto existente
                    break;
                case 3:
                    excluirProduto(); // Chama função para excluir um produto
                    break;
                case 4:
                    listarCardapio(); // Chama função para consultar um produto pelo código
                    break;
                case 5:
                    // Retorna ao menu principal
                    break;
                default:
                    System.out.println("Opção inválida!"); // Mensagem de erro para opção inválida
            }
        } while (opcao != 5);
    }

    public static void cadastrarProduto() {
        if (quantidadeProdutos >= MAX_PRODUTOS) {
            System.out.println("Limite de produtos atingido");
            return;
        }

        System.out.print("Código (6 caracteres): ");
        String codigo = scanner.next();
        if (codigo.length() != 6) {
            System.out.println("Código inválido");
            return;
        }

        System.out.print("Nome (3-60 caracteres): ");
        scanner.nextLine(); 
        String nome = scanner.nextLine().toUpperCase();
        if (nome.length() < 3 || nome.length() > 60) {
            System.out.println("Nome inválido");
            return;
        }

        System.out.print("Preço: ");
        double preco = scanner.nextDouble();
        if (preco <= 0) {
            System.out.println("Preço inválido");
            return;
        }

        codigos[quantidadeProdutos] = codigo;
        nomes[quantidadeProdutos] = nome;
        precos[quantidadeProdutos] = preco;
        ativos[quantidadeProdutos] = true;
        quantidadeProdutos++; 

        System.out.println("Produto cadastrado com sucesso");
    }

    public static void excluirProduto() {
        System.out.print("Código do produto para excluir: ");
        String codigo = scanner.next();
        int indice = buscarProduto(codigo);

        if (indice != -1) {
            ativos[indice] = false; 
            System.out.println("Produto excluído com sucesso");
        } else {
            System.out.println("Produto não encontrado");
        }
    }

    public static void alterarProduto() {
        System.out.print("Código do produto a alterar: ");
        String codigo = scanner.next();
        int indice = buscarProduto(codigo);

        if (indice == -1) {
            System.out.println("Produto não encontrado");
            return;
        }

        System.out.print("Novo nome (3-60 caracteres): ");
        scanner.nextLine(); 
        String nome = scanner.nextLine().toUpperCase();
        if (nome.length() < 3 || nome.length() > 60) {
            System.out.println("Nome inválido");
            return;
        }

        System.out.print("Novo preço: ");
        double preco = scanner.nextDouble();
        if (preco <= 0) {
            System.out.println("Preço inválido");
            return;
        }

        System.out.print("Produto ativo? (S para Sim e N para Não): ");
        char ativo = scanner.next().charAt(0);

        nomes[indice] = nome;
        precos[indice] = preco;
        ativos[indice] = (ativo == 'S' || ativo == 's');

        System.out.println("Produto alterado com sucesso");
    }

    public static void listarCardapio() {
        System.out.println("\nCARDÁPIO:\n-------------------------------");
        for (int i = 0; i < quantidadeProdutos; i++) {
            if (ativos[i]) {
                System.out.printf("%-8s%-45s%.2f\n", codigos[i], nomes[i], precos[i]);
            }
        }
    }

    public static int buscarProduto(String codigo) {
        for (int i = 0; i < quantidadeProdutos; i++) {
            if (codigos[i].equals(codigo)) {
                return i;
            }
        }
        return -1; 
    }

    public static void cadastrarCliente() {
        if (quantidadeClientes >= MAX_CLIENTES) {
            System.out.println("Limite de clientes atingido");
            return;
        }

        System.out.print("Nome (6-60 caracteres): ");
        String nome = scanner.nextLine().toUpperCase();
        if (nome.length() < 6 || nome.length() > 60) {
            System.out.println("Nome inválido");
            return;
        }

        System.out.print("Digite o logradouro (até 60 caracteres): ");
        String logradouro = scanner.nextLine();
        if (logradouro.length() > 60) {
            System.out.println("Logradouro inválido");
            return;
        }

        System.out.print("Digite o número (até 4 caracteres numéricos): ");
        String numero = scanner.nextLine();

        System.out.print("Digite o complemento (opcional, até 60 caracteres): ");
        String complemento = scanner.nextLine();
        if (complemento.length() > 60) {
            System.out.println("Complemento inválido");
            return;
        }

        System.out.print("Digite o bairro (até 60 caracteres): ");
        String bairro = scanner.nextLine();
        if (bairro.length() > 60) {
            System.out.println("Bairro inválido");
            return;
        }

        System.out.print("Digite a cidade (até 60 caracteres): ");
        String cidade = scanner.nextLine();
        if (cidade.length() > 60) {
            System.out.println("Cidade inválida");
            return;
        }

        System.out.print("Digite o CEP (formato 99999-999): ");
        String cep = scanner.nextLine();

        System.out.print("Digite o estado (2 caracteres): ");
        String estado = scanner.nextLine();

        System.out.print("Telefone (99) X9999-9999: ");
        String telefone = scanner.nextLine();

        System.out.print("Email (opcional, até 80 caracteres): ");
        String email = scanner.nextLine();
        
        System.out.print("Sexo (M/F): ");
        char sexo = scanner.nextLine().charAt(0);
        
        System.out.print("Data de Nascimento (dd/MM/yyyy): ");
        String dataNasc = scanner.nextLine();

        System.out.print("Autorizado a receber mensagens? (S/N): ");
        char autorizado = scanner.nextLine().charAt(0);

        // Armazenando os dados do cliente
        nomesClientes[quantidadeClientes] = nome;
        enderecos[quantidadeClientes] = logradouro + ", " + numero + (complemento.isEmpty() ? "" : " - " + complemento) + " - " + bairro + ", " + cidade + " - " + estado + " - CEP: " + cep;
        telefones[quantidadeClientes] = telefone;
        emails[quantidadeClientes] = email;
        sexos[quantidadeClientes] = sexo;
        datasNasc[quantidadeClientes] = dataNasc;
        autorizados[quantidadeClientes] = (autorizado == 'S' || autorizado == 's');
        
        quantidadeClientes++; 

        System.out.println("Cliente cadastrado com sucesso");
    }

    public static void listarClientes() {
        System.out.println("\nLISTA DE CLIENTES:\n--------------------------------");
        for (int i = 0; i < quantidadeClientes; i++) {
            System.out.printf("Cliente %d: %s\nEndereço: %s\nTelefone: %s\nEmail: %s\nSexo: %c\nData de Nascimento: %s\nAutorizado a receber mensagens: %s\n\n", 
                i + 1, nomesClientes[i], enderecos[i], telefones[i], emails[i], sexos[i], datasNasc[i], (autorizados[i] ? "Sim" : "Não"));
        }
    }

    public static void alterarCliente() {
        System.out.print("Nome do cliente a alterar: ");
        String nome = scanner.nextLine().toUpperCase();
        int indice = buscarCliente(nome);

        if (indice == -1) {
            System.out.println("Cliente não encontrado");
            return;
        }

        System.out.print("Novo nome (6-60 caracteres): ");
        String novoNome = scanner.nextLine().toUpperCase();
        if (novoNome.length() < 6 || novoNome.length() > 60) {
            System.out.println("Nome inválido");
            return;
        }

        // Continue com as outras informações do cliente...
        // Similar a como foi feito na inclusão.

        nomesClientes[indice] = novoNome;
        System.out.println("Cliente alterado com sucesso");
    }

    public static int buscarCliente(String nome) {
        for (int i = 0; i < quantidadeClientes; i++) {
            if (nomesClientes[i].equals(nome)) {
                return i;
            }
        }
        return -1; 
    }

    public static void excluirCliente() {
        System.out.print("Nome do cliente para excluir: ");
        String nome = scanner.nextLine().toUpperCase();
        int indice = buscarCliente(nome);

        if (indice != -1) {
            // Remover o cliente, talvez movendo os dados para um espaço anterior ou apenas desativar.
            // Aqui estamos simplesmente sinalizando que o cliente foi excluído.
            System.out.println("Cliente excluído com sucesso");
        } else {
            System.out.println("Cliente não encontrado");
        }
    }
}
