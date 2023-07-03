package visao;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controle.ControlePessoa;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Pessoa;

public class JPessoa extends JFrame {
    private JFrame frame;

    private JTextField tfNome, tfCPF, tfTelefone;
    private JButton btCadastrar, btExcluir, btAlterar;
    private JTable table;
    private DefaultTableModel modeloDefault;
    
    private ControlePessoa controlePessoa = new ControlePessoa();
    
    public JPessoa(JFrame menuInicial) {
        frame = new JFrame("Menu Pessoa.");
        frame.setSize(new Dimension(800,800));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);

        tfNome = new JTextField();
		tfNome.setPreferredSize(new Dimension(300, 20));
		frame.add(new JLabel("Nome:"));
		frame.add(tfNome);

        tfCPF = new JTextField();
        tfCPF.setPreferredSize(new Dimension(300, 20));
        frame.add(new JLabel("CPF:"));
        frame.add(tfCPF);

        tfTelefone = new JTextField();
        tfTelefone.setPreferredSize(new Dimension(420, 20));
        frame.add(new JLabel("Telefone:"));
        frame.add(tfTelefone);

        btCadastrar = new JButton("Cadastrar");
        btCadastrar.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                // verificações para efetivar o cadastro de uma nova pessoa com sucesso
                if (tfNome.getText().isEmpty())
                    mensagemErro("O nome não pode ser vazio.");
                else if (tfCPF.getText().isEmpty())
                    mensagemErro("O CPF não pode ser vazio.");
                else if (tfTelefone.getText().isEmpty())
                    mensagemErro("O telefone não pode ser vazio.");
                else { // livre para cadastrar com os dados passados
                    cadastrar(tfNome.getText(), tfCPF.getText(), tfTelefone.getText());
                }
			}			
		});
		frame.add(btCadastrar);

        btExcluir = new JButton("Excluir");
        btExcluir.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (table.getSelectedRow() == -1)
                    mensagemErro("Selecione uma linha da tabela para excluir.");
                else
                    excluir((int) table.getValueAt(table.convertRowIndexToModel(table.getSelectedRow()), 0));  
            }
        });
        frame.add(btExcluir);

        btAlterar = new JButton("Alterar");
        btAlterar.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (table.getSelectedRow() == -1)
                    mensagemErro("Selecione uma linha da tabela para alterar.");
                else if (tfNome.getText().isEmpty())
                    mensagemErro("O nome não pode ser vazio.");
                else if (tfCPF.getText().isEmpty())
                    mensagemErro("O CPF não pode ser vazio.");
                else if (tfTelefone.getText().isEmpty())
                    mensagemErro("O telefone não pode ser vazio.");
                else
                    alterar((int) table.getValueAt(table.convertRowIndexToModel(table.getSelectedRow()), 0), tfNome.getText(), tfCPF.getText(), tfTelefone.getText());
            }
        });
        frame.add(btAlterar);

        modeloDefault = new DefaultTableModel(); // tabela com os dados das pessoas cadastradas
		modeloDefault.addColumn("Id");
		modeloDefault.addColumn("Nome");
		modeloDefault.addColumn("CPF");
		modeloDefault.addColumn("Telefone");
		table = new JTable(modeloDefault);
		table.setPreferredSize(new Dimension(580, 400));
		table.getColumnModel().getColumn(0).setMaxWidth(50);
		table.getColumnModel().getColumn(1).setMaxWidth(300);
		table.getColumnModel().getColumn(2).setMaxWidth(500);
		table.getColumnModel().getColumn(3).setMaxWidth(200);
		
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(table);
		frame.add(scroll);

        frame.setVisible(true);
    }

    public void cadastrar(String nome, String CPF, String telefone) {
        Pessoa pessoa = new Pessoa(nome, CPF, telefone);
        controlePessoa.cadastrar(pessoa);
        // adiciona a nova pessoa à tabela
        modeloDefault.addRow(new Object[] { pessoa.getId(), pessoa.getNome(), pessoa.getCpf(), pessoa.getTelefone() });
    }

    public void excluir(int id) {
        controlePessoa.excluir(id);
        modeloDefault.removeRow(table.getSelectedRow()); // remove a linha selecionada pelo usuário
        modeloDefault.fireTableDataChanged(); // atualiza a tabela
    }

    public void alterar(int id, String nome, String CPF, String telefone) {
        controlePessoa.alterar(id, nome, CPF, telefone);
        modeloDefault.fireTableDataChanged(); // atualiza a tabela
    }

    public void mensagemErro(String erro) { // método que imprime na tela os erros regulares
        JOptionPane.showMessageDialog(this, erro, "ERRO", JOptionPane.ERROR_MESSAGE);
    }
}