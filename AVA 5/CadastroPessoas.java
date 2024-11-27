import javax.swing.*;
import java.awt.*;

public class CadastroPessoas {
    private final JFrame principal;

    public CadastroPessoas(JFrame principal) {
        this.principal = principal;
    }

    // Versão padrão: sem parâmetros
    public void exibir() {
        exibir("Cadastro de Pessoas", null); // Chama a versão com título padrão e sem JDialog pai
    }

    // Sobrecarga 1: Permite personalizar o título do JDialog
    public void exibir(String titulo) {
        exibir(titulo, null); // Chama a versão com título personalizado e sem JDialog pai
    }

    // Sobrecarga 2: Permite passar um JDialog pai
    public void exibir(JDialog parent) {
        exibir("Cadastro de Pessoas", parent); // Chama a versão com título padrão e JDialog pai
    }

    // Sobrecarga 3: Método com título e JDialog pai
    private void exibir(String titulo, JDialog parent) {
        // Se parent for null, cria um novo JDialog
        JDialog dialog = parent != null ? parent : new JDialog(principal, titulo, true);
        
        dialog.setSize(600, 300);
        dialog.setLayout(new BorderLayout());

        JLabel tituloLabel = new JLabel(titulo, SwingConstants.CENTER);
        dialog.add(tituloLabel, BorderLayout.NORTH);

        // Criando os campos de cadastro
        JPanel painelCampos = new JPanel(new GridLayout(7, 2, 5, 5));
        painelCampos.add(new JLabel("Nome:"));
        painelCampos.add(new JTextField(40));
        painelCampos.add(new JLabel("Endereço:"));
        painelCampos.add(new JTextField(60));
        painelCampos.add(new JLabel("Cidade:"));
        painelCampos.add(new JTextField(40));
        painelCampos.add(new JLabel("UF:"));
        painelCampos.add(new JTextField(2));
        painelCampos.add(new JLabel("Email:"));
        painelCampos.add(new JTextField(30));
        painelCampos.add(new JLabel("Telefone:"));
        painelCampos.add(new JTextField(20));
        painelCampos.add(new JLabel("Sexo:"));
        painelCampos.add(new JComboBox<>(new String[]{"Masculino", "Feminino"}));

        dialog.add(painelCampos, BorderLayout.CENTER);
        dialog.add(new BotoesCadastro(dialog).criar(), BorderLayout.SOUTH);

        dialog.setLocationRelativeTo(principal);
        dialog.setVisible(true);
    }
}