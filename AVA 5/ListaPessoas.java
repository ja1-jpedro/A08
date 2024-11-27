import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class ListaPessoas {
    private final JFrame principal;

    public ListaPessoas(JFrame principal) {
        this.principal = principal;
    }

    // Método padrão
    public void exibir() {
        exibir("Lista de Pessoas", "Exemplo de lista de pessoas...");
    }

    // Sobrecarga: exibe com título e texto personalizados
    public void exibir(String titulo, String texto) {
        JDialog dialog = new JDialog(principal, titulo, true);
        dialog.setSize(750, 650);
        dialog.setLayout(new BorderLayout());

        dialog.add(new JLabel(titulo, SwingConstants.CENTER), BorderLayout.NORTH);
        dialog.add(new JTextArea(texto), BorderLayout.CENTER);

        JButton btnFechar = new JButton("Fechar");
        btnFechar.addActionListener(e -> dialog.setVisible(false));
        dialog.add(btnFechar, BorderLayout.SOUTH);

        dialog.setLocationRelativeTo(principal);
        dialog.setVisible(true);
    }

    // Sobrecarga: exibe com título personalizado, mas texto padrão
    public void exibir(String titulo) {
        exibir(titulo, "Exemplo de lista de pessoas...");
    }

    // Sobrecarga: exibe com texto personalizado, mas título padrão
    public void exibir(String texto) {
        exibir("Lista de Pessoas", texto);
    }
}
