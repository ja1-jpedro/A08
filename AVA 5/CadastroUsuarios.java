import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CadastroUsuarios {
    private final JFrame principal;

    public CadastroUsuarios(JFrame principal) {
        this.principal = principal;
    }

    // Método principal que exibe o cadastro com configurações padrão
    public void exibir() {
        exibir("Cadastro de Usuários", 600, 300);
    }

    // Método sobrecarregado que permite definir o título, largura e altura
    public void exibir(String tituloCadastro, int largura, int altura) {
        JDialog dialog = new JDialog(principal, tituloCadastro, true);
        dialog.setSize(largura, altura);
        dialog.setLayout(new BorderLayout());

        JLabel titulo = new JLabel(tituloCadastro, SwingConstants.CENTER);
        dialog.add(titulo, BorderLayout.NORTH);

        JPanel painelCampos = new JPanel(new GridLayout(4, 2, 5, 5));
        painelCampos.add(new JLabel("Usuário:"));
        painelCampos.add(new JTextField(25));
        painelCampos.add(new JLabel("Senha:"));
        painelCampos.add(new JPasswordField(15));
        painelCampos.add(new JLabel("Email:"));
        painelCampos.add(new JTextField(30));
        painelCampos.add(new JLabel("Ativo:"));
        painelCampos.add(new JRadioButton());

        dialog.add(painelCampos, BorderLayout.CENTER);
        dialog.add(new BotoesCadastro(dialog).criar(), BorderLayout.SOUTH);

        dialog.setLocationRelativeTo(principal);
        dialog.setVisible(true);
    }

    // Método sobrecarregado que permite também definir um JPanel com campos personalizados
    public void exibir(String tituloCadastro, int largura, int altura, JPanel painelCamposPersonalizado) {
        JDialog dialog = new JDialog(principal, tituloCadastro, true);
        dialog.setSize(largura, altura);
        dialog.setLayout(new BorderLayout());

        JLabel titulo = new JLabel(tituloCadastro, SwingConstants.CENTER);
        dialog.add(titulo, BorderLayout.NORTH);

        dialog.add(painelCamposPersonalizado, BorderLayout.CENTER);
        dialog.add(new BotoesCadastro(dialog).criar(), BorderLayout.SOUTH);

        dialog.setLocationRelativeTo(principal);
        dialog.setVisible(true);
    }

    // Método sobrecarregado que aceita um título e um painel com campos personalizados e um booleano para definir visibilidade
    public void exibir(String tituloCadastro, int largura, int altura, JPanel painelCamposPersonalizado, boolean visibilidade) {
        JDialog dialog = new JDialog(principal, tituloCadastro, true);
        dialog.setSize(largura, altura);
        dialog.setLayout(new BorderLayout());

        JLabel titulo = new JLabel(tituloCadastro, SwingConstants.CENTER);
        dialog.add(titulo, BorderLayout.NORTH);

        dialog.add(painelCamposPersonalizado, BorderLayout.CENTER);
        dialog.add(new BotoesCadastro(dialog).criar(), BorderLayout.SOUTH);

        dialog.setLocationRelativeTo(principal);
        dialog.setVisible(visibilidade);
    }
}
