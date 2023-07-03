package visao;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controle.ControleAluguel;

public class JAluguel extends JFrame {
    private JFrame frame;

    private JTextField tfDataInicio, tfDataFim, tfPessoaId;
    private JButton btCadastrar, btExcluir, btAlterar;
    private JTable table;
    private DefaultTableModel modeloDefault;

    private ControleAluguel controleAluguel = new ControleAluguel();
    
    public JAluguel(JFrame menuInicial) {
        frame = new JFrame("Menu Aluguel.");
        frame.setSize(new Dimension(800, 800));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);

        tfDataInicio = new JTextField();
        tfDataInicio.setPreferredSize(new Dimension(50, 20));
        frame.add(new JLabel("Data de início:"));
        frame.add(tfDataInicio);

        tfDataFim = new JTextField();
        tfDataFim.setPreferredSize(new Dimension(50, 20));
        frame.add(new JLabel("Data de fim:"));
        frame.add(tfDataFim);

        tfPessoaId = new JTextField();
        tfPessoaId.setPreferredSize(new Dimension(50, 20));
        frame.add(new JLabel("Id da pessoa:"));
        frame.add(tfPessoaId);

        


        frame.setVisible(true);
    }

    public void cadastrar() {

    }

    public void excluir() {

    }

    public void alterar() {
        
    }

    public void mensagemErro(String erro) { // método que imprime na tela os erros regulares
        JOptionPane.showMessageDialog(this, erro, "ERRO", JOptionPane.ERROR_MESSAGE);
    }
}