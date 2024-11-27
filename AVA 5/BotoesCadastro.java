import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BotoesCadastro {
    private final JDialog dialog;

    public BotoesCadastro(JDialog dialog) {
        this.dialog = dialog;
    }

    // Método original para criar botões com rótulos padrão
    public JPanel criar() {
        return criar(new String[] {"Incluir", "Alterar", "Excluir", "Consultar", "Cancelar", "Sair"}, new FlowLayout());
    }

    // Sobrecarga: criar botões com rótulos personalizados e layout padrão
    public JPanel criar(String[] labels) {
        return criar(labels, new FlowLayout());
    }

    // Sobrecarga: criar botões com rótulos e layout personalizados
    public JPanel criar(String[] labels, LayoutManager layout) {
        JPanel painelBotoes = new JPanel(layout);
        for (String label : labels) {
            JButton button = new JButton(label);
            if ("Sair".equals(label)) {
                // Removido o parâmetro 'e' porque não é necessário
                button.addActionListener(e -> dialog.setVisible(false)); // Não usa 'e', mas ainda assim é necessário
            } else {
                // Agora a expressão lambda não recebe o parâmetro 'e'
                button.addActionListener(e -> JOptionPane.showMessageDialog(dialog, "Botão " + label + " clicado!"));
            }
            painelBotoes.add(button);
        }
        return painelBotoes;
    }

    // Sobrecarga: criar botões com rótulos personalizados e um layout de FlowLayout com alinhamento específico
    public JPanel criar(String[] labels, int alignment) {
        return criar(labels, new FlowLayout(alignment));
    }
}
