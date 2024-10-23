import java.awt.*;
import javax.swing.*;

public class SistemaPessoa extends JFrame {
    public SistemaPessoa() {
        // Configurações da Janela Principal
        setTitle("Sistema de Pessoa");
        setSize(600, 400);
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

        // Rodapé
        JLabel rodape = new JLabel("Versão: 12.1.2024    Usuário: denys.silva    Data de acesso: 20/09/2024 10:58", JLabel.CENTER);
        mainPanel.add(rodape, BorderLayout.SOUTH);

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
