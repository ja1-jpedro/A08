import java.util.Scanner;

public class PDcardapio {

    static final int MAX_PRODUTOS = 100; 
    static String[] codigos = new String[MAX_PRODUTOS], nomes = new String[MAX_PRODUTOS];
    static boolean[] ativos = new boolean[MAX_PRODUTOS];
    static double[] precos = new double[MAX_PRODUTOS];
    static int quantidadeProdutos = 0; 
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.print("\nMENU:\n1. Cadastro\n2. Excluir\n3. Alterar\n4. Cardápio\n5. Sair\nEscolha: ");
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
            System.out.println("Limite de produtos atingido!");
            return;
        }

        System.out.print("Código (6 caracteres): ");
        String codigo = scanner.next();
        if (codigo.length() != 6) {
            System.out.println("Código inválido!");
            return;
        }

        System.out.print("Nome (3-60 caracteres): ");
        scanner.nextLine(); 
        String nome = scanner.nextLine().toUpperCase();
        if (nome.length() < 3 || nome.length() > 60) {
            System.out.println("Nome inválido!");
            return;
        }

        System.out.print("Preço: ");
        double preco = scanner.nextDouble();
        if (preco <= 0) {
            System.out.println("Preço inválido!");
            return;
        }

        codigos[quantidadeProdutos] = codigo;
        nomes[quantidadeProdutos] = nome;
        precos[quantidadeProdutos] = preco;
        ativos[quantidadeProdutos] = true;
        quantidadeProdutos++; 

        System.out.println("Produto cadastrado com sucesso!");
    }

    public static void excluirProduto() {
        System.out.print("Código do produto a excluir: ");
        String codigo = scanner.next();
        int indice = buscarProduto(codigo);

        if (indice != -1) {
            ativos[indice] = false; 
            System.out.println("Produto excluído com sucesso!");
        } else {
            System.out.println("Produto não encontrado!");
        }
    }

    public static void alterarProduto() {
        System.out.print("Código do produto a alterar: ");
        String codigo = scanner.next();
        int indice = buscarProduto(codigo);

        if (indice == -1) {
            System.out.println("Produto não encontrado!");
            return;
        }

        System.out.print("Novo nome (3-60 caracteres): ");
        scanner.nextLine(); 
        String nome = scanner.nextLine().toUpperCase();
        if (nome.length() < 3 || nome.length() > 60) {
            System.out.println("Nome inválido!");
            return;
        }

        System.out.print("Novo preço: ");
        double preco = scanner.nextDouble();
        if (preco <= 0) {
            System.out.println("Preço inválido!");
            return;
        }

        System.out.print("Produto ativo? (S para Sim, N para Não): ");
        char ativo = scanner.next().charAt(0);

        nomes[indice] = nome;
        precos[indice] = preco;
        ativos[indice] = (ativo == 'S' || ativo == 's');

        System.out.println("Produto alterado com sucesso!");
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
}
