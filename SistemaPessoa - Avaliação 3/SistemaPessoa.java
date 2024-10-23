
import java.awt.*;
import javax.swing.*;

public class SistemaPessoa extends JFrame {

    private CardLayout cardLayout; // Para alternar entre os painéis
    private JPanel mainPanel; // Painel principal para o CardLayout

    public SistemaPessoa() {
        // Configurações da Janela Principal
        setTitle("Sistema de Pessoa");
        setSize(600, 400); // Aumenta o tamanho para acomodar os novos campos
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela na tela

        // Criação do Menu
        JMenuBar menuBar = new JMenuBar();

        // Menu "Cadastro"
        JMenu cadastroMenu = new JMenu("Cadastro");
        JMenuItem usuariosMenuItem = new JMenuItem("Usuários");
        JMenuItem pessoasMenuItem = new JMenuItem("Pessoas");
        cadastroMenu.add(usuariosMenuItem);
        cadastroMenu.add(pessoasMenuItem);

        // Ação dos Itens do Menu
        usuariosMenuItem.addActionListener(e -> showCadastroUsuario());
        pessoasMenuItem.addActionListener(e -> showCadastroPessoa());

        // Menu "Visualização"
        JMenu visualizacaoMenu = new JMenu("Visualização");
        JMenuItem listaUsuariosMenuItem = new JMenuItem("Lista de Usuários");
        JMenuItem listaPessoasMenuItem = new JMenuItem("Lista de Pessoas");
        visualizacaoMenu.add(listaUsuariosMenuItem);
        visualizacaoMenu.add(listaPessoasMenuItem);

        // Menu "Sair"
        JMenu sairMenu = new JMenu("Sair");
        JMenuItem sairMenuItem = new JMenuItem("Sair");
        sairMenuItem.addActionListener(e -> System.exit(0)); // Fecha o programa
        sairMenu.add(sairMenuItem);

        // Adicionando os menus na barra de menu
        menuBar.add(cadastroMenu);
        menuBar.add(visualizacaoMenu);
        menuBar.add(sairMenu);

        // Adiciona a barra de menu na janela principal
        setJMenuBar(menuBar);

        // Layout principal com CardLayout
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        mainPanel.add(createCadastroUsuarioPanel(), "Usuarios");
        mainPanel.add(createCadastroPessoaPanel(), "Pessoas");

        // Adiciona o painel principal à janela
        add(mainPanel, BorderLayout.CENTER); // Painel central

        // Rodapé
        add(createFooter(), BorderLayout.SOUTH);
    }

    private JPanel createCadastroUsuarioPanel() {
        // Painel de Cadastro de Usuários
        JPanel cadastroPanel = new JPanel();
        cadastroPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Espaçamento

        // Campos de texto para o formulário de Cadastro
        gbc.gridx = 0;
        gbc.gridy = 0;
        cadastroPanel.add(new JLabel("Usuário:"), gbc);
        gbc.gridx = 1;
        JTextField usuarioField = new JTextField(15);
        cadastroPanel.add(usuarioField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        cadastroPanel.add(new JLabel("Senha:"), gbc);
        gbc.gridx = 1;
        JPasswordField senhaField = new JPasswordField(15);
        cadastroPanel.add(senhaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        cadastroPanel.add(new JLabel("Email:"), gbc);
        gbc.gridx = 1;
        JTextField emailField = new JTextField(15);
        cadastroPanel.add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        cadastroPanel.add(new JLabel("Ativo:"), gbc);
        gbc.gridx = 1;
        JRadioButton ativoButton = new JRadioButton();
        cadastroPanel.add(ativoButton, gbc);

        // Adicionando o painel de cadastro ao painel principal
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2; // Ocupa duas colunas
        gbc.anchor = GridBagConstraints.EAST; // Alinha à direita
        cadastroPanel.add(createButtonsPanel("usuario"), gbc); // Painel de botões

        return cadastroPanel;
    }

    private JPanel createCadastroPessoaPanel() {
        // Painel de Cadastro de Pessoas
        JPanel cadastroPanel = new JPanel();
        cadastroPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Espaçamento

        // Campos de texto para o formulário de Cadastro
        gbc.gridx = 0;
        gbc.gridy = 0;
        cadastroPanel.add(new JLabel("Nome:"), gbc);
        gbc.gridx = 1;
        JTextField nomeField = new JTextField(15);
        cadastroPanel.add(nomeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        cadastroPanel.add(new JLabel("Endereço:"), gbc);
        gbc.gridx = 1;
        JTextField enderecoField = new JTextField(15);
        cadastroPanel.add(enderecoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        cadastroPanel.add(new JLabel("Cidade:"), gbc);
        gbc.gridx = 1;
        JTextField cidadeField = new JTextField(15);
        cadastroPanel.add(cidadeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        cadastroPanel.add(new JLabel("UF:"), gbc);
        gbc.gridx = 1;
        
        JTextField ufField = new JTextField(2);
        cadastroPanel.add(ufField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        cadastroPanel.add(new JLabel("Gmail:"), gbc);
        gbc.gridx = 1;
        JTextField gmailField = new JTextField(15);
        cadastroPanel.add(gmailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        cadastroPanel.add(new JLabel("Telefone:"), gbc);
        gbc.gridx = 1;
        JTextField telefoneField = new JTextField(15);
        cadastroPanel.add(telefoneField, gbc);

        // Seleção de Gênero
        gbc.gridx = 0;
        gbc.gridy = 6;
        cadastroPanel.add(new JLabel("Gênero:"), gbc);
        gbc.gridx = 1;
        JPanel generoPanel = new JPanel();
        JRadioButton masculinoButton = new JRadioButton("Masculino");
        JRadioButton femininoButton = new JRadioButton("Feminino");
        ButtonGroup generoGroup = new ButtonGroup();
        generoGroup.add(masculinoButton);
        generoGroup.add(femininoButton);
        generoPanel.add(masculinoButton);
        generoPanel.add(femininoButton);
        cadastroPanel.add(generoPanel, gbc);

        // Adicionando o painel de cadastro ao painel principal
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2; // Ocupa duas colunas
        gbc.anchor = GridBagConstraints.EAST; // Alinha à direita
        cadastroPanel.add(createButtonsPanel("pessoa"), gbc); // Painel de botões

        return cadastroPanel;
    }

    private JPanel createButtonsPanel(String tipo) {
        // Painel de Botões
        JPanel botoesPanel = new JPanel();
        botoesPanel.setLayout(new BoxLayout(botoesPanel, BoxLayout.LINE_AXIS)); // Usa BoxLayout na horizontal

        JButton incluirButton = new JButton("Incluir");
        JButton alterarButton = new JButton("Alterar");
        JButton excluirButton = new JButton("Excluir");
        JButton consultarButton = new JButton("Consultar");
        JButton cancelarButton = new JButton("Cancelar");
        JButton sairButton = new JButton("Sair");

        botoesPanel.add(incluirButton);
        botoesPanel.add(Box.createHorizontalStrut(10)); // Espaçamento entre os botões
        botoesPanel.add(alterarButton);
        botoesPanel.add(Box.createHorizontalStrut(10));
        botoesPanel.add(excluirButton);
        botoesPanel.add(Box.createHorizontalStrut(10));
        botoesPanel.add(consultarButton);
        botoesPanel.add(Box.createHorizontalStrut(10));
        botoesPanel.add(cancelarButton);
        botoesPanel.add(Box.createHorizontalStrut(10));
        botoesPanel.add(sairButton);

        // Ações dos Botões
        incluirButton
                .addActionListener(e -> JOptionPane.showMessageDialog(this, "Botão Incluir " + tipo + " clicado!"));
        alterarButton
                .addActionListener(e -> JOptionPane.showMessageDialog(this, "Botão Alterar " + tipo + " clicado!"));
        excluirButton
                .addActionListener(e -> JOptionPane.showMessageDialog(this, "Botão Excluir " + tipo + " clicado!"));
        consultarButton
                .addActionListener(e -> JOptionPane.showMessageDialog(this, "Botão Consultar " + tipo + " clicado!"));
        cancelarButton
                .addActionListener(e -> JOptionPane.showMessageDialog(this, "Botão Cancelar " + tipo + " clicado!"));
        sairButton.addActionListener(e -> System.exit(0));

        return botoesPanel; // Retorna o painel de botões
    }

    private JPanel createFooter() {
        // Rodapé
        JPanel rodapePanel = new JPanel(new BorderLayout());
        JLabel rodape = new JLabel("Versão: 12.1.2024    Usuário: denys.silva    Data de acesso: 20/09/2024 10:58",
                JLabel.CENTER);
        rodapePanel.add(rodape, BorderLayout.CENTER);

        return rodapePanel; // Retorna o rodapé
    }

    private void showCadastroUsuario() {
        cardLayout.show(mainPanel, "Usuarios");
    }

    private void showCadastroPessoa() {
        cardLayout.show(mainPanel, "Pessoas");
    }

    public static void main(String[] args) {
        // Executa a aplicação
        SwingUtilities.invokeLater(() -> {
            SistemaPessoa frame = new SistemaPessoa();
            frame.setVisible(true);
        });
    }
}
