package visao;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.NumberFormatter;

import controle.Controle;
import controle.ControleCarro;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import modelo.Carro;

public class JCarro extends JFrame {
    private JFrame frame;

    private JTextField tfModelo, tfMarca;
    private JFormattedTextField tfAno, tfValorDiaria; // garante que os valores estejam de acordo com os formatos indicados
    private JButton btCadastrar, btExcluir;
    private JTable table;
    private DefaultTableModel modeloDefault;
    
    private Controle controleCarro = new ControleCarro();

    public JCarro(JFrame menuInicial) {   
        frame = new JFrame("Menu Carro");
        frame.setSize(new Dimension(800,800));
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        
        tfModelo = new JTextField();
		tfModelo.setPreferredSize(new Dimension(200, 20));
		frame.add(new JLabel("Modelo:"));
		frame.add(tfModelo);

        tfMarca = new JTextField();
        tfMarca.setPreferredSize(new Dimension(200, 20));
        frame.add(new JLabel("Marca:"));
        frame.add(tfMarca);

        NumberFormatter numberFormatterAno = new NumberFormatter(NumberFormat.getIntegerInstance());
        numberFormatterAno.setValueClass(Integer.class); // garante que apenas valores inteiros serão aceitos
        tfAno = new JFormattedTextField(numberFormatterAno); // passa o formato para o text field
        tfAno.setPreferredSize(new Dimension(100, 20));
        frame.add(new JLabel("Ano:"));
        frame.add(tfAno); 

        NumberFormatter numberFormatterValorDiaria = new NumberFormatter(NumberFormat.getNumberInstance());
        numberFormatterValorDiaria.setValueClass(Double.class); // garante que apenas valores do tipo double serão aceitos
        tfValorDiaria = new JFormattedTextField(numberFormatterValorDiaria); // passa o formato para o text field
        tfValorDiaria.setPreferredSize(new Dimension(100, 20));
        frame.add(new JLabel("Valor da diária:"));
        frame.add(tfValorDiaria);

        btCadastrar = new JButton("Cadastrar");
        btCadastrar.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                // verificações para efetivar o cadastro de um novo carro com sucesso
                if (tfModelo.getText().isEmpty())
                    mensagemErro("O modelo não pode ser vazio.");
                else if (tfMarca.getText().isEmpty())
                    mensagemErro("A marca não pode ser vazia.");
                else if (tfAno.getText().isEmpty())
                    mensagemErro("O ano não pode ser vazio.");
                else if (tfValorDiaria.getText().isEmpty())
                    mensagemErro("O valor da diária não pode ser vazio.");
                else {
                   String modelo = tfModelo.getText();
                   String marca = tfMarca.getText();
                   
                   try {
                    int ano = Integer.parseInt(tfAno.getText());
                    double valorDiaria = Double.parseDouble(tfValorDiaria.getText());
                    cadastrar(modelo, marca, ano, valorDiaria);
                   }
                   catch (Exception e) {
                    mensagemErro(e.toString());
                   }
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

        modeloDefault = new DefaultTableModel();		
		modeloDefault.addColumn("Id");
		modeloDefault.addColumn("Modelo");
		modeloDefault.addColumn("Marca");
		modeloDefault.addColumn("Ano");
  		modeloDefault.addColumn("ValorDiária");
        modeloDefault.addColumn("Disponível");
		table = new JTable(modeloDefault);
		table.setPreferredSize(new Dimension(580, 400));
		table.getColumnModel().getColumn(0).setMaxWidth(50);
		table.getColumnModel().getColumn(1).setMaxWidth(300);
		table.getColumnModel().getColumn(2).setMaxWidth(300);
		table.getColumnModel().getColumn(3).setMaxWidth(80);
        table.getColumnModel().getColumn(4).setMaxWidth(80);
        table.getColumnModel().getColumn(5).setMaxWidth(80);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(table);
		frame.add(scroll);

        frame.setVisible(true);
    }

    private void cadastrar(String modelo, String marca, Integer ano, Double valorDiaria) {
        Carro carro = new Carro(modelo, marca, ano, valorDiaria);
        controleCarro.cadastrar(carro);
        // adiciona o novo carro à tabela
        modeloDefault.addRow(new Object[] { carro.getId(), carro.getModelo(), carro.getMarca(), carro.getAno(), carro.getValorDiaria(), carro.getDisponivel()});
    }

    private void excluir(int id) {
        controleCarro.excluir(id);
        modeloDefault.removeRow(table.getSelectedRow()); // remove a linha selecionada pelo usuário
        modeloDefault.fireTableDataChanged(); // atualiza a tabela
    }

    private void alterar() {

    }

    public void mensagemErro(String erro) { // método que imprime na tela os erros regulares
        JOptionPane.showMessageDialog(this, erro, "ERRO", JOptionPane.ERROR_MESSAGE);
    }
}