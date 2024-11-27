import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class SistemaPessoa {

    public static void main(String[] args) {
        new SistemaPessoa().iniciarSistema();
    }

    // Método principal para iniciar o sistema com configurações padrão
    public void iniciarSistema() {
        iniciarSistema(800, 800, true);  // Chama o método sobrecarregado com parâmetros padrão
    }

    // Sobrecarga: iniciar o sistema com tamanho personalizado da janela
    public void iniciarSistema(int largura, int altura) {
        iniciarSistema(largura, altura, true);  // Chama o método sobrecarregado com o terceiro parâmetro padrão
    }

    // Sobrecarga: iniciar o sistema com tamanho personalizado e opção de mostrar/ocultar rodapé
    public void iniciarSistema(int largura, int altura, boolean mostrarRodape) {
        JFrame principal = new JFrame("Sistema Pessoa");
        principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        principal.setSize(largura, altura);

        JMenuBar menuPrincipal = new JMenuBar();
        JMenu menuCadastro = new JMenu("Cadastro");
        JMenu menuVisualizacao = new JMenu("Visualização");
        JMenu menuSair = new JMenu("Sair");

        menuSair.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuSelected(javax.swing.event.MenuEvent e) {
                System.exit(0);
            }

            public void menuDeselected(javax.swing.event.MenuEvent e) {}

            public void menuCanceled(javax.swing.event.MenuEvent e) {}
        });

        menuPrincipal.add(menuCadastro);
        menuPrincipal.add(menuVisualizacao);
        menuPrincipal.add(menuSair);

        JMenuItem itemMenuCadastroUsuarios = new JMenuItem("Usuários");
        JMenuItem itemMenuCadastroPessoas = new JMenuItem("Pessoas");
        menuCadastro.add(itemMenuCadastroUsuarios);
        menuCadastro.add(itemMenuCadastroPessoas);

        JMenuItem itemMenuVisualizacaoListaUsuarios = new JMenuItem("Lista de usuários");
        JMenuItem itemMenuVisualizacaoListaPessoas = new JMenuItem("Lista de pessoas");
        menuVisualizacao.add(itemMenuVisualizacaoListaUsuarios);
        menuVisualizacao.add(itemMenuVisualizacaoListaPessoas);

        JTextArea areaTrabalho = new JTextArea();
        JPanel painelRodape = new JPanel();
        JLabel labelRodape = new JLabel(
            "Versão: " + ConfiguracoesSistema.VERSAO_SISTEMA +
            "    Usuário: " + ConfiguracoesSistema.NOME_USUARIO +
            "    Data de acesso: " + ConfiguracoesSistema.DATA_ACESSO
        );
        if (mostrarRodape) {
            painelRodape.add(labelRodape);
            principal.getContentPane().add(BorderLayout.SOUTH, painelRodape); // Adiciona o rodapé apenas se necessário
        }

        principal.getContentPane().add(BorderLayout.NORTH, menuPrincipal);
        principal.getContentPane().add(BorderLayout.CENTER, areaTrabalho);

        itemMenuCadastroUsuarios.addActionListener(e -> new CadastroUsuarios(principal).exibir());
        itemMenuCadastroPessoas.addActionListener(e -> new CadastroPessoas(principal).exibir());
        itemMenuVisualizacaoListaUsuarios.addActionListener(e -> new ListaUsuarios(principal).exibir());
        itemMenuVisualizacaoListaPessoas.addActionListener(e -> new ListaPessoas(principal).exibir());

        principal.setLocationRelativeTo(null);
        principal.setVisible(true);
    }
}
