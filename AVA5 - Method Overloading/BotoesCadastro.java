import java.awt.*;
import javax.swing.*;

public class BotoesCadastro {

    public static JPanel criarPainelBotoes(JDialog dialog) {
        return criarPainelBotoes(dialog, new String[]{"Incluir", "Alterar", "Excluir", "Consultar", "Cancelar", "Sair"});
    }

    public static JPanel criarPainelBotoes(JDialog dialog, String[] labels) {
        JPanel painelBotoes = new JPanel(new FlowLayout());
        for (String label : labels) {
            JButton button = new JButton(label);
            if (label.equals("Sair")) {
                button.addActionListener(e -> dialog.setVisible(false));
            } else {
                button.addActionListener(e -> JOptionPane.showMessageDialog(dialog, "Botão " + label + " clicado!"));
            }
            painelBotoes.add(button);
        }
        return painelBotoes;
    }
}