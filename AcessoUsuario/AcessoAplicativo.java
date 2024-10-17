import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AcessoAplicativo extends JFrame {

    private JTextField campoUsuario;
    private JPasswordField campoSenha;
    private final String usuarioCorreto = "denys.silva";
    private final String senhaCorreta = "Teste@2024";

    public AcessoAplicativo() {
        super("Acesso ao Aplicativo");

        setLayout(new GridLayout(3, 2, 10, 10));

        JLabel labelUsuario = new JLabel("Usuário:");
        campoUsuario = new JTextField(20);

        JLabel labelSenha = new JLabel("Senha:");
        campoSenha = new JPasswordField(20);

        JButton botaoConfirmar = new JButton("Confirmar");
        JButton botaoCancelar = new JButton("Cancelar");

        add(labelUsuario);
        add(campoUsuario);
        add(labelSenha);
        add(campoSenha);
        add(botaoConfirmar);
        add(botaoCancelar);

        botaoConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verificarAcesso();
            }
        });

        botaoCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void verificarAcesso() {
        String usuario = campoUsuario.getText();
        String senha = new String(campoSenha.getPassword());

        if (usuario.equals(usuarioCorreto) && senha.equals(senhaCorreta)) {
            JOptionPane.showMessageDialog(this, "Acesso confirmado!");
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Usuário ou senha inválido!");
        }
    }

    public static void main(String[] args) {
        new AcessoAplicativo();
    }
}
