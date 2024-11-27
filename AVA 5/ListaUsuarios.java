import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class ListaUsuarios {
    private final JFrame principal;

    public ListaUsuarios(JFrame principal) {
        this.principal = principal;
    }

    // Método básico de exibição
    public void exibir() {
        exibir("Lista de Usuários", "Exemplo de lista de usuários...");
    }

    // Sobrecarga: exibir com título personalizado
    public void exibir(String titulo) {
        exibir(titulo, "Exemplo de lista de usuários...");
    }

    // Sobrecarga: exibir com título e lista personalizada
    public void exibir(String titulo, String listaUsuarios) {
        exibir(titulo, listaUsuarios, Color.WHITE);
    }

    // Sobrecarga: exibir com título, lista personalizada e cor de fundo
    public void exibir(String titulo, String listaUsuarios, Color corFundo) {
        JDialog dialog = new JDialog(principal, titulo, true);
        dialog.setSize(750, 650);
        dialog.setLayout(new BorderLayout());

        // Título
        dialog.add(new JLabel(titulo, SwingConstants.CENTER), BorderLayout.NORTH);

        // Texto da lista
        JTextArea textArea = new JTextArea(listaUsuarios);
        textArea.setEditable(false);
        dialog.add(textArea, BorderLayout.CENTER);

        // Cor de fundo (se fornecida)
        textArea.setBackground(corFundo);

        // Botão de Fechar
        JButton btnFechar = new JButton("Fechar");
        btnFechar.addActionListener(e -> dialog.setVisible(false));
        dialog.add(btnFechar, BorderLayout.SOUTH);

        // Configuração da janela
        dialog.setLocationRelativeTo(principal);
        dialog.setVisible(true);
    }
}
