import java.util.Scanner;

public class switchlab {
    public static void main(String[] args) {
        // Declaração de variável
        int opcao;
        try (// Cria objeto para entrada da opção do cardápio
                Scanner leitorOpcao = new Scanner(System.in)) {
            // Apresenta o cardápio
            System.out.println("1 – Pastel de carne \n");
            System.out.println("2 – Coxinha de frango \n");
            System.out.println("3 – Kibe com queijo \n");
            // Entrada da opção do cardápio
            System.out.print("Escolha uma opção: ");
            opcao = leitorOpcao.nextInt();
        }
        // Seleção da opção
        switch (opcao) {
            case 1:
                System.out.println(" Pastel de carne escolhido.");
                break;
            case 2:
                System.out.println(" Coxinha de frango escolhida.");
                break;
            case 3:
                System.out.println(" Kibe com queijo .");
                break;
            default:
                System.out.println("Opção invalida!");
                break;
        }
    }
}
















/* versão 1 cachorro quente
    
    import java.util.ArrayList;
import java.util.Scanner;

public class LojaCachorroQuente {
    static ArrayList<String[]> produtos = new ArrayList<>();
    static ArrayList<String[]> clientes = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("1. Cadastrar Produto");
            System.out.println("2. Alterar Produto");
            System.out.println("3. Excluir Produto");
            System.out.println("4. Visualizar Produtos");
            System.out.println("5. Cadastrar Cliente");
            System.out.println("6. Alterar Cliente");
            System.out.println("7. Excluir Cliente");
            System.out.println("8. Visualizar Clientes");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    alterarProduto();
                    break;
                case 3:
                    excluirProduto();
                    break;
                case 4:
                    visualizarProdutos();
                    break;
                case 5:
                    cadastrarCliente();
                    break;
                case 6:
                    alterarCliente();
                    break;
                case 7:
                    excluirCliente();
                    break;
                case 8:
                    visualizarClientes();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    public static void cadastrarProduto() {
        System.out.print("Código do produto: ");
        String codigo = scanner.nextLine();
        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine();
        produtos.add(new String[]{codigo, nome});
        System.out.println("Produto cadastrado com sucesso!");
    }

    public static void alterarProduto() {
        System.out.print("Código do produto a alterar: ");
        String codigo = scanner.nextLine();
        for (String[] produto : produtos) {
            if (produto[0].equals(codigo)) {
                System.out.print("Novo nome do produto: ");
                produto[1] = scanner.nextLine();
                System.out.println("Produto alterado com sucesso!");
                return;
            }
        }
        System.out.println("Produto não encontrado!");
    }

    public static void excluirProduto() {
        System.out.print("Código do produto a excluir: ");
        String codigo = scanner.nextLine();
        produtos.removeIf(produto -> produto[0].equals(codigo));
        System.out.println("Produto excluído com sucesso!");
    }

    public static void visualizarProdutos() {
        System.out.println("Produtos cadastrados:");
        for (String[] produto : produtos) {
            System.out.println("Código: " + produto[0] + ", Nome: " + produto[1]);
        }
    }

    public static void cadastrarCliente() {
        System.out.print("Código do cliente: ");
        String codigo = scanner.nextLine();
        System.out.print("Nome do cliente: ");
        String nome = scanner.nextLine();
        clientes.add(new String[]{codigo, nome});
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public static void alterarCliente() {
        System.out.print("Código do cliente a alterar: ");
        String codigo = scanner.nextLine();
        for (String[] cliente : clientes) {
            if (cliente[0].equals(codigo)) {
                System.out.print("Novo nome do cliente: ");
                cliente[1] = scanner.nextLine();
                System.out.println("Cliente alterado com sucesso!");
                return;
            }
        }
        System.out.println("Cliente não encontrado!");
    }

    public static void excluirCliente() {
        System.out.print("Código do cliente a excluir: ");
        String codigo = scanner.nextLine();
        clientes.removeIf(cliente -> cliente[0].equals(codigo));
        System.out.println("Cliente excluído com sucesso!");
    }

    public static void visualizarClientes() {
        System.out.println("Clientes cadastrados:");
        for (String[] cliente : clientes) {
            System.out.println("Código: " + cliente[0] + ", Nome: " + cliente[1]);
        }
    }
}
