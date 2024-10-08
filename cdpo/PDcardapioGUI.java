import java.awt.*;
import javax.swing.*;

public class PDcardapioGUI {
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("PD Cardápio");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 400);
            frame.setLayout(new FlowLayout());

            JButton btnClientes = new JButton("Cadastro de Clientes");
            JButton btnProdutos = new JButton("Cadastro de Produtos");
            JButton btnListarCardapio = new JButton("Listar Cardápio");
            JButton btnListarClientes = new JButton("Listar Clientes");
            JButton btnExcluirClientes = new JButton("Excluir Cliente");
            JButton btnExcluirProdutos = new JButton("Excluir Produto");
            JButton btnAlterarClientes = new JButton("Alterar Cliente");
            JButton btnAlterarProdutos = new JButton("Alterar Produto");
            JButton btnSair = new JButton("Sair");

            frame.add(btnClientes);
            frame.add(btnProdutos);
            frame.add(btnListarCardapio);
            frame.add(btnListarClientes);
            frame.add(btnExcluirClientes);
            frame.add(btnExcluirProdutos);
            frame.add(btnAlterarClientes);
            frame.add(btnAlterarProdutos);
            frame.add(btnSair);

            btnClientes.addActionListener(e -> menuCadastroClientes());
            btnProdutos.addActionListener(e -> menuCadastroProduto());
            btnListarCardapio.addActionListener(e -> listarCardapio());
            btnListarClientes.addActionListener(e -> listarClientes());
            btnExcluirClientes.addActionListener(e -> excluirCliente());
            btnExcluirProdutos.addActionListener(e -> excluirProduto());
            btnAlterarClientes.addActionListener(e -> alterarCliente());
            btnAlterarProdutos.addActionListener(e -> alterarProduto());
            btnSair.addActionListener(e -> System.exit(0));

            frame.setVisible(true);
        });
    }

    private static void menuCadastroClientes() {
        JFrame clienteFrame = new JFrame("Cadastro de Clientes");
        clienteFrame.setSize(400, 400);
        clienteFrame.setLayout(new GridLayout(8, 2));

        JTextField txtNome = new JTextField();
        JTextField txtEndereco = new JTextField();
        JTextField txtTelefone = new JTextField();
        JTextField txtEmail = new JTextField();
        JTextField txtSexo = new JTextField();
        JTextField txtDataNasc = new JTextField();
        JTextField txtAutorizado = new JTextField();

        clienteFrame.add(new JLabel("Nome (6-60 caracteres):"));
        clienteFrame.add(txtNome);
        clienteFrame.add(new JLabel("Endereço:"));
        clienteFrame.add(txtEndereco);
        clienteFrame.add(new JLabel("Telefone:"));
        clienteFrame.add(txtTelefone);
        clienteFrame.add(new JLabel("Email (opcional):"));
        clienteFrame.add(txtEmail);
        clienteFrame.add(new JLabel("Sexo (M/F):"));
        clienteFrame.add(txtSexo);
        clienteFrame.add(new JLabel("Data de Nascimento (dd/MM/yyyy):"));
        clienteFrame.add(txtDataNasc);
        clienteFrame.add(new JLabel("Autorizado (S/N):"));
        clienteFrame.add(txtAutorizado);

        JButton btnCadastrar = new JButton("Cadastrar");
        clienteFrame.add(btnCadastrar);

        btnCadastrar.addActionListener(e -> {
            cadastrarCliente(txtNome.getText(), txtEndereco.getText(), txtTelefone.getText(), 
                             txtEmail.getText(), txtSexo.getText().charAt(0), 
                             txtDataNasc.getText(), txtAutorizado.getText().charAt(0));
            clienteFrame.dispose();
        });

        clienteFrame.setVisible(true);
    }

    private static void menuCadastroProduto() {
        JFrame produtoFrame = new JFrame("Cadastro de Produtos");
        produtoFrame.setSize(400, 400);
        produtoFrame.setLayout(new GridLayout(5, 2));

        JTextField txtCodigo = new JTextField();
        JTextField txtNome = new JTextField();
        JTextField txtPreco = new JTextField();
        JTextField txtAtivo = new JTextField();

        produtoFrame.add(new JLabel("Código (6 caracteres):"));
        produtoFrame.add(txtCodigo);
        produtoFrame.add(new JLabel("Nome (3-60 caracteres):"));
        produtoFrame.add(txtNome);
        produtoFrame.add(new JLabel("Preço:"));
        produtoFrame.add(txtPreco);
        produtoFrame.add(new JLabel("Ativo (S/N):"));
        produtoFrame.add(txtAtivo);

        JButton btnCadastrar = new JButton("Cadastrar");
        produtoFrame.add(btnCadastrar);

        btnCadastrar.addActionListener(e -> {
            try {
                double preco = Double.parseDouble(txtPreco.getText());
                cadastrarProduto(txtCodigo.getText(), txtNome.getText(), preco, 
                                 txtAtivo.getText().charAt(0));
                produtoFrame.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Preço deve ser um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        produtoFrame.setVisible(true);
    }

    public static void listarCardapio() {
        StringBuilder cardapio = new StringBuilder("CARDÁPIO:\n-------------------------------\n");
        for (int i = 0; i < quantidadeProdutos; i++) {
            if (ativos[i]) {
                cardapio.append(String.format("%-8s%-45s%.2f\n", codigos[i], nomes[i], precos[i]));
            }
        }
        JOptionPane.showMessageDialog(null, cardapio.toString(), "Cardápio", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void listarClientes() {
        StringBuilder clientesList = new StringBuilder("CLIENTES:\n-------------------------------\n");
        for (int i = 0; i < quantidadeClientes; i++) {
            clientesList.append(String.format("Nome: %s, Endereço: %s, Telefone: %s, Email: %s, Sexo: %c, Data Nasc: %s, Autorizado: %s\n", 
                nomesClientes[i], enderecos[i], telefones[i], emails[i] != null ? emails[i] : "N/A", 
                sexos[i], datasNasc[i], autorizados[i] ? "Sim" : "Não"));
        }
        JOptionPane.showMessageDialog(null, clientesList.toString(), "Clientes", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void cadastrarCliente(String nome, String endereco, String telefone, String email, char sexo, String dataNasc, char autorizado) {
        if (quantidadeClientes >= MAX_CLIENTES) {
            JOptionPane.showMessageDialog(null, "Limite de clientes atingido");
            return;
        }

        if (nome.length() < 6 || nome.length() > 60) {
            JOptionPane.showMessageDialog(null, "Nome inválido");
            return;
        }

        nomesClientes[quantidadeClientes] = nome;
        enderecos[quantidadeClientes] = endereco;
        telefones[quantidadeClientes] = telefone;
        emails[quantidadeClientes] = email;
        sexos[quantidadeClientes] = sexo;
        datasNasc[quantidadeClientes] = dataNasc;
        autorizados[quantidadeClientes] = (autorizado == 'S' || autorizado == 's');

        quantidadeClientes++;
        JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso");
    }

    public static void cadastrarProduto(String codigo, String nome, double preco, char ativo) {
        if (quantidadeProdutos >= MAX_PRODUTOS) {
            JOptionPane.showMessageDialog(null, "Limite de produtos atingido");
            return;
        }

        if (codigo.length() != 6) {
            JOptionPane.showMessageDialog(null, "Código inválido");
            return;
        }

        if (nome.length() < 3 || nome.length() > 60) {
            JOptionPane.showMessageDialog(null, "Nome inválido");
            return;
        }

        if (preco <= 0) {
            JOptionPane.showMessageDialog(null, "Preço inválido");
            return;
        }

        codigos[quantidadeProdutos] = codigo;
        nomes[quantidadeProdutos] = nome;
        precos[quantidadeProdutos] = preco;
        ativos[quantidadeProdutos] = (ativo == 'S' || ativo == 's');
        quantidadeProdutos++;

        JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso");
    }

    public static void excluirCliente() {
        String nome = JOptionPane.showInputDialog("Digite o nome do cliente a ser excluído:");
        for (int i = 0; i < quantidadeClientes; i++) {
            if (nomesClientes[i].equalsIgnoreCase(nome)) {
                for (int j = i; j < quantidadeClientes - 1; j++) {
                    nomesClientes[j] = nomesClientes[j + 1];
                    enderecos[j] = enderecos[j + 1];
                    telefones[j] = telefones[j + 1];
                    emails[j] = emails[j + 1];
                    sexos[j] = sexos[j + 1];
                    datasNasc[j] = datasNasc[j + 1];
                    autorizados[j] = autorizados[j + 1];
                }
                quantidadeClientes--;
                JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
    }

    public static void excluirProduto() {
        String codigo = JOptionPane.showInputDialog("Digite o código do produto a ser excluído:");
        for (int i = 0; i < quantidadeProdutos; i++) {
            if (codigos[i].equalsIgnoreCase(codigo)) {
                for (int j = i; j < quantidadeProdutos - 1; j++) {
                    codigos[j] = codigos[j + 1];
                    nomes[j] = nomes[j + 1];
                    precos[j] = precos[j + 1];
                    ativos[j] = ativos[j + 1];
                }
                quantidadeProdutos--;
                JOptionPane.showMessageDialog(null, "Produto excluído com sucesso.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Produto não encontrado.");
    }

    public static void alterarCliente() {
        String nome = JOptionPane.showInputDialog("Digite o nome do cliente a ser alterado:");
        for (int i = 0; i < quantidadeClientes; i++) {
            if (nomesClientes[i].equalsIgnoreCase(nome)) {
                String novoNome = JOptionPane.showInputDialog("Novo nome (ou pressione Enter para manter):", nomesClientes[i]);
                if (!novoNome.isEmpty()) {
                    nomesClientes[i] = novoNome;
                }
                String novoEndereco = JOptionPane.showInputDialog("Novo endereço (ou pressione Enter para manter):", enderecos[i]);
                if (!novoEndereco.isEmpty()) {
                    enderecos[i] = novoEndereco;
                }
                String novoTelefone = JOptionPane.showInputDialog("Novo telefone (ou pressione Enter para manter):", telefones[i]);
                if (!novoTelefone.isEmpty()) {
                    telefones[i] = novoTelefone;
                }
                String novoEmail = JOptionPane.showInputDialog("Novo email (ou pressione Enter para manter):", emails[i]);
                if (!novoEmail.isEmpty()) {
                    emails[i] = novoEmail;
                }
                String novoSexo = JOptionPane.showInputDialog("Novo sexo (ou pressione Enter para manter):", String.valueOf(sexos[i]));
                if (!novoSexo.isEmpty()) {
                    sexos[i] = novoSexo.charAt(0);
                }
                String novaDataNasc = JOptionPane.showInputDialog("Nova data de nascimento (ou pressione Enter para manter):", datasNasc[i]);
                if (!novaDataNasc.isEmpty()) {
                    datasNasc[i] = novaDataNasc;
                }
                String novoAutorizado = JOptionPane.showInputDialog("Novo status de autorização (S/N, ou pressione Enter para manter):", autorizados[i] ? "S" : "N");
                if (!novoAutorizado.isEmpty()) {
                    autorizados[i] = (novoAutorizado.charAt(0) == 'S' || novoAutorizado.charAt(0) == 's');
                }
                JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
    }

    public static void alterarProduto() {
        String codigo = JOptionPane.showInputDialog("Digite o código do produto a ser alterado:");
        for (int i = 0; i < quantidadeProdutos; i++) {
            if (codigos[i].equalsIgnoreCase(codigo)) {
                String novoNome = JOptionPane.showInputDialog("Novo nome (ou pressione Enter para manter):", nomes[i]);
                if (!novoNome.isEmpty()) {
                    nomes[i] = novoNome;
                }
                String novoPreco = JOptionPane.showInputDialog("Novo preço (ou pressione Enter para manter):", precos[i]);
                if (!novoPreco.isEmpty()) {
                    try {
                        precos[i] = Double.parseDouble(novoPreco);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Preço deve ser um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
                String novoAtivo = JOptionPane.showInputDialog("Novo status ativo (S/N, ou pressione Enter para manter):", ativos[i] ? "S" : "N");
                if (!novoAtivo.isEmpty()) {
                    ativos[i] = (novoAtivo.charAt(0) == 'S' || novoAtivo.charAt(0) == 's');
                }
                JOptionPane.showMessageDialog(null, "Produto alterado com sucesso.");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Produto não encontrado.");
    }
}
