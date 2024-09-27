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
        while (true) {
            System.out.print("\nMENU:\n1. Cadastro de Produtos\n2. Excluir Produto\n3. Alterar Produto\n4. Listar Cardápio\n5. Cadastro de Clientes\n6. Excluir Cliente\n7. Alterar Cliente\n8. Listar Clientes\n9. Sair\nEscolha: ");
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    excluirProduto();
                    break;
                case 3:
                    alterarProduto();
                    break;
                case 4:
                    listarCardapio();
                    break;
                case 5:
                    cadastrarCliente();
                    break;
                case 6:
                    excluirCliente();
                    break;
                case 7:
                    alterarCliente();
                    break;
                case 8:
                    listarClientes();
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
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
        scanner.nextLine(); 
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
        String telefone = scanner.next();

        System.out.print("Email (opcional, até 80 caracteres): ");
        String email = scanner.next();
        
        System.out.print("Sexo (M/F): ");
        char sexo = scanner.next().charAt(0);
        
        System.out.print("Data de Nascimento (dd/mm/aaaa): ");
        String dataNasc = scanner.next();

        System.out.print("Autorizado a receber mensagens? (S/N): ");
        char autorizado = scanner.next().charAt(0);

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

    public static void excluirCliente() {
        System.out.print("Nome do cliente para excluir: ");
        scanner.nextLine(); 
        String nome = scanner.nextLine().toUpperCase();
        int indice = buscarCliente(nome);

        if (indice != -1) {
            for (int i = indice; i < quantidadeClientes - 1; i++) {
                nomesClientes[i] = nomesClientes[i + 1];
                enderecos[i] = enderecos[i + 1];
                telefones[i] = telefones[i + 1];
                emails[i] = emails[i + 1];
                sexos[i] = sexos[i + 1];
                datasNasc[i] = datasNasc[i + 1];
                autorizados[i] = autorizados[i + 1];
            }
            quantidadeClientes--;
            System.out.println("Cliente excluído com sucesso");
        } else {
            System.out.println("Cliente não encontrado");
        }
    }

    public static void alterarCliente() {
        System.out.print("Nome do cliente a alterar: ");
        scanner.nextLine(); 
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

        System.out.print("Novo logradouro (até 60 caracteres): ");
        String novoLogradouro = scanner.nextLine();
        if (novoLogradouro.length() > 60) {
            System.out.println("Logradouro inválido");
            return;
        }

        System.out.print("Novo número (até 4 caracteres numéricos): ");
        String novoNumero = scanner.nextLine();

        System.out.print("Novo complemento (opcional, até 60 caracteres): ");
        String novoComplemento = scanner.nextLine();
        if (novoComplemento.length() > 60) {
            System.out.println("Complemento inválido");
            return;
        }

        System.out.print("Novo bairro (até 60 caracteres): ");
        String novoBairro = scanner.nextLine();
        if (novoBairro.length() > 60) {
            System.out.println("Bairro inválido");
            return;
        }

        System.out.print("Nova cidade (até 60 caracteres): ");
        String novaCidade = scanner.nextLine();
        if (novaCidade.length() > 60) {
            System.out.println("Cidade inválida");
            return;
        }

        System.out.print("Novo CEP (formato 99999-999): ");
        String novoCep = scanner.nextLine();


        System.out.print("Novo estado (2 caracteres): ");
        String novoEstado = scanner.nextLine();

        System.out.print("Novo telefone (99) X9999-9999: ");
        String novoTelefone = scanner.next();

        System.out.print("Novo email (opcional, até 80 caracteres): ");
        String novoEmail = scanner.next();
        
        System.out.print("Novo sexo (M/F): ");
        char novoSexo = scanner.next().charAt(0);
        
        System.out.print("Nova data de Nascimento (dd/mm/aaaa): ");
        String novaDataNasc = scanner.next(); 

        System.out.print("Autorizado a receber mensagens? (S/N): ");
        char novoAutorizado = scanner.next().charAt(0);

        nomesClientes[indice] = novoNome;
        enderecos[indice] = novoLogradouro + ", " + novoNumero + (novoComplemento.isEmpty() ? "" : " - " + novoComplemento) + " - " + novoBairro + ", " + novaCidade + " - " + novoEstado + " - CEP: " + novoCep;
        telefones[indice] = novoTelefone;
        emails[indice] = novoEmail;
        sexos[indice] = novoSexo;
        datasNasc[indice] = novaDataNasc;
        autorizados[indice] = (novoAutorizado == 'S' || novoAutorizado == 's');

        System.out.println("Cliente alterado com sucesso");
    }

    public static void listarClientes() {
        System.out.println("\nCLIENTES:\n-------------------------------");
        for (int i = 0; i < quantidadeClientes; i++) {
            System.out.printf("Nome: %s, Telefone: %s, Email: %s, Endereço: %s, Data de Nascimento: %s, Autorizado: %s\n", 
                nomesClientes[i], telefones[i], emails[i], enderecos[i], datasNasc[i], autorizados[i] ? "Sim" : "Não");
        }
    }

    public static int buscarCliente(String nome) {
        for (int i = 0; i < quantidadeClientes; i++) {
            if (nomesClientes[i].equals(nome)) {
                return i;
            }
        }
        return -1; 
    }
}
