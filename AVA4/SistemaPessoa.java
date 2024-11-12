import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SistemaPessoa {
    private JFrame principal;
    private final String versaoSistema = "12.1.2024";
    private final String nomeUsuario = "denys.silva";
    private String dataAcesso;

    public SistemaPessoa() {
        inicializarDados();
        configurarFrame();
        iniciar();
    }

    private void inicializarDados() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm");
        dataAcesso = dateFormat.format(new Date());
    }

    private void configurarFrame() {
        principal = new JFrame("Sistema Pessoa");
        principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        principal.setSize(800, 800);
        principal.setLayout(new BorderLayout());
    }

    private void iniciar() {
        principal.setJMenuBar(new MenuSistema(this));
        principal.add(new AreaTrabalho(), BorderLayout.CENTER);
        principal.add(new Rodape(versaoSistema, nomeUsuario, dataAcesso), BorderLayout.SOUTH);

        principal.setLocationRelativeTo(null); // Centraliza a janela
        principal.setVisible(true); // Torna a janela visível
    }

    public void sair() {
        System.exit(0); // Sai do sistema
    }

    // Classe para criar a área de trabalho central
    private static class AreaTrabalho extends JTextArea {
        public AreaTrabalho() {
            super();
        }
    }

    // Classe para criar a barra de menu
    private static class MenuSistema extends JMenuBar {
        public MenuSistema(SistemaPessoa sistema) {
            criarMenu(sistema);
        }

        private void criarMenu(SistemaPessoa sistema) {
            // Criação dos menus
            JMenu menuCadastro = new JMenu("Cadastro");
            JMenu menuVisualizacao = new JMenu("Visualização");
            JMenu menuSair = new JMenu("Sair");

            // Itens do menu Cadastro
            menuCadastro.add(new JMenuItem("Usuários"));
            menuCadastro.add(new JMenuItem("Pessoas"));

            // Itens do menu Visualização
            menuVisualizacao.add(new JMenuItem("Lista de usuários"));
            menuVisualizacao.add(new JMenuItem("Lista de pessoas"));

            // Ação para o menu "Sair"
            menuSair.addMenuListener(new javax.swing.event.MenuListener() {
                @Override
                public void menuSelected(javax.swing.event.MenuEvent e) {
                    sistema.sair();
                }

                @Override
                public void menuDeselected(javax.swing.event.MenuEvent e) {
                }

                @Override
                public void menuCanceled(javax.swing.event.MenuEvent e) {
                }
            });

            // Adiciona os menus na barra de menu
            add(menuCadastro);
            add(menuVisualizacao);
            add(menuSair);
        }
    }

    // Classe para o rodapé do sistema
    private static class Rodape extends JPanel {
        public Rodape(String versaoSistema, String nomeUsuario, String dataAcesso) {
            JLabel labelRodape = new JLabel("Versão: " + versaoSistema + "               Usuário: " + nomeUsuario
                    + "               Data de acesso: " + dataAcesso);
            add(labelRodape);
        }
    }

    public static void main(String[] args) {
        new SistemaPessoa();
    }
}
