
import java.awt.*;
import javax.swing.*;

public class SistemaPessoa extends JFrame {

    public SistemaPessoa() {
        // Configurações da Janela Principal
        setTitle("Sistema de Pessoa");
        setSize(600, 300);
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

        // Layout principal
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Painel de Cadastro
        JPanel cadastroPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        cadastroPanel.setBorder(BorderFactory.createTitledBorder("Cadastro de Usuários"));

        // Campos de texto para o formulário de Cadastro
        cadastroPanel.add(new JLabel("Usuário:"));
        JTextField usuarioField = new JTextField();
        cadastroPanel.add(usuarioField);

        cadastroPanel.add(new JLabel("Senha:"));
        JPasswordField senhaField = new JPasswordField();
        cadastroPanel.add(senhaField);

        cadastroPanel.add(new JLabel("Email:"));
        JTextField emailField = new JTextField();
        cadastroPanel.add(emailField);

        cadastroPanel.add(new JLabel("Ativo:"));
        JRadioButton ativoButton = new JRadioButton();
        cadastroPanel.add(ativoButton);

        // Adicionando o Painel de Cadastro ao painel principal
        mainPanel.add(cadastroPanel, BorderLayout.NORTH); // Coloca no centro da janela

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
        incluirButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Botão Incluir clicado!"));
        alterarButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Botão Alterar clicado!"));
        excluirButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Botão Excluir clicado!"));
        consultarButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Botão Consultar clicado!"));
        cancelarButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Botão Cancelar clicado!"));
        sairButton.addActionListener(e -> System.exit(0));

        // Adicionando o painel de botões ao painel principal
        mainPanel.add(botoesPanel, BorderLayout.EAST); // Na parte inferior, logo acima do rodapé

        // Rodapé
        JPanel rodapePanel = new JPanel(new BorderLayout());
        JLabel rodape = new JLabel("Versão: 12.1.2024    Usuário: denys.silva    Data de acesso: 20/09/2024 10:58",
                JLabel.CENTER);
        rodapePanel.add(rodape, BorderLayout.CENTER);

        mainPanel.add(rodapePanel, BorderLayout.PAGE_END); // Rodapé na parte final

        // Adiciona o painel principal à janela
        add(mainPanel);
    }

    public static void main(String[] args) {
        // Executa a aplicação
        SwingUtilities.invokeLater(() -> {
            SistemaPessoa frame = new SistemaPessoa();
            frame.setVisible(true);
        });
    }
}
