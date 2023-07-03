package visao;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JInicial extends JFrame {
    private JButton btPessoa, btCarro, btAluguel;
    private JFrame frame;

    public JInicial() {
        frame = new JFrame("Menu Inicial.");
        frame.setSize(new Dimension(500, 560));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        btPessoa = new JButton("1 - Pessoa");
        btPessoa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new JPessoa(frame);
            }
        });
        frame.add(btPessoa);
        
        btCarro = new JButton("2 - Carro");
        btCarro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new JCarro(frame);
            }
        });
        frame.add(btCarro);
        
        btAluguel = new JButton("3 - Aluguel");
        btAluguel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new JAluguel(frame);
            }
        });
        frame.add(btAluguel);

        frame.setVisible(true);
    }
}